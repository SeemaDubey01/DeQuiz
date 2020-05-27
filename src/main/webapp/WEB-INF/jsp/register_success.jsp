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
    form div {
		display: table-row;
	}
	form div div {
		display: table-cell;
	}

</style>
</head>
<body>
<div align="center">
<h2>Registration</h2>
<form:form action="/startQuiz" method="get" modelAttribute="deQuizUser">
<form:hidden path="dquUserId" value ="${deQuizUser.dquUserId}"/>
<form:hidden path="dquQuizId" value ="${deQuizUser.dquQuizId}"/>

<span>Dear </span><span>${deQuizUser.dquUserName}</span>
<span>Quiz Number:</span><span>${deQuizUser.dquQuizId}</span><span>&nbsp is going to start soon</span><br/><br/>
<form:button>continue</form:button>

</form:form>
</div>
</body>
</html>