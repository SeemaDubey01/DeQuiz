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
<div><H1>${deQuizUser.dquUserName}</H1></div>
<div align="center" style="font-size:5vw;">
<!--  question number and question -->
<form:form action="/startquiz"  method="post" modelAttribute="deQuizUser">
  <form:hidden path="dquUserId" value="${deQuizUser.dquUserId}"/>
  <form:hidden path="dquQuizId" value="${deQuizUser.dquQuizId}"/>
  <form:hidden path="dquQuestionNo" value="${deQuizUser.dquQuestionNo}"/>
  <form:label path="dquMarks">Your points for last question is:<b>${deQuizUser.dquMarks}</b></form:label><p/>
  <form:label path="dquTotalMarks">Your total points for this is:<b>${deQuizUser.dquTotalMarks}</b></form:label> <p/>
	<form:button>Next Question</form:button>	
</form:form>
</div>
</body>
</html>