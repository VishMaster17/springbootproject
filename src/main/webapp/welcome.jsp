<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
<h1>Welcome to spring boot application</h1>
<h3>
<form method="post" action="addEmp">
Emp No <input type="number" name="empno"><br>
Emp Name <input type="text" name="ename"><br>
Job <input type="text" name="job"><br>
Mgr <input type="number" name="mgr"><br>
Sal <input type="number" name="sal"><br>
<br>
<input type="submit" value="INSERT">
<input type="reset" value="RESET">
</form>
</h3>
</body>
</html>