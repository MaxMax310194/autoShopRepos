<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	#table  table th,table tr,table td{
		border: 1px black solid; 
	}

</style>
</head>
<body>
Hello,<c:out value="${userSession.name}"></c:out>
<form action="" method="post">
<table>

<thead>
<tr>

<th>
ID
</th>

<th>
NAME
</th>

<th>
EMAIL
</th>

<th>
AGE
</th>

<th>
EXPERIENCE
</th>

<th>
ROLE
</th>

<th>
DELETE
</th>

</tr>
</thead>

<tbody>
<c:forEach  var="u" items="${users}">
<tr>

<td>
<c:out value="${u.idUser}"></c:out>
</td>

<td>
<c:out value="${u.name}"></c:out>
</td>

<td>
<c:out value="${u.email}"></c:out>
</td>

<td>
<c:out value="${u.age}"></c:out>
</td>

<td>
<c:out value="${u.experience}"></c:out>
</td>

<td>
<c:out value="${u.role}"></c:out>
</td>

<td>
<input type="submit" onclick="this.form.action = 'delUser'" value="Delete"  id="del"  name="d${u.idUser}"/>
</td>

</tr>
</c:forEach>
</tbody>

</table>

</form>
</body>
</html>