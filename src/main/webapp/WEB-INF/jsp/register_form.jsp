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
	
	button {
		padding: 10px;
	}
	.error {
		color: red;
		font-style: italic;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 5px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 5px;
	}

	form div div {
		display: table-cell;
	}	
</style>
</head>
<body>
	<div align="center" style="font-size:min(5vw,40);">
		<h2>Participants please enter details</h2>
		<form:form action="/joinQuiz" method="post" modelAttribute="deQuizUser">
			<div>
			<form:label path="dquQuizId">Quiz#:</form:label>
			<form:input path="dquQuizId" type = "number" />
			<form:errors path="dquQuizId" cssClass="error" />
			</div> 
			
			<div>
			<form:label path="dquUserName">Your Name:</form:label>
			<form:input path="dquUserName" />
			<form:errors path="dquUserName" cssClass="error" />
			</div>

			
				
			<div>
				<div></div>
				<div>
				<form:button>submit</form:button>
				</div>
				<div></div>
			</div>
		</form:form>
	</div>
</body>
</html>