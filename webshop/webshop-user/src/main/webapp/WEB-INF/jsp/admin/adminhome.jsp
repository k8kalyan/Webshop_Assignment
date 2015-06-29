<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="admin.css">
<script type="text/javascript" language="javascript">
function productSubmit()
{
	var selected_index  = document.getElementById('product').value;
	 if(selected_index > 0) 
	{ 
		 
	  	   document.productForm.submit();
	} else
	{ 
	   alert('Please select the product'); 
	}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Home</title>
</head>
<body>

  <form name="productForm" method="post" action="product.action" modelAttribute=> 
 
 <select name="product" id="product" placeholder="product">
        <option value="1">Fruits</option>
        <option value="2">Vegetables</option>
        <option value="3">Books</option>
    </select>
   
       
     <button id="booksbutton" type="button" onclick="productSubmit()">Search</button>
     
     
    </form>
    
    <table align="center" style="margin: 0px auto;">
       	 <c:if test="${not empty productList.products}">	
    		<tr>
   				<th>Item Name</th>
  				<th>Item Desc</th>
  				<th>Price</th>
 			</tr>
 		</c:if>
		<c:forEach items="${productList.products}" var="product" varStatus="status"> 
   			
   			<tr class="rows">
   				<td>${product.name} </td>
   				<td>${product.desc} </td>
   				<td>${product.price} </td>
   				<td>  <a href="<c:url value="addtocart.action?id=${product.id}&name=${product.name}&price=${product.price}" />">AddToCart</a> </td>
   				
  			 </tr>
   		
           
     </c:forEach> 
		
		
	</table>

   
  <a  style="align:right" class="logout" href="logout.action">Logout</a>
</body>
</html>