package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.mapper.vo.Api3ReturnVo;
import com.example.demo.mapper.vo.Api4ReturnVo;
import com.example.demo.mapper.vo.Api5ReturnVo;
import com.example.demo.model.StationInfo;

@Mapper
public interface StationInfoMapper {

	//**********************************************************************************
	
	// 요구사항2-1 : StationInfo 테이블 신규 생성
	@Insert("CREATE TABLE STATIONINFO "
			+ "(STATIONNO VARCHAR(255) NOT NULL "
			+ ",MONTH VARCHAR(255) NOT NULL "
			+ ",LINEINFO VARCHAR(255) "
			+ ",STATIONNAME VARCHAR(255) "
			+ ",NUMOFMONTH INT, "
			+ "PRIMARY KEY (STATIONNO,MONTH)    "
			+ ")" )
	int createTable();
	
	// 요구사항2-2 : 데이터파일(.csv)의 각 레코드를 데이터베이스에 저장
	@Insert("INSERT INTO STATIONINFO VALUES(#{stationNo},#{month},#{lineInfo},#{stationName},#{numOfMonth} )")
	int insertData(@Param("stationNo") String stationNo,
				   @Param("month") String month,
				   @Param("lineInfo") String lineInfo,
				   @Param("stationName") String stationName,
				   @Param("numOfMonth") int numOfMonth);
	
	// 요구사항3 : 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력
	@Select("SELECT StationName, (SUM(NumOfMonth) / 365) AvgOfDay "
			+ "FROM StationInfo "
			+ "GROUP BY StationName "
			+ "ORDER BY AvgOfDay DESC "
			+ "FETCH FIRST 10 ROWS ONLY")
	ArrayList<Api3ReturnVo> getDayAvgTop10StationList();

	// 요구사항4 : 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력
	@Select("SELECT StationName, AVG(NumOfMonth) AvgOfMonth "
			+ "FROM StationInfo "
			+ "GROUP BY StationName "
			+ "ORDER BY AvgOfMonth ASC "
			+ "FETCH FIRST 1 ROWS ONLY")
	Api4ReturnVo getMonAvgLowestStation();
	
	// 요구사항5 : 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력
	@Select("SELECT StationName "
			+ "FROM StationInfo "
			+ "GROUP BY StationName "
			+ "ORDER BY (MAX(NumOfMonth) - MIN(NumOfMonth)) DESC "
			+ "FETCH FIRST 1 ROWS ONLY")
	Api5ReturnVo getDiffMaxMinBiggestStation();
	
	//**********************************************************************************

	// TEST CODE
	@Select("SELECT * FROM StationInfo WHERE stationNo = #{stationNo}")
	ArrayList<StationInfo> getStationInfoByStationNo(@Param("stationNo") String stationNo);	
	
}
