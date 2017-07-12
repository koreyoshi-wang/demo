<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jasmine Spec Runner v2.5.2</title>

<link rel="shortcut icon" type="image/png"
	href="../jasmine-standalone-2.5.2/lib/jasmine-2.5.2/jasmine_favicon.png">
<link rel="stylesheet"
	href="../jasmine-standalone-2.5.2/lib/jasmine-2.5.2/jasmine.css">

<script src="../jasmine-standalone-2.5.2/lib/jasmine-2.5.2/jasmine.js"></script>
<script
	src="../jasmine-standalone-2.5.2/lib/jasmine-2.5.2/jasmine-html.js"></script>
<script src="../jasmine-standalone-2.5.2/lib/jasmine-2.5.2/boot.js"></script>

<!-- include spec files here... -->
<script src="../jasmine-standalone-2.5.2/src/Login.js"></script>
<script src="../jasmine-standalone-2.5.2/spec/LoginTest.js"></script>

</head>
<body>
	<h1>Test Ajax</h1>
	<p>
	<form action="/" method="post" name="form">
		<br> username<input type="text" size="10" maxlength="8"
			id="userName" name="name" onblur="validate()"> <span
			id="info"></span> <br> 输入商品名： <input type="text" size="10"
			maxlength="8">
	</form>
</body>
</html>
