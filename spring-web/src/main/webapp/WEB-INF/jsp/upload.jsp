<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <title>Person Management - Person Form</title>
</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>File Uploading</h1>
	<br>
	    <form method="POST" commandName="uploadFile" enctype="multipart/form-data">
	       	<input type="file" name="file"/><br/>
	        <button type="submit" name="submit">Upload</button>
	    </form>
</body>
</html>


	