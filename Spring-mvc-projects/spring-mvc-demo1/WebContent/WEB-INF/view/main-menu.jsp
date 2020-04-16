<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/my-test.css">

<script src="${pageContext.request.contextPath}/resources/simple-test.js"></script>
</head>
<body>
<h2>spring mvc demo - home page</h2>

<br>
<br>

<a href="showform">display hello world form</a>
<br><br>

<img src="${pageContext.request.contextPath}/resources/hello.png" />

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>
</body>
</html>