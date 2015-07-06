<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShipmentOrder</title>
</head>
<body>
	    
	<div align="center">
		        
		<form:form action="order.action"  modelAttribute="orderShipment">
            <table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Order Form</h2></td>
				</tr>
				<tr>
					<td>Shipping Address</td>
					<td><form:input path="shippingAddress" /></td>
				</tr>
				<tr>
					<td>Shipping City</td>
					<td><form:input path="shippingCity" /></td>
				</tr>
				
				<tr>
					<td>Pin</td>
					<td><form:input path="pin" /></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:input path="status" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="OrderNow" /></td>
				</tr>
			</table>
        </form:form>
		<div>

</div>    
	</div>
</body>
</html>