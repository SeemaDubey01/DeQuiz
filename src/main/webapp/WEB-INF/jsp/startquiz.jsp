<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<h1>Start Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
<form:form action="/showresult"  method="post" modelAttribute="deQuizMaster">
  <div>
  <div>${deQuizMaster.deqmQuestion}</div><p/>
  </div>
  <div>
  <form:hidden path="deqmQuizId" value="${deQuizMaster.deqmQuizId}"/>
  <form:hidden path="deqmQuestionNo" value="${deQuizMaster.deqmQuestionNo}"/>
  <form:hidden path="dquUserId" value="${deQuizMaster.dquUserId}"/>
  <form:hidden path="deqmAnswer" value="${deQuizMaster.deqmAnswer}"/>
  <form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Red" value = "a" /> 
  <form:input path="deqmOption_a" readonly="true" cssStyle="color: white;background-color:DodgerBlue" value = " ${deQuizMaster.deqmOption_a}" />
  </div><br/>
  <div>
  <form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Red" value = "b" /> 
  <form:input path="deqmOption_b" readonly="true" cssStyle="color: white;background-color:Red" value = " ${deQuizMaster.deqmOption_b}" />
  </div><br/>
  <div>
  <form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Green" value = "c" />
  <form:input path="deqmOption_c" readonly="true" cssStyle="color: white;background-color:Green" value = " ${deQuizMaster.deqmOption_c}" />
  </div><br/>
  <div>
  <form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Orange" value = "d" /> 
  <form:input path="deqmOption_d" readonly="true" cssStyle="color: white;background-color:Orange" value = " ${deQuizMaster.deqmOption_d}" /> 
  </div><br/>
  <form:button>submit</form:button>
</form:form>
</div>
</body>
</html>