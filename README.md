## *** API 명세서 - 서울교통공사 승하차 순위 데이터 적재 및 조회용API 개발
### - POST /home/api1
#### 	> 데이터를 저장하기 위한 StationInfo 테이블 신규 생성
### - POST /home/api2
#### 	> 데이터파일(.csv)의 각 레코드를 데이터베이스에 저장
### - GET /home/api3
#### 	> 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력
### - GET /home/api4
#### 	> 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력
### - GET /home/api5
#### 	> 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력
##
### *** 빌드 방법
### - STS(sts-4.8.0.RELEASE) 활용
####  1) https://github.com/wanted1213/NICE_HOMEWORK.git 에서 프로젝트 다운로드
#### 	2) STS에서 해당 프로젝트(demo) Import (Maven > Existing Maven Projects)
#### 	3) Maven 라이브러리 다운로드(대기 시 자동)
#### 	4) Maven > Update Project
####  5) Run As > Maven clean
#### 	6) Run As > Maven build...
#### 	7) Goals 항목에 package 입력, Profiles 항목 공란으로 비우고 > Run
####  8) /target 경로에 "demo-0.0.1-SNAPSHOT.jar" 파일 생성
## 
## *** 실행 방법
### 1) STS(sts-4.8.0.RELEASE) 활용
#### - STS에 import 받은 demo 프로젝트 우클릭 > Run As > Spring Boot App으로 실행
### 
### 2) jar 파일 활용
#### - /demo/target/demo-0.0.1-SNAPSHOT.jar를 직접 수행
#### ex) java -jar demo-0.0.1-SNAPSHOT.jar
### 
### => 1 or 2 의 방법대로 실행 후 아래 내용 차례대로 실행
#### > http://localhost:8080/swagger-ui.html 접속
#### > main-contorller 박스 클릭
#### > POST /home/api1 클릭 > try it out 클릭 > execute 클릭
#### > POST /home/api2 클릭 > try it out 클릭 > execute 클릭
#### > GET /home/api3 클릭 > try it out 클릭 > execute 클릭
#### > GET /home/api4 클릭 > try it out 클릭 > execute 클릭
#### > GET /home/api5 클릭 > try it out 클릭 > execute 클릭
## 
## *** 개발환경
### IDE : sts-4.8.0.RELEASE
### JAVA : jdk1.8.0_271
### 개발Framework : Springboot 2.3.4.RELEASE
### Springfox Swagger : 2.9.2
### Mybatis : mybatis-spring-boot-starter 2.1.3
### DB : h2
