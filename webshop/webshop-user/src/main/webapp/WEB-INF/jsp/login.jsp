<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>PetCart Login Form</title>
</head>
<body>
<div class="container">
${loginerror}
<div class="form-gorup">
<form action="loginuser.action" method="post">
<div>
<label>UserName:</label>
<input type="text" id="username" name="username" placeholder="username" class=""/>
</div>
<div>
<label>Password:</label>
<input type="password" id="password" name="password" placeholder="password" class=""/>
</div>
<button id="loginbutton" type="submit">Login</button>


</form>
<div>
<a class="button" href="newuser.action">Register</a>
</div>
</div>

</div>
</body>
</html>