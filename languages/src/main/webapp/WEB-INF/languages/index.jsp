  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Coding Languages!!</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	</head>
	
	<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="lang">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
					<td><c:out value="${lang.creator}"/></td>
					<td><c:out value="${lang.version}"/></td>
					<td>
						<form method="post" action="/languages/${lang.id}">
							<input type="hidden" name="_method" value="delete"/>
							<input type="submit" value="delete- this is permanent!"/>
						</form>
						<a href="/languages/${lang.id}/editor">Edit this Language's information</a>
					</td>
				</tr>			
				</c:forEach>
			</tbody>
		</table>
		
		<form:form action="/languages" method="post" modelAttribute="language">
		
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