<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bList</title>
</head>
<body>

	<div align="center" style="padding-top: 100px">
		<h1>게시글 보기</h1>
		<br>
		<table border="1" style="width: 700px">
			<tr align="center">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			
		<c:forEach var="board" items="${boardList}">
			<tr align="center">
				<td>${board.num}</td>
				<td><a href="boardInfo?num=${board.num}" style="text-decoration: none">${board.subject}</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
				<td>${board.readCount}</td>
			</tr>
		</c:forEach>
		</table>
		
	</div>

</body>
</html>