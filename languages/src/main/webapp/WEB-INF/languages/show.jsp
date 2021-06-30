<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>${language.name}</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	</head>
	
	<body>
		<div class="container">
		
			<div>
				<h3><a href="/languages">Dashboard</a></h3>
			</div>
			
			<h3><c:out value="${language.name}"/></h3>
			<h3><c:out value="${language.creator}"/></h3>
			<h3><c:out value="${language.version}"/></h3>
			
			<div>
				<a href="/languages/${language.id}/edit">Edit</a>
				
				<form method="post" action="/languages/${language.id}">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete"/>
				</form>		
			</div>
			
		</div>
	</body>
	
</html>