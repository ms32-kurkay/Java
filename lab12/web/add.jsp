<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add value of meter</title>
</head>
<body>
<h3>Add Value</h3>
<p style="color: red">${message}</p>
<form action="/add_value" method="post">
    <p>
        <b>Type:</b>
        <br>
        <c:forEach var="t" items="${types}">
            <input type="radio" name="type" value="${t}">${t}
        </c:forEach>
    </p>
    <p>
        <b>Value:</b>
        <br>
        <input type="text" name="value"/>
    </p>
    <p>
        <b>Date:</b>
        <br>
        <input type="date" name="date"/>
    </p>
    <input type="submit" value="Add">
</form>
</body>
</html>
