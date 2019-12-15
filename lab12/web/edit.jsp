<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Изменить значение</title>
</head>
<body>
<a href="/meters"></a>
<p style="color: red">${message}</p>
<form method="post">
    <input type="hidden" value="${meter.id}" name="id" />
    <p>
        <b>Тип:</b><br>
        <p><input type="radio" name="type" value="electricity" />электричество</p>
        <p><input type="radio" name="type" value="hot_water">горячая вода</p>
        <p><input type="radio" name="type" value="cold_water">холодная вода</p>
    </p>
    <p>
        <b>Значение:</b><br>
        <input name="value" value="${meter.value}" type="text"/>
    </p>
    <p>
        <b>Дата:</b><br>
        <input type="date" name="date" value="${meter.date}" type="text"/><br>
    </p>
    <input type="submit" value="Изменить" />
</form>
</body>
</html>
