<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Role Management</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Role Management</h1>
	<br>
	<form method="GET">
	Sort By: <select name="column">
			<option value="id">Id</option>
			<option value="roleType">Role Type</option>
		</select>
		<select name="order">
			<option value="1">Ascending</option>
			<option value="2">Descending</option>
		</select>
		<button type="submit">Search</button>
	</form>
	<br>
	<table>
		<thead>
			<tr>
	            <th>ID</th>
	            <th>Role Type</th>
	            <th>Actions</th>
			</tr>
		</thead>
		<tbody>
	         <c:forEach var="r" items="${roleList}">
				<tr>
					<td>${r.roleId}</td>
					<td>${r.roleType}</td>
					<td><form method="POST"><input type="hidden" name="roleId" value="${r.roleId}"/><input type="submit" value="Delete"/></form><button onclick="location.href='/editRole?id=${r.roleId}'">Edit</button>
					<button onclick="location.href='/editRole/1'"/>Edit</button></td>
				</tr>
			</c:forEach>     
		</tbody>
	</table>
</body>
</html>
