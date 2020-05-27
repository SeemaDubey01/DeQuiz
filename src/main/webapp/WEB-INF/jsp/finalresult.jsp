<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<H1> Final Result</H1>
<div align="center" style="font-size:min(5vw,40);">
<form:form action="/joinQuiz" method="get" modelAttribute="deQuizUser">
	<p> Dear ${deQuizUser.dquUserName}, your total marks: ${deQuizUser.dquTotalMarks}</p>
<form:button >Join other quiz</form:button>
</form:form>
</div>
</body>
</html>