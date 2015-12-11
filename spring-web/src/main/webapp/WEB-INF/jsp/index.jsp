<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Person Management</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Person Management</h1>
	<form>
	Sort By: <select id="column" name="column">
			<option value="id">Id</option>
			<option value="name.lastName">Last Name</option>
			<option value="gwa">Gwa</option>
		</select>
		<select id="order" name="order">
			<option value="1">Ascending</option>
			<option value="2">Descending</option>
		</select>
		<select id="role" name="role">
			<c:forEach var="r" items="${roleList}">
				<option value="${r.roleId}">${r.roleType}</option>
			</c:forEach>
		</select>
		<button id="search" type="submit">Search</button>
	</form>
	<br>
	<table>
		<thead>
			<tr>
	            <th>ID</th>
	            <th><spring:message code="label.name"/></th>
	            <th><spring:message code="label.birthday"/></th>
	            <th><spring:message code="label.grade"/></th>
	            <th><spring:message code="label.action"/></th>
			</tr>
		</thead>
		<tbody id="table">
	         <c:forEach var="p" items="${personList}">
				<tr>
					<td><c:out value="${p.id}" /></td>
					<td>${p.firstName} ${p.lastName}</td>
					<td>${p.birthday}</td>
					<td>${p.gwa}</td>
					<td>
						<form method="POST"><input type="hidden" name="id" value="${p.id}"/><input type="submit" value="Delete"/></form><button onclick="location.href='/person/edit/${p.id}'">Edit</button></td>
				</tr>
			</c:forEach>     
		</tbody>
	</table>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="<c:url value="resources/scripts.js"/>"></script>
</body>
</html>
