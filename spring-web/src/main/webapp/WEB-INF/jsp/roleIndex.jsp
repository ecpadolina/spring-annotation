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
	<form>
	Sort By: <select id="column" name="column">
			<option value="id">Id</option>
			<option value="roleType">Role Type</option>
		</select>
		<select id="order" name="order">
			<option value="1">Ascending</option>
			<option value="2">Descending</option>
		</select>
		<button id="roleSearch" type="submit">Search</button>
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
		<tbody id="roleTable">
	         <c:forEach var="r" items="${roleList}">
				<tr>
					<td>${r.roleId}</td>
					<td>${r.roleType}</td>
					<td><form method="POST"><input type="hidden" name="roleId" value="${r.roleId}"/><input type="submit" value="Delete"/></form><button onclick="location.href='/role/edit/${r.roleId}'">Edit</button></td>
				</tr>
			</c:forEach>     
		</tbody>
	</table>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="<c:url value="resources/scripts.js"/>"></script>
</body>
</html>
