<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="showAddStudentPage">

			<input type="submit" value="Add">

		</form>
		<!-- ModelAttribute : students -->
		<h1>Hi.........</h1>

		<table border="1">

			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${student}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="/ProjectJDBC/updateStudent?userId=${student.id}">Update</a></td>
					<td><a href="/ProjectJDBC/deleteStudent?userId=${student.id}">Delete</a></td>
					<td><a href="/ProjectJDBC/getInfo?userId=${student.id}">getInfo</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</html>