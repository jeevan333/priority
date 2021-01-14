<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Users List</h1>  
<table border="2" width="100%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Connection</th><th>Relationships</th><th>Career</th><th>Wealth</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.id}</td>  
   <td>${user.name}</td>  
   <td>${user.connection}</td>  
   <td>${user.relationship}</td>  
   <td>${user.career}</td>
   <td>${user.wealth}</td>
   <td><a href="edituser/${user.id}">Edit</a></td>  
   <td><a href="deleteuser/${user.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="userform">Add New User</a>  

</body>
</html>