<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<%--
	[ 실습 순서 '예시' ]

	0. 데이터 베이스 및 테이블 생성 
	
		CREATE DATABASE SPRING_BOARD;
		
		USE SPRING_BOARD;
		
		CREATE TABLE BOARD(
			NUM INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
		    WRITER VARCHAR(50),
		    EMAIL VARCHAR(50),
		    SUBJECT VARCHAR(50),
		    PASSWORD VARCHAR(20),
		    REG_DATE DATE,
	        READ_COUNT INT,
		   	CONTENT VARCHAR(200)
		);
		
		SELECT * FROM BOARD;
		
	1. web.xml에 한글 필터 설정
	2. POM.xml에 dependency 추가 
	
		- https://mvnrepository.com/ 에서 복사 혹은 구글링
	
		2-1) spring-jdbc 
		2-2) mysql-connector-java
		2-3) mybatis
		2-4) mybatis-spring 
	
	3. root-context.xml에 DB연결 설정
	4. mybatis-config.xml 파일 및 매퍼 파일 생성
	5. DTO 생성(class 위에 @Component) >> 연결
	6. 매퍼에서 쿼리문 작성
	7. DAO , DAOImple 생성(class 위에 @Controller / 메소드 위에 @RequestMapping(value="", method=))
	8. Service , ServiceImpl 생성(ServiceImpl 생성시 add로 service 추가 / ServiceImpl에 @Service)
	9. 컨트롤러 생성
	10. 화면 생성
--%>

<body>
	<div align="center" style="padding-top: 100px">
		<img src="resources/images/spring.PNG" alt="jsp심볼" width="800px" height="500px"><br><br><br><br>
		<input type="button" value="게시판 보기" onclick="location.href='boardList'">
	</div>
</body>
</html>