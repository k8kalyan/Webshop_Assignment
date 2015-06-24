<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript">
function productSubmit()
{
	var selected_index = productForm.elements["product"].selectedIndex; 
	 if(selected_index > 0) 
	{ 
		
	   var selected_option_value = productForm.elements["product"].options[selected_index].value;
	   alert('Please select the product'+selected_option_value);
	   
	   var selected_option_text = productForm.elements["product"].options[selected_index].Text;
	   alert('Please select the product'+selected_option_text);
	   document.getElementById("ProductCategories").text='Item';
	   document.getElementById("ProductDescription").text='apple';
	   document.getElementById("Quantity").text='apple';
	   document.getElementById("Price").text='apple';
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

  <form method="post" action="product.action"> 
 
 <select name="product" id="product" placeholder="product">
        <option value="Apple">Apple</option>
        <option value="Banna">Banana</option>
        <option value="orange">Orange</option>
        <option value="grapes">Grapes</option>
    </select>
   
        
    <input type="text" name="ProductCategories">  
     <input type="text" name="ProductDescription">
     
     <button id="booksbutton" type="submit">Search</button>
     
     
    </form>
   <c:if test="${not empty lists}">
 
		<ul>
			<c:forEach var="listValue" items="${lists}">
			<table>
			<tr><td>${listValue.id} </td><td>${listValue.name} </td><td>  <a href="<c:url value="order.action?id=${listValue.id}" />">Order</a> </td></tr>
			</table>				
			</c:forEach>
		</ul>
 
	</c:if>
  <a href="logout.action">Logout</a>
</body>
</html>