<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Online Quiz for Everyone - DeQuiz</title>
<style type="text/css">
	.error {
		color: red;
		font-style: italic;
	}
</style>
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join existing quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
</head>
<body>
<H2>Admin Login</H2><p/>
<div align="center" style="font-size:min(5vw,40);">
		<table>
		<form:form action="/loginadmin" method="post" modelAttribute="deQuizLogin">
		<tr>
			<td><form:label path="dqlUserId">User ID#:</form:label></td>
			<td><form:input path="dqlUserId"  /></td>
			<td><form:errors cssClass="error" /></td>
		</tr><tr>
			<td><form:label path="dqlPassword">Password:</form:label></td>
			<td><form:password path="dqlPassword" /></td>
		</tr><tr>
			<td colspan="3" align="center"><form:button>submit</form:button></td>
		</tr>
		</form:form>
		</table>
	</div>
	<br/><br/>
<div align="center" style="font-size:(5vw,min);">
<table Style="border:1px solid black;">
<tr><td><a href="/">Home</a></td>
<td><a href="/aboutUs">About Us</a></td>
<td><a href="/joinQuiz">Join Quiz</a></td>
<td><a href="/admin">Admin</a></td>
<td><a href="/contactUs">Contact Us</a></td></tr>
</table>
</div>
</body>
</html>
