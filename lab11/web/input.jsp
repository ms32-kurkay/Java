<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Input</title>
    </head>
<body>
    <h3>Вводная информация:</h3>
        <form method="post">
            <p>1) Вывести сведения о погоде в заданном регионе.</p>
            <p>Введите регион:</p>
            <input type="text" name="region1"/>
            <p>2) Вывести даты, когда в заданном регионе шел снег и температура была ниже заданной отрицательной.</p>
            <p>Введите регион:</p>
            <input type="text" name="region2"/>
            <p>Введите нижний порог температуры:</p>
            <input type="number" name="temp2"/>
            <p>3) Вывести информацию о погоде за прошедшую неделю в регионах, жители которых общаются на заданном языке.</p>
            <p>Введите язык:</p>
            <input type="text" name="lang3"/>
            <p>4) Вывести среднюю температуру за прошедшую неделю в регионах с площадью больше заданной.</p>
            <p>Введите минимальную площадь:</p>
            <div><input type="number" name="area4"/></div>
            <br>
            <br>
            <input type="submit" value="Узнать результат">
        </form>
</body>
</html>