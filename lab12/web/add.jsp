<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Добавить значение</title>
</head>
<body>
<h3>Добавить новое значение </h3>
<a href="/meters"></a>
<p style="color: red">${message}</p>
<form action="/add_value" method="post">
    <p>
        <b>Тип:</b>
        <br>
        <p><input type="radio" name="type" value="electricity">электричество</p>
        <p><input type="radio" name="type" value="hot_water">горячая вода</p>
        <p><input type="radio" name="type" value="cold_water">холодная вода</p>
    </p>
    <p>
        <b>Значение:</b>
        <br>
        <input type="text" name="value"/>
    </p>
    <p>
        <b>Дата:</b>
        <br>
        <input type="date" name="date"/>
    </p>
    <input type="submit" value="Добавить">
</form>
</body>
</html>
