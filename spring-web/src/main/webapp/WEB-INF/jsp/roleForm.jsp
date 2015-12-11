<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Role Management</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Role Form</h1>
	<form:form metohd="POST" accept-charset="UTF-8" modelAttribute="role">
		<form:input path="roleId" name="roleId" type="hidden"/>
		Role Name: <form:input path="roleType" name="roleType" placeholder="Role Name"/>
		<button id="create" type="submit" value="submit">Submit</button>
		<button type="reset">Reset</button>
	</form:form>
</body>
</html>