<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JoinQuiz</title>
<style type="text/css">
    form div {
		display: table-row;
	}
	form div div {
		display: table-cell;
	}

</style>
</head>
<body>
<div align="center">
<h1>Result</h1>
<form:form  modelAttribute="quiz">


<h2>Dear Player your Quiz result is Pass</h2>
</form:form>
</div>
</body>
</html>