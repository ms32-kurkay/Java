<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
                username:
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                password:
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="Register">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

