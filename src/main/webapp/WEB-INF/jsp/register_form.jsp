<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>JoinQuiz</title>
<style type="text/css">
	.error {
		color: red;
		font-style: italic;
	}
</style>
</head>
<body>
	<H1>Join Quiz</H1>
	<div align="center" style="font-size:min(5vw,40);">
		<h2>Participants please enter details</h2>
		<table>
		<form:form action="/joinQuiz" method="post" modelAttribute="deQuizUser">
		<tr>
			<td><form:label path="dquQuizId">Quiz#:</form:label></td>
			<td><form:input path="dquQuizId" type = "number" /></td>
			<td><form:errors path="dquQuizId" cssClass="error" /></td>
		</tr><tr>
			<td><form:label path="dquUserName">Your Name:</form:label></td>
			<td><form:input path="dquUserName" /></td>
			<td><form:errors path="dquUserName" cssClass="error" /></td>
		</tr><tr>
			<td colspan="3" align="center"><form:button>submit</form:button></td>
		</tr>
		</form:form>
		</table>
	</div>
</body>
</html>