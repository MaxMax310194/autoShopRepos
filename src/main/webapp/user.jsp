<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
Hello,<c:out value="${userSession.name}"></c:out>

<br/><input type="submit" onclick="this.form.action = 'goToUpdateUser'"  value="Update" id="up"  name="up">
<table>
<c:forEach  var="a" items="${autos}"> 
<tr>

<td>
<img src="<c:out value='${a.image}'></c:out>" >
</td>

<td>
<c:out value="${a.nameAuto}"></c:out>
</td>

<td>
<c:out value="${a.price}"></c:out>
</td>

<td>

</td>

<td>
<input type="submit" value="Add to basket" id="addB" name="addB"/>
</td>

</tr>
</c:forEach>

</table>
</form>
</body>
</html>