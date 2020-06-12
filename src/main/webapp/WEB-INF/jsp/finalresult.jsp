<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script>
function DeQuizUser(userId, quizId, userName, marks ){
	this.userId = id;
	this.quizId = quizId;
	this.userName = userName;
	this.marks = marks;
}
function displayResult(deQuizUserlist){
//	var deQuizUser = new DeQuizUser(deQuizUserList[0]);
	console.log("first: " + deQuizUserlist);
	if (deQuizUser.length > 0){
		$("#result").text("size: " + deQuizUser.length);
	}
	console.log("list: " + userResultList);
}

displayResult(${userResultList});
</script>
<title>Final Result</title>
</head>
<body>

<H1> Final Result</H1>
<div align="center" style="font-size:min(5vw,40);">
<form:form action="/joinQuiz" method="get" modelAttribute="deQuizUser">
	<p> Dear ${deQuizUserName}, your total marks: ${deQuizTotalNumber}</p><br/>
	<div id="result">
	</div><p/>
	<table>
	<c:if test="${not empty userResultList}">

	   <tr>
	   <td>Position</td>
	   <td>Total Marks</td>
	   </tr>
    
        <c:forEach var="listValue" items="${userResultList}">
        <tr>
            <td>${listValue.dquUserName}</td>
             <td>${listValue.dquTotalMarks}</td>
             </tr>
        </c:forEach>
  
	</c:if>
	</table>
	<br/><br/>
	
	
<form:button >Join other quiz</form:button>
</form:form>
</div>
</body> 
</html>