package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CsvParser {
	
	private BufferedReader br;
	private int readLimit = 1;
	
	public CsvParser(InputStream inputStream) throws UnsupportedEncodingException {
		InputStreamReader isr = new InputStreamReader(inputStream, "EUC-KR");
		br = new BufferedReader(isr);
	}
	
	public boolean hasNext() throws IOException {
		
		boolean hasNext = false;
		br.mark(readLimit);
		if(br.read() != -1) {
			hasNext = true;
			
		} else {	// 문자열 끝인 경우 reset 타면 에러나므로 바로 return false 처리
			hasNext = false;
			return hasNext;
		}
		
		br.reset();
		return hasNext;
	}

	// 한줄만 읽어서 반환
	public String readNextLine() throws IOException {
		
		String line;
		
		if ((line = br.readLine()) != null) {			
			return line;			
		} else {
			return "";
		}
		
	}

	// 입력받은 line을 데이터컬럼 별로 분리하여 배열로 반환
	public String[] inlineSpliter(String line) throws IOException {
		
		// 1) 쌍따옴표 안에 든 콤마(,) 및 쌍따옴표 제거
		StringBuffer preProcData = new StringBuffer();
		
		boolean checkFlag = false;	// (첫번째 쌍따옴표를 만난순간 ~ 두번째 쌍따옴표를 만난순간) 구간에만 true
		
		for(int i = 0; i < line.length() ; i++) {
			
			char c = line.charAt(i);
			
			if(c == '"' && !checkFlag) {		// 첫번째 쌍따옴표 만남
				checkFlag = true;
				continue;						// 쌍따옴표도 제거
				
			} else if (c == '"' && checkFlag) {	// 두번째 쌍따옴표 만남
				checkFlag = false;
				continue;						// 쌍따옴표도 제거
			}
			
			if(checkFlag && c == ',' ) {
				continue;	// 제거
			}

			preProcData.append(c);
		}
		
		// 2) 콤마(,) 기준으로 split 해서 배열에 담음
		String[] stationRow = preProcData.toString().split(",");
		
		return stationRow;
		
	}

//	전체 내용을 읽어서 반환한 csvParser
//	public CsvParser() {
//		super();
//	}
//
//	public String getResourceAsString(String path) {
//		
//		try {
//			Resource resource = new ClassPathResource(path);
//			//ClassPathResource classPathResource = new ClassPathResource(path);
//			
//			try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"EUC-KR"))) {
//				
//				StringBuilder builder = new StringBuilder();
//				String line;
//				
//				while ((line = br.readLine()) != null) {
//					builder.append(line).append('\n');
//				}
//				
//				return builder.toString();
//			}
//			
//		} catch (IOException e) {
//			throw new IllegalStateException(e);
//		}
//	}
	
}
