package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.mapper.StationInfoMapper;
import com.example.demo.mapper.vo.Api3ReturnVo;
import com.example.demo.mapper.vo.Api4ReturnVo;
import com.example.demo.mapper.vo.Api5ReturnVo;

public interface ApiService {

	//api1
	int createTable();
	
	//api2
	int insertData(String stationNo, String month, String lineInfo, String stationName, int numOfMonth);
		
	//api3
	ArrayList<Api3ReturnVo> getDayAvgTop10StationList();
	
	//api4
	Api4ReturnVo getMonAvgLowestStation();
	
	//api5
	Api5ReturnVo getDiffMaxMinBiggestStation();
	
	
}
