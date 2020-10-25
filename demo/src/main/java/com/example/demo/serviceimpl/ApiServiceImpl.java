package com.example.demo.serviceimpl;

import java.util.ArrayList;

import com.example.demo.mapper.StationInfoMapper;
import com.example.demo.mapper.vo.Api3ReturnVo;
import com.example.demo.mapper.vo.Api4ReturnVo;
import com.example.demo.mapper.vo.Api5ReturnVo;
import com.example.demo.service.ApiService;

public class ApiServiceImpl implements ApiService {
	
	private StationInfoMapper mapper;
	
	public ApiServiceImpl(StationInfoMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public int createTable() {
		// TODO Auto-generated method stub
		return mapper.createTable();
	}

	@Override
	public int insertData(String stationNo, String month, String lineInfo, String stationName, int numOfMonth) {
		// TODO Auto-generated method stub
		return mapper.insertData(stationNo
								,month
								,lineInfo
								,stationName
								,numOfMonth);
	}

	@Override
	public ArrayList<Api3ReturnVo> getDayAvgTop10StationList() {
		// TODO Auto-generated method stub
		return mapper.getDayAvgTop10StationList();
	}

	@Override
	public Api4ReturnVo getMonAvgLowestStation() {
		// TODO Auto-generated method stub
		return mapper.getMonAvgLowestStation();
	}

	@Override
	public Api5ReturnVo getDiffMaxMinBiggestStation() {
		// TODO Auto-generated method stub
		return mapper.getDiffMaxMinBiggestStation();
	}



}
