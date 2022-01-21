<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2> All USERS </h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Mail</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="use" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${use.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="userId" value="${use.id}"/>
        </c:url>

        <tr>
            <td>${use.name}</td>
            <td>${use.surname}</td>
            <td>${use.email}</td>
            <td>
                <input type="button" value="update"
                onclick="window.location.href='${updateButton}'"/>

                <input type="button" value="delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>

        </tr>

    </c:forEach>

</table>

<br>
<input type="button" value="Add"
onclick="window.location.href = 'addNewUser'">

</body>
</html>