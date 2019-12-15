<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Таблица показателей</title>
    <style>
        table {
            border-spacing: 0;
            width: 100%;
            border: 1px solid #000000;
        }

        th {
            cursor: pointer;
        }

        th, td {
            text-align: left;
            padding: 16px;
            border: 1px solid #000000;
        }

        tr:nth-child(even) {
            border: 1px solid #000000;
        }
    </style>
    <script>
        function tableSearch() {
            var phrase = document.getElementById('search-text');
            var table = document.getElementById('info-table');
            var regPhrase = new RegExp(phrase.value, 'i');
            var flag = false;
            for (var i = 1; i < table.rows.length; i++) {
                flag = false;
                for (var j = table.rows[i].cells.length - 1; j >= 0; j--) {
                    flag = regPhrase.test(table.rows[i].cells[j].innerHTML);
                    if (flag) break;
                }
                if (flag) {
                    table.rows[i].style.display = "";
                } else {
                    table.rows[i].style.display = "none";
                }

            }
        }
        function sortTable(n) {
            var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
            table = document.getElementById("info-table");
            switching = true;
            // Set the sorting direction to ascending:
            dir = "asc";
            /* Make a loop that will continue until
            no switching has been done: */
            while (switching) {
                // Start by saying: no switching is done:
                switching = false;
                rows = table.getElementsByTagName("TR");
                /* Loop through all table rows (except the
                first, which contains table headers): */
                for (i = 1; i < (rows.length - 1); i++) {
                    // Start by saying there should be no switching:
                    shouldSwitch = false;
                    /* Get the two elements you want to compare,
                    one from current row and one from the next: */
                    x = rows[i].getElementsByTagName("TD")[n];
                    y = rows[i + 1].getElementsByTagName("TD")[n];
                    /* Check if the two rows should switch place,
                    based on the direction, asc or desc: */
                    if (dir == "asc") {
                        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                            // If so, mark as a switch and break the loop:
                            shouldSwitch = true;
                            break;
                        }
                    } else if (dir == "desc") {
                        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                            // If so, mark as a switch and break the loop:
                            shouldSwitch = true;
                            break;
                        }
                    }
                }
                if (shouldSwitch) {
                    /* If a switch has been marked, make the switch
                    and mark that a switch has been done: */
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    // Each time a switch is done, increase this count by 1:
                    switchcount ++;
                } else {
                    /* If no switching has been done AND the direction is "asc",
                    set the direction to "desc" and run the while loop again. */
                    if (switchcount == 0 && dir == "asc") {
                        dir = "desc";
                        switching = true;
                    }
                }
            }
        }
    </script>
</head>
<body>
<h3>Показатели счетчиков</h3>
<a href="/main">Вернуться на главную</a>
<a href="add_value">Добавить новый показатель</a><br>
<br>
<input class="form-control" type="text" placeholder="Поиск..." id="search-text" onkeyup="tableSearch()">
<table id="info-table">
    <tr>
        <th onclick="sortTable(0)">Тип</th>
        <th onclick="sortTable(1)">Значение</th>
        <th onclick="sortTable(2)">Дата</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
    <c:forEach var="m" items="${meters}">
        <tr>
            <td>${m.type}</td>
            <td>${m.value}</td>
            <td>${m.date}</td>
            <td>
                <form method="get" action='<c:url value="/edit_meter?id=${m.id}"/>' style="display:inline;">
                    <input type="hidden" name="id" value="${m.id}">
                    <input type="submit" name="submit" value="Edit">
                </form>
            </td>
            <td>
                <form method="post" action='<c:url value="/delete_value"/>' style="display:inline;">
                    <input type="hidden" name="id" value="${m.id}">
                    <input type="submit" name="submit" value="Delete">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
