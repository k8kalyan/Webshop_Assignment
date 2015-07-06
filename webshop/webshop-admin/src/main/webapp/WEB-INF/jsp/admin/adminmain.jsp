<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body bgcolor="">
<center>
<div id="Table-box">
<div class="msg1">
<b>Product Categories</b>
</div>
<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>CategoryId</th>
		<th>CategoryName</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	
	<tbody>
	<c:forEach items="${productcategory}" var="productcategory">
	
			<tr>
				<td><c:out value="${productcategory.id}" /></td>
				<td><c:out value="${productcategory.name}" /></td>
                <td><a href="<c:url value="editcategory.action?id=${productcategory.id}&name=${productcategory.name}" />">Edit</a></td>
				<td><a href="<c:url value="deletecategory.action?id=${productcategory.id}"/>">Delete</a></td>
			</tr>
			</c:forEach>
			
	</tbody>
</table>
</div>
<p><a href="newcategory.action">Add New Category</a></p>
<p><a href="productlist.action">Go To Product List</a></p>
 <a  style="align:right;" class="logout" href="logout.action">Logout</a>
</center>
</body>
</html>