package com.example.demo.mapper.vo;

public class Api4ReturnVo {

	private String 	stationName;	// 역명
	private int 	avgOfMonth;		// 월 평균 승하차수
	
	public Api4ReturnVo(String stationName, int avgOfMonth) {
		super();
		this.stationName = stationName;
		this.avgOfMonth = avgOfMonth;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getAvgOfMonth() {
		return avgOfMonth;
	}

	public void setAvgOfMonth(int avgOfMonth) {
		this.avgOfMonth = avgOfMonth;
	}

}
