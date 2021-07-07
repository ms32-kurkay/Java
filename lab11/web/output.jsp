<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Output</title>
</head>
<body>
<h3>Результат:</h3>
<p>1) Вывести сведения о погоде в заданном регионе.</p>
    <c:forEach var="v" items="${value1}">
        <p>${v}</p>
    </c:forEach>
<p>2) Вывести даты, когда в заданном регионе шел снег и температура была ниже заданной отрицательной.</p>
<c:forEach var="v" items="${value2}">
    <p>${v}</p>
</c:forEach>
<p>3) Вывести информацию о погоде за прошедшую неделю в регионах, жители которых общаются на заданном языке.</p>
<c:forEach var="v" items="${value3}">
    <p>${v}</p>
</c:forEach>
<p>4) Вывести среднюю температуру за прошедшую неделю в регионах с площадью больше заданной.</p>
<c:out value="${value4}"/>
</body>
</html>