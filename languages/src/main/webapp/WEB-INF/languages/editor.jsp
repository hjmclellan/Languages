<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Edit ${language.name}</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	</head>
	
<body>
	<div class="container">
		<div>
			<h3><a href="/languages">Return to Dashboard</a></h3>
		</div>
		
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put" />
			
			<p class="row">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			
			<p class="row">
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</p>
			
			<p class="row">
				<form:label path="version">Version:</form:label>
				<form:errors path="version"/>
				<form:input path="version"/>
			</p>
			
			<p class="row">
				<input type="submit" value="Submit"/>	
			</p>
			
		</form:form>
	
	</div>
	
</body>
</html>