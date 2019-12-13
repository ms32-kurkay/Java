<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>factory.Electricity</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
        }
        table th,
        table td {
            padding: 0 3px;
        }
        table.brd th,
        table.brd td {
            border: 1px solid #000;
        }
    </style>
</head>
<body>
<h3>ElectricityPage values</h3>
<a href="/add_value">Add new value</a><br>
<table class="brd">
    <tr>
        <th>Type</th>
        <th>Value</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="m" items="${meters}">
        <tr>
            <td>${m.type}</td>
            <td>${m.value}</td>
            <td>${m.date}</td>
            <td>
                <form method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${m.id}">
                    <input type="submit" name="submit" value="Edit">
                </form>
            </td>
            <td>
                <form method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${m.id}">
                    <input type="submit" name="submit" value="Delete">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
