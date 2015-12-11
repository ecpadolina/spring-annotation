<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Project Management</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Project Form</h1>
	<form:form method="POST" accept-charset="UTF-8" modelAttribute="project">
		<form:input type="hidden" path="id"/>
		<div>Project Name: <form:input path="name"/><form:errors class="error" path="name"/></div>
		<div>Start Date: <form:input type="date" path="startDate"/></div>
		<div>End Date: <form:input type="date" path="endDate"/><form:errors path="endDate"/></div>
		<br>
		<div>
		Select Members:<br>
		<c:if test="${not empty persons}">
		<select name="members" multiple>
		<c:forEach items="${persons}" var="p">
			<c:set var="selected" value=""/>
			<c:forEach items="${project.persons}" var="projectPerson">
				<c:if test="${projectPerson.id == p.id}">
					<c:set var="selected" value=" selected"/>
				</c:if>
			</c:forEach>
			<option value="${p.id}" ${selected}> ${p.firstName} ${p.lastName} </option>
		</c:forEach>
		</select>
		</c:if>
		<br>
		<br>
		</div>
		<div>
		<input type="submit" value="Submit"/>
		<input type="reset"/>
		</div>
	</form:form>
</body>
</html>