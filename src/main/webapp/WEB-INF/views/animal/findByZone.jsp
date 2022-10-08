<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find animals by zone</title>
</head>
<body>
<form method="post">
    <p>
        <c:forEach items="${zones}" var="zone">
            <input type="radio" name="zoneName" value="${zone}"> ${zone}<br>
        </c:forEach>
    </p>
    <input type="submit" value="find animals">
</form>
<p>
    <a href="/">Go back</a>
</p>
</body>
</html>