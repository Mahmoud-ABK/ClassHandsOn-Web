<%--before example code--%>
<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <title>MY TEAMS!!</title></head>--%>
<%--<body>--%>
<%--<h1> Hello Web Layer </h1>--%>
<%--</body>--%>
<%--</html>--%>

<%--First example jsp --%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Teams Management</title>
    <!-- Link to the CSS stylesheet for styling -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div>
    <%-- example 1 code   --%>
    <%--    <!-- Form for searching teams -->--%>
    <%--    <form action="/teams/search" method="post">--%>
    <%--        <table>--%>
    <%--            <tr>--%>
    <%--                <td>Mot Clé:</td> <!-- Label for the search input -->--%>
    <%--                <td><input type="text" name="motCle" /></td> <!-- Input field for the search keyword -->--%>
    <%--                <td><input type="submit" name="action" value="search" /></td> <!-- Submit button for the search form -->--%>
    <%--            </tr>--%>
    <%--        </table>--%>
    <%--    </form>--%>
    <form action="/teams/search" method="post">
        <table>
            <tr>
                <td>Mot Clé:</td>
                <td><input type="text" name="motCle" value="${motCle}"/></td>
                <td><input type="submit" name="action" value="Search"/></td>
            </tr>
        </table>
    </form>

    <!-- Table to display the list of teams -->
    <table class="tabteams">
        <tr>
            <!-- Table headers for the team details -->
            <th>REF</th>
            <th>Name</th>
            <th>Budget</th>
        </tr>

        <!-- Loop through the list of teams passed from the controller -->
        <c:forEach items="${teams}" var="t">
            <%-- before delete team code--%>
            <%--            <tr>--%>
            <%--                <!-- Display each team's ID -->--%>
            <%--                <td>${t.idTeam}</td>--%>
            <%--                <!-- Display each team's name -->--%>
            <%--                <td>${t.name}</td>--%>
            <%--                <!-- Display each team's budget -->--%>
            <%--                <td>${t.budget}</td>--%>
            <%--            </tr>--%>
            <tr>
                <td>${t.idTeam}</td>
                <!-- Displays the ID of the team. The `idTeam` is dynamically retrieved from the `t` object. -->

                <td>${t.name}</td>
                <!-- Displays the name of the team. The `name` is dynamically retrieved from the `t` object. -->

                <td>${t.budget}</td>
                <!-- Displays the budget of the team. The `budget` is dynamically retrieved from the `t` object. -->

                <td>
                    <a onclick="return confirm('Please Confirm')" href="/teams/delete?ref=${t.idTeam}&mc=${motCle}">
                        <!-- Creates a hyperlink to delete a team. -->

                        <!-- `onclick="return confirm('Please Confirm')"` -->
                        <!-- Displays a confirmation dialog box to the user before proceeding with the deletion. -->

                        <!-- `href="/teams/delete?ref=${t.idTeam}&mc=${motCle}"` -->
                        <!-- Sends a DELETE request to the `/teams/delete` endpoint with two query parameters:
                 1. `ref=${t.idTeam}`: Passes the team's ID (`idTeam`) as a reference for deletion.
                 2. `mc=${motCle}`: Passes the current search keyword (`motCle`) to maintain context. -->

                        Delete
                        <!-- The visible text of the link. -->
                    </a>
                </td>
<%--                edit a team code --%>
                <td>
                    <a href="/teams/edit?ref=${t.idTeam}&name=${t.name}&budget=${t.budget}&edit=0&mc=${motCle}">Edit</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>