<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
	    
	<div align="center">
		        
		<form:form action="addproduct.action" modelAttribute="product">
            <table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Add Product Form</h2></td>
				</tr>
				<tr>
					<td>Product Name:</td>
					<td><form:input path="name" /></td>
					<td>Product Description:</td>
					<td><form:input path="description" /></td>
					<td>Product CategoryId:</td>
					<td><form:input path="pcid" /></td>
					<td>Product Price:</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add Product" /></td>
				</tr>
			</table>
        </form:form>
		    
	</div>
</body>
</html>