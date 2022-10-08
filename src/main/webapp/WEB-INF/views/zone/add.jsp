<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add a new zone</title>
</head>
<body>
<h1>Add a new zone</h1>
<form:form method="post" modelAttribute="zone">
    <span>Name: <form:input path="name"/></span><form:errors path="name"
                                                             cssClass="error"/>
    <input type="submit" value="Add zone">
</form:form>
<p>
    <a href="/">Go back</a>
</p>
</body>
</html>