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
<f:form action="jumpRegAuto" method="post" modelAttribute="regAuto" > 
File:<input type="file" id="image" name="image">  
<br/>Name<br/><f:input path="nameAuto"/><f:errors path="nameAuto" />
<br/>Info<br/><f:input path="info"/><f:errors path="info" />
<br/>Price<br/><f:input path="price"/><f:errors path="price" />
<br/><input type="submit" value="Registration"  onclick="this.form.action = 'addAuto'" id="regAuto" name="regAuto"/><input type="submit" value="Cansel"  onclick="this.form.action = 'canselAddAuto'" id="cans" name="cans"/>
</f:form><script type="text/javascript">
 var fields = document.getElementsByTagName("input");
 fields[3].value = "";
</script>
</body>
</html>