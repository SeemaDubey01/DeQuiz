<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Registration Status</title>
</head>
<body>
<H2>Registration Status <span></span></H2>
<div align="center" style="font-size:min(5vw,40);">
<form:form action="/createquiz" method= "get" modelAttribute="deQuizLogin">
	<form:label path="dqlUserId">Admin: <span>${deQuizLogin.dqlUserId}</span>Welcome to DeQuiz<br/>Now you can start creating quiz</form:label><p/>
    <form:button>createQuiz</form:button>
</form:form>		
</div>
</body>
</html>