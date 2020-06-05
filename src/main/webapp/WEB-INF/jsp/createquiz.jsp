<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeQuiz - Create Quiz</title>
</head>
<body>
<div align="center">
		<h2>Create your quiz</h2>
		<form:form action="/createquizstatus" method="post" modelAttribute="quizmaster">
		<form:hidden path="deqmQuizId" value ="${quizmaster.deqmQuizId}"/>
		<form:hidden path="deqmQuestionNo" value ="${quizmaster.deqmQuestionNo}"/>
			<form:label path="deqmQuizId"><H2> Quiz#: ${quizmaster.deqmQuizId}</H2></form:label><p/>
			<form:label path="deqmQuestionNo">Question#: ${quizmaster.deqmQuestionNo}</form:label><p/>
			<form:label path="deqmQuestion"> Q: </form:label>
			<form:input path="deqmQuestion"/><p/> 
			<form:label path="deqmOption_a"> Option A: </form:label>
			<form:input path="deqmOption_a" /><p/>
			<form:label path="deqmOption_b"> Option B: </form:label>
			<form:input path="deqmOption_b" /><p/>
			<form:label path="deqmOption_c"> Option C: </form:label>
			<form:input path="deqmOption_c" /><p/>
			<form:label path="deqmOption_d"> Option D: </form:label>
			<form:input path="deqmOption_d" /><p/>
			<form:label path="deqmAnswer"> Correct option: </form:label><p/>
			<form:input path="deqmAnswer" /><p/>
			<form:label path="deqmQuizActive"> Active: </form:label>
			<form:input path="deqmQuizActive" value="Y" /><p/>
			<form:label path="deqmTimer"> Timer (seconds): </form:label>
			<form:input path="deqmTimer" value="15" /><p/>
			<form:button>submit</form:button>
		</form:form>
	</div>
</body>
</html>