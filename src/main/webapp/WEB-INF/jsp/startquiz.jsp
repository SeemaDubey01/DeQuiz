<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script type="text/javascript">
	var remainingSec = 10;
	var marks = 1000;
	remainingSec = [[${deQuizMaster.deqmTimer}]];
	$("#msg").text (remainingSec);
	setInterval(function(){
		$("#timer").text (remainingSec);
		remainingSec = remainingSec - 1;
		if (remainingSec < 0 ) {
			remainingSec = 0;
			$("#quizform").submit();
		}		
		setInterval(function(){
			marks = marks - 2;
			if (marks < 0 ) marks =0;
			$("#dquMarks").attr("value",marks);
		},100);
	},1000);
</script>
<script>
$(document).ready(function(){
  $("#optionA").click(function(){
		$("#selectedAnswer").attr("value","a");
		$("#quizform").submit();
  });
  $("#optionB").click(function(){
		$("#selectedAnswer").attr("value","b");
		$("#quizform").submit();
  });
  $("#optionC").click(function(){
		$("#selectedAnswer").attr("value","c");
		$("#quizform").submit(); 
  });
  $("#optionD").click(function(){
		$("#selectedAnswer").attr("value","d");
		$("#quizform").submit();
  });
});
</script>
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<h1>Start Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
<form:form id="quizform" action="/showresult"  method="post" modelAttribute="deQuizMaster">
  <div>
  <div>${deQuizMaster.deqmQuestion}</div><p/>
  </div>
  <div>
  <form:hidden path="deqmQuizId" value="${deQuizMaster.deqmQuizId}"/>
  <form:hidden path="deqmQuestionNo" value="${deQuizMaster.deqmQuestionNo}"/>
  <form:hidden path="dquUserId" value="${deQuizMaster.dquUserId}"/>
  <form:hidden path="deqmAnswer" value="${deQuizMaster.deqmAnswer}"/>
  <form:hidden path="dquMarks" value="0"/>
    <form:hidden path="selectedAnswer" value="a"/>
  <p id="optionA">
  <form:label path="deqmOption_a" cssStyle="color: white;background-color:DodgerBlue">${deQuizMaster.deqmOption_a}</form:label>
  </p>
  <p id="optionB">
  <form:label path="deqmOption_b" cssStyle="color: white;background-color:Red">${deQuizMaster.deqmOption_b}</form:label>
  </p>
  <p id="optionC">
  <form:label path="deqmOption_c" cssStyle="color: white;background-color:Green">${deQuizMaster.deqmOption_c}</form:label>
  </p>
  <p id="optionD">
  <form:label path="deqmOption_d" cssStyle="color: white;background-color:Orange">${deQuizMaster.deqmOption_d}</form:label>
  </p>

  </div>
</form:form>
	<table Style="border:1px solid black;">
		<tr><td>Time remaining: <span id="timer">${deQuizMaster.deqmTimer}</span> Seconds</td></tr>
	</table>
</div>
</body>
</html>