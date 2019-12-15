<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
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
                <td>
                    <input type="submit" name="login" value="Войти">
                </td>
                <td>
                    <a href="registration.jsp">Регистрация</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
