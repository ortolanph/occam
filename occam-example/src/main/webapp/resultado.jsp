<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean" class="br.senac.sp.exemplo.beans.ResultadoCalculadora" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Resultado da opera��o</title>
</head>
<body>
	<h1>Resultado = <jsp:getProperty name="bean" property="resultado" /></h1>
	<a href="${pageContext.request.contextPath}/calculadora.jsp">Voltar</a>
</body>
</html>