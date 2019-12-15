<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="/login_register" method="post">
    <table>
        <tr>
            <td>
                <p style="color: red">${message}</p>
            </td>
        </tr>
        <tr>
            <td>
                Логин:
            </td>
            <td>
                <input type="text" name="user_name">
            </td>
        </tr>
        <tr>
            <td>
                Пароль:
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="reg" value="Зарегистрироваться">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

