<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Person Management - Person Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/resources/scripts.js"></script></head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Person Form</h1>
	<form:form method="POST" accept-charset="UTF-8" modelAttribute="person">
		<form:input type="hidden" path="id"/>
		<spring:message code="label.firstName"/>: <form:input path="name.firstName"/>
		<form:errors class="error" path="name.firstName"/><br/>
		<spring:message code="label.middleName"/>: <form:input path="name.middleName"/>
		<form:errors class="error" path="name.middleName"/><br/>
		<spring:message code="label.lastName"/>: <form:input path="name.lastName"/>
		<form:errors class="error" path="name.lastName"/><br/>
		<spring:message code="label.birthday"/>: <form:input type="date" required="required" 
			path="birthday"/><form:errors class="error" path="birthday"/><br/>
		<spring:message code="label.houseNo"/>: <form:input path="address.houseNo"/>
		<form:errors class="error" path="address.houseNo"/><br/>
		<spring:message code="label.street"/>: <form:input path="address.street"/>
		<form:errors class="error" path="address.street"/><br/>
		<spring:message code="label.barangay"/>: <form:input path="address.barangay"/>
		<form:errors class="error" path="address.barangay"/><br/>
		<spring:message code="label.subdivision"/>: <form:input path="address.subdivision"/>
		<form:errors class="error" path="address.subdivision"/><br/>
		<spring:message code="label.municipality"/>: <form:input path="address.municipality"/>
		<form:errors class="error" path="address.municipality"/><br/>
		<spring:message code="label.province"/>: <form:input path="address.province"/>
		<form:errors class="error" path="address.province"/><br/>
		<spring:message code="label.zipcode"/>: <form:input type="number" path="address.zipcode"/><form:errors class="error" path="address.zipcode"/><br/>
		<spring:message code="label.grade"/>: <form:input type="number" step="0.01" min="1" max="5" path="gwa"/><br/>
		<h3>Employment Status:</h3>
		<form:radiobutton path="employmentStatus" value="Intern" label="Intern" id="rdb"/>
		<form:radiobutton path="employmentStatus" value="Probationary" label="Probationary" id="rdb"/>
		<form:radiobutton path="employmentStatus" value="Regular" label="Regular" id="rdb"/>
		<form:radiobutton path="employmentStatus" value="Resigned" label="Resigned" id="rdb"/>
		<br><form:errors class="error" path="employmentStatus"/>
		<br>
		<h3>Contacts:</h3>
		<input type="button" id="landline" value="Landline"/>
		<input type="button" id="mobile" value="Mobile"/>
		<input type="button" id="email" value="Email"/>
		<div id="contactNumber">
			<br>
		<c:forEach var="c" items="${contacts}">
			<div>${c.contactType}: <input type="text" value="${c.contactInfo}" name="contactInfo"/> 
			<input type="hidden" value="${c.contactId}" name="contactId">
			<input type="hidden" value="${c.contactType}" name="contactType"/>
			<button class="delete">Remove</button> <!--form:errors class="error" path="contacts"/--></div>
		</c:forEach>
		</div>
		<br>
		<h3>Roles:</h3>
			<c:if test="${not empty roles}">
	            <c:forEach items="${roles}" var="role">
	                <c:set var="checked" value="" />
	                <c:forEach items="${person.roles}" var="personRole">
	                    <c:if test="${personRole.roleId == role.roleId}">
	                        <c:set var="checked" value=" checked" />
	                    </c:if>
	                </c:forEach>
	                <input type="checkbox" name="personRoles" value="${role.roleId}"${checked} /> ${role.roleType}
	            </c:forEach>
	        </c:if>
		<br><br>
		<button id="create" type="submit" value="submit">Submit</button>
		<button type="reset">Reset</button>
	</form:form>
</body>
</html>
