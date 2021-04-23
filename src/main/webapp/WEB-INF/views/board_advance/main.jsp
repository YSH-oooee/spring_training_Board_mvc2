<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<%--

	[ 실습 권장 사항 ]

	- 기술은 타인이 만들어주지 않습니다. 내가 스스로 경험하고 깨닫고 체득해야 합니다.
	- 한번에 제대로 완성할 마음보다는 100번 만들어보겠다는 마음으로 여러번 반복해서 즐겁게 구현하세요.
	- 스프링을 공부하기에 어려움을 느끼는 기능들(페이징 구현 , 검색기능 구현 , 계층형 무한 댓글)이 모두 구현되어 있습니다.
	- 다양한 에러와 상황을 경험하고 어떤상황에 어떤 에러가 발생하는지 등등을 잘 정리하고 그 상황을 최대한 스스로 해결해보세요.
	 
	

	[ 구현 방안 ]
	
	A안
	
	STEP 1. 먼저 순수한 CRUD 기능만 동작하도록 구현 (list,info,insert,update,delete)
	STEP 2. 검색 , 페이징기능 구현 
	STEP 3. 계층형 댓글 구현
	STEP 4. 부트스트랩 테마 디자인에 기능 복사하여 디자인 완성 
	
	
	B안
	
	STEP 1. 계층형 댓글을 제외한 검색기능 , 페이징처리와 , 부트스트랩 , CRUD를 동시에 구현
	STEP 2. 계층형 댓글 구현


	C안
	
	자신이 좋은 방법으로


	
[ 계층형 댓글 처리 관련 정보 ]


num     : 게시글의 고유번호  ( 원본글과 댓글은 모두 num이 다르다. )
ref     : 게시글의 그룹번호  ( 한 원본글과 그 아래 있는 댓글들은 모두 ref가 같다. )
reLevel : 게시글의 계층 	 (주로 depth로 표현)
		
		원본글 : 1
		원본글의 댓글 : 2
		원본글의 댓글의 댓글 : 3
		원본글의 댓글의 댓글의 댓글 : 4
		
reStep : 한 게시글 그룹의 게시글 순서

		 쿼리문에서 order by로 정렬하여 화면에 표기한다.
						ref desc [내림차순]
						re_step  [오름차순] 
		 
		 - 마지막글 추가이면 re_step = restep + 1을 해주면 된다.
		 - (헷갈림)중간글 추가(가운데 있는 댓글의 댓글)이면 
		 	내가 추가하는 게시글의 re_step보다 re_step = re_step+1로 들어가고
		   추가되는 위치보다 뒤에 있는 re_step은 전부다 +1씩 늘려준다.
						

예시 (위에서 아래로 순서대로 작성했다는 가정)

원본글1								: num = 1 / ref = 1 / level = 1 / step = 1 
	> 댓글1-1						: num = 2 / ref = 1 / level = 2 / step = 2
		> 댓글 1-1-1				: num = 3 / ref = 1 / level = 3 / step = 3
	> 댓글1-2						: num = 4 / ref = 1 / level = 2 / step = 4
		> 댓글 1-2-1				: num = 5 / ref = 1 / level = 3 / step = 5
		> 댓글 1-2-2				: num = 6 / ref = 1 / level = 3 / step = 6
	> 댓글1-3						: num = 7 / ref = 1 / level = 2 / step = 7
	
원본글2								: num =  8 / ref = 2 / level = 1 / step = 1 
	> 댓글2-1						: num =  9 / ref = 2 / level = 2 / step = 2 
		> 댓글 2-1-1				: num = 10 / ref = 2 / level = 3 / step = 3
	> 댓글2-2						: num = 11 / ref = 2 / level = 2 / step = 4

	

	USE SPRING_BOARD

	CREATE TABLE BOARD_ADVANCE(
		NUM INT(10) NOT NULL PRIMARY KEY,
	    WRITER VARCHAR(20),
	    EMAIL VARCHAR(20),
	    SUBJECT VARCHAR(50),
	    PASSWORD VARCHAR(20),
	    REG_DATE DATE,
	    REF INT(10),             
	    RE_STEP INT(10),     	  
	    RE_LEVEL INT(10),		  
	    READ_COUNT INT(10),
	    CONTENT VARCHAR(20)
	);
--%>

<body>
	<div align="center" style="padding-top: 100px">
		<img src="${contextPath }/resources/images/spring.png" alt="spring심볼" width="800px" height="500px"><br><br><br><br>
		<input type="button" value="게시판 보기" onclick="location.href='${contextPath }/boardAdvance/boardList'">
	</div>
</body>
</html>