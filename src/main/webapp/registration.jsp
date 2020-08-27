<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="regUser" method="post" modelAttribute="regUser">
<f:input path="name"  placeholder="name"/><f:errors path="name"/>
<br/><f:password path="password"   placeholder="password"/><f:errors path="password"/>
<br/><f:input path="email"  placeholder="email" /><f:errors path="email"/>
<br/><f:input path="age"  placeholder="age"/><f:errors path="age"/>
<br/><f:input path="experience"  placeholder="experience"/><f:errors path="experience"/>
<br/><input type="submit" value="Registration" id="reg" name="reg" />
<br/><a href="jumpLogin">Login</a>

</f:form>
</body>
</html>