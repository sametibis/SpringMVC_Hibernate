<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Relation Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add a New Customer</h3>

		<form:form action="addCustomer" modelAttribute="customer"
			method="POST">
			
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>E-mail: </label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>
	</div>

</body>
</html>