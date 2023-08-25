<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/resources/css/signUp.css" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="signUpDiv">
		<div class="borderDiv">
			<form action="/user/signUp" method="post">
			
				<div class="inputDiv">
					<input type="email" class="input" name="email" value="" placeholder="이메일을 입력해주세요."/>
				</div>
				<div id="emailCheck">이메일이 유효하지 않습니다.</div>
				<div class="bottomDiv">
					<button type="button" class="emailCheckBtn" disabled="disabled">인증번호 받기</button>
					<input id="emailNum" placeholder="인증번호 6자리 입력" maxlength="6">
					<button type="button" class="btn">인증확인</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/resources/js/signUp.js"></script>
</body>
</html>