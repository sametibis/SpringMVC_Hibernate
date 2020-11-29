<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer List</title>
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Relation Manager</h2>
		</div>
	</div>
	
	<div style="margin: 5px">
		<form:form action="search" method="GET">
			Search Customer: <input type="text" name="keyword" placeholder="Search by Customer Name"  />
			<input type="submit" value="Search" class="add-button" />
		</form:form>
	</div>
	
	<div id="container">
		<div id="content">
		<input type="button" value="Add Customer" onclick="window.location.href='showAddForm'; return false; " class="" >
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail Address</th>
					<th>Action</th>
				</tr>

				<c:forEach var="customer" items="${customers}">
					
					<!-- Create an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/updateCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
				
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
												
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>



</body>
</html>