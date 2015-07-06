<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Home Page</title>
</head>
<body bgcolor="">
<center>
<div id="Table-box">
<div class="msg1">
<b>Product Categories</b>
</div>
<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>Product Id</th>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
	</tr>
	<tbody>
	<c:forEach items="${products}" var="products">
	
			<tr>
				<td><c:out value="${products.id}" /></td>
				<td><c:out value="${products.name}" /></td>
				<td><c:out value="${products.description}" /></td>
				<td><c:out value="${products.price}" /></td>
				 <td><a href="<c:url value="editproduct.action?id=${products.id}&name=${products.name}" />">Edit</a></td>
				<td><a href="<c:url value="deleteproduct.action?id=${products.id}"/>">Delete</a></td>
			</tr>
			</c:forEach>
			
	</tbody>
</table>
</div>
<p><a href="newproduct.action">Add New Product</a></p>
</center>
</body>
</html>