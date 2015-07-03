<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Exemplo de Calculadora</title>
</head>
<body>
	<h1>Escolha uma operação</h1>
	<fieldset>
		<legend>Adição</legend>
		<form action="${pageContext.request.contextPath}/occam/matematica.somar" method="post">
			<table>
				<tr>
					<td size="20%">Operador 1</td>
					<td size="80%"><input type="text" name="operador1"/></td>
				</tr>
				<tr>
					<td size="20%">Operador 2</td>
					<td size="80%"><input type="text" name="operador2"/></td>
				</tr>
			</table>
			<p align="right">
				<input type="submit"/>
			</p>
		</form>
	</fieldset>
	<fieldset>
		<legend>Subtração</legend>
		<form action="${pageContext.request.contextPath}/occam/matematica.subtrair" method="post">
			<table>
				<tr>
					<td size="20%">Operador 1</td>
					<td size="80%"><input type="text" name="operador1"/></td>
				</tr>
				<tr>
					<td size="20%">Operador 2</td>
					<td size="80%"><input type="text" name="operador2"/></td>
				</tr>
			</table>
			<p align="right">
				<input type="submit"/>
			</p>
		</form>
	</fieldset>
	<fieldset>
		<legend>Multiplicação</legend>
		<form action="${pageContext.request.contextPath}/occam/matematica.multiplicar" method="post">
			<table>
				<tr>
					<td size="20%">Operador 1</td>
					<td size="80%"><input type="text" name="operador1"/></td>
				</tr>
				<tr>
					<td size="20%">Operador 2</td>
					<td size="80%"><input type="text" name="operador2"/></td>
				</tr>
			</table>
			<p align="right">
				<input type="submit"/>
			</p>
		</form>
	</fieldset>
	<fieldset>
		<legend>Divisão</legend>
		<form action="${pageContext.request.contextPath}/occam/matematica.dividir" method="post">
			<table>
				<tr>
					<td size="20%">Operador 1</td>
					<td size="80%"><input type="text" name="operador1"/></td>
				</tr>
				<tr>
					<td size="20%">Operador 2</td>
					<td size="80%"><input type="text" name="operador2"/></td>
				</tr>
			</table>
			<p align="right">
				<input type="submit"/>
			</p>
		</form>
	</fieldset>
</body>
</html>