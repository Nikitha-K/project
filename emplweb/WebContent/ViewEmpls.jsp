<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<j:set var="user" value="${username}"/>
	<table border="2" align="center">
		<tr>
			<th>EmpCode</th>
			<th>empname</th>
			<th>job</th>
			<th>salary</th>
			<th>date of birth</th>
		</tr>
		<j:forEach var="emp" items="${empls}">
			<tr>
				<td><j:out value="${emp.empcode }"></j:out></td>
				<td><j:out value="${emp.empname }"></j:out></td>
				<td><j:out value="${emp.job }"></j:out></td>
				<td><j:out value="${emp.salary }"></j:out></td>
				<td><j:out value="${emp.dateOfBirth }"></j:out></td>
				<j:if test="${user eq 'admin'}">
				<td><a href="UpdateEmpl?code=${emp.empcode}">Update</a></td>
				<td><a href="DeleteEmpl?code=${emp.empcode}">delete</a></td></j:if>
			</tr>
		</j:forEach>






	</table>
	<center>
	<button><a href="Logout" >logout</a></button>
	</center>

</body>
</html>