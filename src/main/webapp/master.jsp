<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#table table tr,table th,table td{
		border: 1px black solid;
	}
</style>
</head>
<body>
<form action="" method="post">
Hello,<c:out value="${userSession.name}"></c:out>
<table>

<thead>
<tr>

<th>
Id
</th>

 <th>
Image
</th>

<th>
NameAuto
</th>

<th>
Information
</th>

<th>
Price
</th>

<th>
Delete
</th>

<th>
Update
</th>
</tr>
</thead>

<tbody>
<c:forEach var="a" items="${autos}">
<tr>

<td>
<c:out value="${a.idAuto}"></c:out>
</td>

<td>
<c:out value="${a.image}"></c:out>
</td>

<td>
<c:out value="${a.nameAuto}"></c:out>
</td>

<td>
<c:out value="${a.info}"></c:out>
</td>

<td>
<c:out value="${a.price}"></c:out>
</td>

<td>
<input type="submit" onclick="this.form.action = 'delAuto'" value="Delete" id="del" name="d${a.idAuto}"/>
</td>

<td>
<input type="submit" onclick="this.form.action = 'goToUpdateAuto'"  value="Update" id="up" name="u${a.idAuto}"/>
</td>

</tr>
</c:forEach>
</tbody>

</table>
<input type="submit" value="Add" onclick="this.form.action = 'jumpRegAuto'" id="add" name="add"/>
</form>
</body>
</html>