<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<h1>Start Quiz</h1>
<!--  question number and question -->
  <h2>1. What is the capital of India?</h2>
  <form:form action="/getResult"  method="post" modelAttribute="quiz">
  <div>

  <form:radiobutton  path="question" readonly="true" cssStyle="color: white;background-color:DodgerBlue" value = "optionA" /><form:input path="optionA" readonly="true" cssStyle="color: white;background-color:DodgerBlue" value = "Delhi" />
  </div><br/>
  <div>
<form:radiobutton path="question" readonly="true" cssStyle="color: white;background-color:Red" value = "optionB" /> <form:input path="optionB" readonly="true" cssStyle="color: white;background-color:Red" value = "Mumbai" />
</div><br/>
<div>
<form:radiobutton path="question" readonly="true" cssStyle="color: white;background-color:Green" value = "optionC" /><form:input path="optionC" readonly="true" cssStyle="color: white;background-color:Green" value = "Kolkata" />
</div><br/>
<div>
<form:radiobutton path="question" readonly="true" cssStyle="color: white;background-color:Orange" value = "optionD" /> <form:input path="optionD" readonly="true" cssStyle="color: white;background-color:Orange" value = "Chennai" /> 
</div><br/>
<form:button>submit</form:button>

</form:form>

</body>
</html>