<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome admin</title>
</head>
<body>
<center>
<h1>welcome admin</h1>
<j:if test="${sessionScope.user!=null}">

<a href="AddEmployee.jsp">AddEmployee</a><br>
<a href="ViewEmpls?username=admin">view all employees</a><br>
<a href="EmployeeCode.jsp">get employee details</a><br>
<a href="Logout">logout</a>
</j:if>
<j:if test="${sessionScope.user==null}">
<j:out value="${'unauthorised user' }"></j:out>

</j:if>

</center>

</body>
</html>