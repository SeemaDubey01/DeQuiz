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
<!--  question number and question -->

  <form:form action="/getResult"  method="post" modelAttribute="dquizMaster">
  <form:hidden path="dquUserId" value ="${dquizMaster.dquUserId}"/>
  <div>
  <div>${dquizMaster.deqmQuestion}</div>
  </div>
  <div>
  <form:radiobutton  path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:DodgerBlue" value = "a" /><form:input path="deqmOption_a" readonly="true" cssStyle="color: white;background-color:DodgerBlue" value = " ${dquizMaster.deqmOption_a}" />
  </div><br/>
  <div>
<form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Red" value = "b" /> <form:input path="deqmOption_b" readonly="true" cssStyle="color: white;background-color:Red" value = " ${dquizMaster.deqmOption_b}" />
</div><br/>
<div>
<form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Green" value = "c" /><form:input path="deqmOption_c" readonly="true" cssStyle="color: white;background-color:Green" value = " ${dquizMaster.deqmOption_c}" />
</div><br/>
<div>
<form:radiobutton path="selectedAnswer" readonly="true" cssStyle="color: white;background-color:Orange" value = "d" /> <form:input path="deqmOption_d" readonly="true" cssStyle="color: white;background-color:Orange" value = " ${dquizMaster.deqmOption_d}" /> 
</div><br/>
<form:button>submit</form:button>

</form:form>


</body>
</html>