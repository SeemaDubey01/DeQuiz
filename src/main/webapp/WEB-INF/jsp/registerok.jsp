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
<form:form action="/startquiz" method="post"  modelAttribute="deQuizUser">
	<form:hidden path="dquQuizId" value ="${deQuizUser.dquQuizId}"/>
	<form:hidden path="dquUserId" value ="${deQuizUser.dquUserId}"/>
	<form:hidden path="dquQuestionNo" value ="${deQuizUser.dquQuestionNo}"/>
	<form:label path="dquQuizId">Quiz#: <span>${deQuizUser.dquQuizId}</span></form:label><p/>
	<form:label path="dquUserName">Quiz#: <span>${deQuizUser.dquUserName}</span></form:label><p/>
	<form:button>Continue</form:button>
</form:form>		
</div>
</body>
</html>