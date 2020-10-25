package com.example.demo.model;

public class StationInfo {

	private String 	stationNo;		// 역번호
	private String  month;			// YYYYMM
	private String 	lineInfo;		// 호선정보
	private String 	stationName;	// 역명
	private int 	numOfMonth;		// 월별승하차수
	
	public StationInfo(String stationNo, String month, String lineInfo, String stationName, int numOfMonth) {
		super();
		this.stationNo = stationNo;
		this.month = month;
		this.lineInfo = lineInfo;
		this.stationName = stationName;
		this.numOfMonth = numOfMonth;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getLineInfo() {
		return lineInfo;
	}

	public void setLineInfo(String lineInfo) {
		this.lineInfo = lineInfo;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getNumOfMonth() {
		return numOfMonth;
	}

	public void setNumOfMonth(int numOfMonth) {
		this.numOfMonth = numOfMonth;
	}

}
