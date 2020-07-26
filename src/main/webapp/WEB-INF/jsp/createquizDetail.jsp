<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeQuiz - Create Quiz Details</title>
</head>
<body>
<H2> Create Detail Quiz</H2><p/>
<form:form action="/createquiz" method="post"  modelAttribute="quizmaster">
<form:hidden path="dqlUserId" value ="${quizmaster.dqlUserId}"/>
<form:hidden path="deqmQuizDesc" value ="${quizmaster.deqmQuizDesc}"/>
<form:hidden path="deqmQuizActive" value ="${quizmaster.deqmQuizActive}"/>
<form:hidden path="deqmTimer" value ="${quizmaster.deqmTimer}"/>
<form:hidden path="deqmQuizId" value ="${quizmaster.deqmQuizId}"/>

	
	<form:button>Create Quiz Details</form:button>
</form:form>

<a href="/getUserQuizList">Back</a>
</body>
</html>