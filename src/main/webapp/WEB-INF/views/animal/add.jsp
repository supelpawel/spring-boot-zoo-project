<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add a new animal</title>
</head>
<body>
<form:form method="post" modelAttribute="createAnimalDto">
    <p>
        Name: <form:input path="name"/>
    </p><form:errors path="name"
                     cssClass="error"/>
    <p>
        Choose species: <form:select path="species" items="${animalSpecies}"/>
    </p>
    <form:errors path="species" cssClass="error"/>
    <p>
        Choose zone: <form:select path="zoneName" items="${zones}"/>
    </p>
    <form:errors path="zoneName" cssClass="error"/>
    <p>
    </p>
    <p>
        <input type="submit" value="Add animal">
    </p>
</form:form>
<p>
    <a href="/">Go back</a>
</p>
</body>
</html>