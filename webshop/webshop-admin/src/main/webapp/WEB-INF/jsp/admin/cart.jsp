<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Cart page</title>
</head>
<body>
<form action="submitcart.action">
<table>

<c:forEach items='<%=request.getSession().getAttribute("cart") %>' var="ca" varStatus="loop">

  <tr>
  <td>${ca.id}</td>
  <td>${ca.orderid}</td>
  <td>${loop.index}</td>
  <td><a href="<c:url value="removefromcart.action?id=${loop.index}" />">Remove</a> </td>
  </tr>
</c:forEach>
<tr>
<button type="button" name="back" onclick="history.back()">Continue</button></tr>
<button type="submit" name="Order Now" value="Order">Order Now</button>
</table>
</form>
</body>
</html>