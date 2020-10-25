package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.StationInfoMapper;
import com.example.demo.mapper.vo.Api3ReturnVo;
import com.example.demo.mapper.vo.Api4ReturnVo;
import com.example.demo.mapper.vo.Api5ReturnVo;
import com.example.demo.model.StationInfo;
import com.example.demo.service.ApiService;
import com.example.demo.serviceimpl.ApiServiceImpl;
import com.example.demo.util.CsvParser;

import io.swagger.annotations.ApiOperation;

//swagger: http://localhost:8080/swagger-ui.html
//h2	 : http://localhost:8080/h2-console

@RestController
//스프링이 알아서 Controller로 인식
//이 어노테이션을 사용하면 json 형태로 알아서 응답을 보내준다
//이 컨트롤러 전체 메소드에 적용됨. 만약 method 별로 쓰려면 @RespnseBody

@RequestMapping("/home/*")
//이 Controller에 대한 경로 설정을 해야만 swagger-ui 호출 가능
//root 하위에 해당 controller에 대한 url 을 정의해줘야하는거였음ㅇㅇ
public class MainController {

	private StationInfoMapper mapper;
	private ApiService apiService;

	// csv 파일의 한 line에서 승하차수를 제외한 데이터컬럼수(ex. 1호선,150,서울역(1),"3,364,130",~~~ => 3개)
	private final int OTHER_COLS_NUM = 3;
	
	// 스프링부트가 알아서 mapper 만들어서 생성해줌
	public MainController(StationInfoMapper mapper) {
		this.mapper = mapper;
		this.apiService = new ApiServiceImpl(mapper);
	}
	
	//*****************************************************************************//
	
	@ApiOperation(value = "요구사항2-1 : StationInfo 테이블 신규 생성")
	@PostMapping("/api1")
	public String createTable(){
	
		//mapper.createTable();
		apiService.createTable();
		
		return "CREATE TABLE SUCCESS !";
	}
	
	@ApiOperation(value = "요구사항2-2 : 데이터파일(.csv)의 각 레코드를 데이터베이스에 저장")
	@PostMapping("/api2")
	public String insertData() throws IOException, Exception {
		
		ClassPathResource classPathResource = new ClassPathResource("data/test_data.csv");
		CsvParser csvParser = new CsvParser(classPathResource.getInputStream());
		
		if(csvParser.hasNext()) {
			csvParser.readNextLine();		// 첫 라인 버림
		}
		
		while(csvParser.hasNext()) 
		{
			String line = csvParser.readNextLine();					// 한 라인 꺼내옴
			
			String[] stationRow = csvParser.inlineSpliter(line);	// 해당 라인 데이터 꺼내서 배열로 저장
						
			// 승하차수 데이터만큼 반복(승하차수 데이터가 있는 컬럼부터 시작)
			int dataCnt = 1;
			for(int i = OTHER_COLS_NUM ; i < stationRow.length ; i++ ) {
				
				// 해당 라인의 데이터만큼 db insert
				apiService.insertData(stationRow[1]
									 ,"2019" + String.format("%02d", dataCnt)
									 ,stationRow[0]
									 ,stationRow[2]
									 ,Integer.parseInt(stationRow[i]));
				
				//stationRow[0] : 호선(lineInfo)
				//stationRow[1] : 역번호(stationNo)
				//stationRow[2] : 역명(stationName)
				//stationRow[3]~stationRow[14] : 승하차수(numOfMonth)
				
				dataCnt++;
			}
		}
		
		return "DATA INSERT SUCCESS !";
	}

	@ApiOperation(value = "요구사항3 : 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력")
	@GetMapping("/api3")
	public ArrayList<Api3ReturnVo> getDayAvgTop10StationlList() {
		
		// stationNo에 해당하는 대상 return
		ArrayList<Api3ReturnVo> api3ReturnVoList = apiService.getDayAvgTop10StationList();
		
		return api3ReturnVoList;
	}
	
	@ApiOperation(value = "요구사항4 : 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력")
	@GetMapping("/api4")
	public Api4ReturnVo getMonAvgLowestStation() {
		
		// stationNo에 해당하는 대상 return
		Api4ReturnVo api4ReturnVo = apiService.getMonAvgLowestStation();
		
		return api4ReturnVo;
	}
	
	@ApiOperation(value = "요구사항5 : 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력")
	@GetMapping("/api5")
	public Api5ReturnVo getDiffMaxMinBiggestStation() {
		
		// stationNo에 해당하는 대상 return
		Api5ReturnVo api5ReturnVo = apiService.getDiffMaxMinBiggestStation();
		
		return api5ReturnVo;
	}
	
//	//*****************************************************************************//
//	
//	//TEST CODE
//	@ApiOperation(value = "TEST : hellowolrd 출력")
//	@GetMapping("/helloworld")
//	public String getHelloWorld() {
//
//		return "helloworld";
//	}
//	
//	@ApiOperation(value = "TEST : stationNo를 입력받아 해당하는 stationInfo 출력")
//	@GetMapping("/station")
//	public ArrayList<StationInfo> getStationInfoByStationNo(@RequestParam("stationNo") String stationNo) {
//		
//		// stationNo에 해당하는 대상 return
//		ArrayList<StationInfo> stationList = mapper.getStationInfoByStationNo(stationNo);
//		
//		return stationList;
//	}
	
}
