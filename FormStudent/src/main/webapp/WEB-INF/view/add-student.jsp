<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
          <h2>Add Student</h2>
          <!-- create a HTML form where the user can enter data -->
            
          <form:form action="save-student" modelAttribute="student" method="Post">
           
           <form:input path="id"/>
           <label>name</label>
           <form:input path="name"/>
           <br/>
           <br/>
           <label>mobile</label>
           <form:input path="mobile"/>
           <br/>
           <br/>
           <label>country</label>
           <form:input path="country"/>
           <br/>
           <br/>
           <input type="submit">
          
          </form:form>
          </div>
</body>
</html>