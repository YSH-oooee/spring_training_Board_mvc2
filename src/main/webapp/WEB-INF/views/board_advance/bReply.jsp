<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bReply</title>
<script src="${contextPath }/resources/js/jquery-3.5.1.min.js"></script>
<link href="${contextPath }/resources/css/styles.css" rel="stylesheet" />
<script>

	$(document).ready(function(){
		
		$("form").submit(function(){
			
			if ($("#writer").val() == ""){
				alert("작성자를 입력하세요.");
				$("#writer").focus();
				return false;
			}
			
			if ($("#subject").val() == ""){
				alert("제목을 입력하세요.");
				$("#subject").focus();
				return false;
			}
			
			
			if ($("#email").val() == ""){
				alert("이메일을 입력하세요.");
				$("#email").focus();
				return false;
			}	
			
			if ($("#password").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#password").focus();
				return false;
			}
			
			var checkY = confirm("등록하시겠습니까?");
			
			if (checkY) {
				return true;
			}
					
		});
		
	});
</script>
</head>
<body>
	<div align="center" style="padding-top: 100px">
		<form action="boardReplyWrite"  method="post" ">
			<div class="bs-docs-section">
				<div class="row">
					<div class="col-lg-12">
						<div class="page-header" align="center">
							<h2>Write Reply</h2>
							<br>
						</div>
						<div class="bs-component">
							<table class="table table-hover" style="width: 700px;">
								<colgroup>
									<col width="20%">
									<col width="80%">
								</colgroup>
								<tr class="table-default">
									<td align="center">Base Board</td>
									<td>${bdto.subject}</td>
								</tr>
								<tr class="table-default">
									<td align="center"><span style="color: red">*</span>Writer</td>
									<td><input type="text" class="form-control" id="writer" name="writer" /></td>
								</tr>
								<tr class="table-default">
									<td align="center"><span style="color: red">*</span>Subject</td>
									<td><input type="text" class="form-control" id="subject" name="subject" /></td>
								</tr>
								<tr class="table-default">
									<td align="center"><span style="color: red">*</span>E-mail</td>
									<td><input type="email" class="form-control" id="email" name="email" /></td>
								</tr>
								<tr class="table-default">
									<td align="center"><span style="color: red">*</span>Password</td>
									<td><input type="password" class="form-control" id="password" name="password" /></td>
								</tr>
								<tr class="table-default">
									<td align="center">Content</td>
									<td><textarea class="form-control" rows="10" cols="50" id="content" name="content"></textarea></td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<input type="hidden" name="ref" value="${bdto.ref}">
										<input type="hidden" name="reStep" value="${bdto.reStep}">
										<input type="hidden" name="reLevel" value="${bdto.reLevel}">
										<input type="submit" class="btn btn-primary btn-sm" value="Reply" />
										<input type="reset"  class="btn btn-primary btn-sm" value="Reset" />
										<input type="button" class="btn btn-primary btn-sm" onclick="location.href='${contextPath }/boardAdvance/boardList'" value="Main">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>