<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="/script/dequiz.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
 
<script type="text/javascript">


function clickupdate(){
		$('#editType').attr('value','update');
		 $("#quizdiv").hide();
		 $("#questiondiv").hide();
		 $("#update").hide();
		 $("#questiondivEdit").show();
		 $("#quizdivEdit").show();
		 $("#save").show();
		 $("#cancel").show();
		 $("#previous").show();
}

function clickcancel(){
	$('#editType').attr('value','cancel');
	 $("#quizdiv").show();
	 $("#questiondiv").show();
	 $("#update").show();
	 $("#questiondivEdit").hide();
	 $("#quizdivEdit").hide();
	 $("#save").hide();
	 $("#cancel").hide();
	 $("#cancel").show();
	 $('#quizform').submit();
}

function clickprevious(){
	$('#editType').attr('value','previous');
	$('#quizform').submit();
	
}

function clicksave(){
	$('#editType').attr('value','save');
	$('#quizform').submit();
	$("#quizdiv").show();
	 $("#questiondiv").show();
	 $("#update").show();
	 $("#questiondivEdit").hide();
	 $("#quizdivEdit").hide();
	 $("#save").hide();
	 $("#cancel").hide();
	 $("#previous").show();
	
}

function clicknext(){
	$('#editType').attr('value','next');
	$('#quizform').submit();
	 $("#previous").show();
	
	
}
</script>
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<div class="wrapper">
<!--  page header containing heading and menu -->
<div align="center">
  <span ><img src="images/dqlogo.jpg" alt="De Quiz" name="DeQuizLogo" width="80" height="80" id="DeQuizLogo" />
  </span> <span class="header">De Quiz</span>
</div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<h1>Start Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
<form:form id="quizform" action="getNextQuestioinEdit"  method="post" modelAttribute="deQuizMaster">
  <div id = "questiondiv">${deQuizMaster.deqmQuestionNo}.  ${deQuizMaster.deqmQuestion}</div>
  <div id = "questiondivEdit" hidden="true">${deQuizMaster.deqmQuestionNo}. 
  <form:input path="deqmQuestion" value = "${deQuizMaster.deqmQuestion}" maxlength="90px"/></div>
  <form:hidden path="deqmQuizId" value="${deQuizMaster.deqmQuizId}"/>
  <form:hidden path="deqmQuestionNo" value="${deQuizMaster.deqmQuestionNo}"/>
  <form:hidden path="deqmSrNbr" value="${deQuizMaster.deqmSrNbr}"/>
    <form:hidden path="editType" value ="next"/>
  <div id="quizdiv" class="quizdiv">
  <p id="optionA">
  <form:label path="deqmOption_a">${deQuizMaster.deqmOption_a}</form:label>
  </p>
  <p id="optionB">
  <form:label path="deqmOption_b">${deQuizMaster.deqmOption_b}</form:label>
  </p>
  <p id="optionC">
  <form:label path="deqmOption_c">${deQuizMaster.deqmOption_c}</form:label>
  </p>
  <p id="optionD">
  <form:label path="deqmOption_d">${deQuizMaster.deqmOption_d}</form:label>
  </p>
  </div><p/>
    <div id="quizdivEdit" hidden="true" >
  <p id="optionA">
  <form:input path="deqmOption_a" value ="${deQuizMaster.deqmOption_a}"/>
  </p>
  <p id="optionB">
<form:input path="deqmOption_b" value ="${deQuizMaster.deqmOption_b}"/>
  </p>
  <p id="optionC">
<form:input path="deqmOption_c" value ="${deQuizMaster.deqmOption_c}"/>
  </p>
  <p id="optionD">
<form:input path="deqmOption_d" value ="${deQuizMaster.deqmOption_d}"/>
  </p>
  </div><p/>
    <button id = "previous"  name="previous" type="button" value="previous" onclick="clickprevious()">Previous Question</button>
     <button id="update" name="update" type="button" value="update" onclick="clickupdate()">Update</button>
     <button id = "save" hidden = "true" name="save" type="button" value="save" onclick="clicksave()">Save</button>
     <button id = "cancel" hidden = "true" name="cancel" type="button" value="cancel" onclick="clickcancel()">Cancel</button>
     
  <button id = "next" name="next" type="button" value="next" onclick="clicknext()">Next Question</button>
   <button id = "addQuestions" hidden = "true" name="addQuestions" type="button" value="addQuestions" onclick="clickaddQuestions()">Cancel</button>
</form:form>
	
</div><p/>
</div>
<!--  End of content block -->
<!--  Footer -->
<div class="footer">
&copy; DeQuiz India 
</div>
<!--  end of Footer -->

</div>

</body>
</html>