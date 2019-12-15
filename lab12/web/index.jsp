<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<p>
    Привет, ${user}
    <a href="/exit">Выход</a>
</p>
<table>
    <tr><a href="/meters">Таблица показаний счетчиков</a></tr>
    <tr>
        <td><a href="/calculate_electricity">Рассчитать стоимость электроэнергии</a></td>
    </tr>
    <tr><td><a href="/calculate_water">Рассчитать стоимость воды</a></td></tr>
</table>


</body>
</html>
