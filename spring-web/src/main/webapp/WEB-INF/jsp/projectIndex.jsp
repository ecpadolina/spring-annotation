<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Project Management</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Project Management</h1>
	<br>
	<table>
		<thead>
			<tr>
	            <th>ID</th>
	            <th>Name</th>
	            <th>Start Date</th>
	            <th>End Date</th>
	            <th>Actions</th>
			</tr>
		</thead>
		<tbody>
	         <c:forEach var="p" items="${projectList}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.startDate}</td>
					<td>${p.endDate}</td>
					<td><form method="POST"><input type="hidden" name="projectId" value="${p.id}"><button type="submit">Delete</button></form><button onclick="location.href='/project/edit/${p.id}'">Edit</button></td>
				</tr>
			</c:forEach>     
		</tbody>
	</table>
</body>
</html>
