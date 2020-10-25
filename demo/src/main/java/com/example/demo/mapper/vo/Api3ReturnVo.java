package com.example.demo.mapper.vo;

public class Api3ReturnVo {

	private String 	stationName;	// 역명
	private int 	avgOfDay;		// 일 평균 승하차수
	
	public Api3ReturnVo(String stationName, int avgOfDay) {
		super();
		this.stationName = stationName;
		this.avgOfDay = avgOfDay;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getAvgOfDay() {
		return avgOfDay;
	}

	public void setAvgOfDay(int avgOfDay) {
		this.avgOfDay = avgOfDay;
	}

	
}
