<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body bgcolor="">
<center>
<b>Product Categories</b>
<form:form action="editupdateproduct.action" modelAttribute="product">
<table border="0">
	
	<tr>     
	<td>Product ID</td>  
			<td><form:input path="id" /><c:out value="${product1.id}" /></td>
			<td>Product Name</td>
			<td><form:input path="name" /><c:out value="${product1.name}" /></td>
			<td>Product Description</td>
			<td><form:input path="description" /><c:out value="${product1.description}" /></td>
			<td>Price</td>
			<td><form:input path="price" /><c:out value="${product1.price}" /></td>
            <td colspan="2" align="center"><input type="submit" value="Update" /></td>
			</tr>
</table>
</form:form>
</div>
<p><a href="newproduct.action">Add New Product</a></p>
</center>
</body>
</html>