<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDeletePro</title>
</head>
	<c:choose>
		<c:when test="${success eq true}">
			<script>
				alert("삭제 되었습니다.");
				location.href='${contextPath }/boardAdvance/boardList';
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("비밀번호를 확인해 주세요.");
				history.back(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>