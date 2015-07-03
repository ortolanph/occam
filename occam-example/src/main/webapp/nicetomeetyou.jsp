<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean" class="org.senac.sp.hellooccam.beans.Dude" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nice to meet you!</title>
</head>
<body>
	<h1>Nice to meet you, <jsp:getProperty name="bean" property="person" /></h1>
	<a href="${pageContext.request.contextPath}/hello.jsp">Back</a>
</body>
</html>