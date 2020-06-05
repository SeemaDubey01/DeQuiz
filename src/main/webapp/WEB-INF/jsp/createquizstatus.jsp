<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeQui - Create Quiz</title>
</head>
<body>
<H2> Create Quiz Status</H2><p/>
<form:form action="/createquiz" method="get"  modelAttribute="quizmaster">
	<form:hidden path="deqmQuizId" value ="${quizmaster.deqmQuizId}"/>
	<form:hidden path="deqmQuestionNo" value ="${quizmaster.deqmQuestionNo}"/>
	<form:label path="deqmQuizId">Quiz#: <span>${quizmaster.deqmQuizId}</span></form:label><p/>
	<form:label path="deqmQuestionNo">Question: <span>${quizmaster.deqmQuestionNo}</span></form:label><p/>
	<form:button>Create Another</form:button>
</form:form>

<a href="/">Back</a>
</body>
</html>