<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join existing quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Online Quiz for Everyone - DeQuiz</title>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="/script/dequiz.js"></script>
</head>
<body>
<!--  page header containg heading and menu -->
<div id="headerpage"></div>
<!--  content block -->
<div class="content-window">
<H1>Admin Login</H1><p/>
<div align="center" style="font-size:min(5vw,40);">
		<table>
		<form:form action="/QuizMaster/loginCheck" method="post" modelAttribute="deQuizLogin">
		<tr>
			<td><form:label path="dqlUserId">User ID#:</form:label></td>
			<td><form:input path="dqlUserId"  /></td>
			<td><form:errors path="dqlUserId" cssClass="error" /></td>
		</tr><tr>
			<td><form:label path="dqlPassword">Password:</form:label></td>
			<td><form:password path="dqlPassword" /></td>
			<td><form:errors path="dqlPassword" cssClass="error" /></td>
		</tr>
		<tr><td colspan="3" align="center"><form:button>submit</form:button></td></tr><tr><td><p/></td></tr>
		<tr><td colspan="3" align="center"><a href="/signUp">Not Registered SignUp Here</a></td></tr>
		</form:form>
		</table>
	</div>
	<br/><br/>
</div>
<!--  end of content block -->
<!--  Footer -->
<div id="footerpage" class="footer"></div>
<!--  end of Footer -->
</body>
</html>