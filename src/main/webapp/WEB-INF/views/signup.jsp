<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<form method="post" action="<c:url value="/root/signup"/>">
    <input type="text" title="username" name="username"><br>
    <input type="password" title="password" name="password"><br>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>
