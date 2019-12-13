<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12.12.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit meter</title>
</head>
<body>
<p style="color: red">${message}</p>
<form method="post" action="/edit_meter">
    <input type="hidden" value="${meter.id}" name="id" />
    <label>Type</label><br>
    <input name="type" value="${meter.type}" /><br><br>
    <label>Value</label><br>
    <input name="value" value="${meter.value}" type="text"/><br><br>
    <label>Date</label><br>
    <input name="date" value="${meter.date}" type="text"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
