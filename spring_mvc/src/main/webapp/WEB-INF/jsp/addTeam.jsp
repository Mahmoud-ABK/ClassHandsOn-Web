<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Team</title>
    <!-- Link to the CSS stylesheet for styling -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div>
    <h1>Add Team</h1>
    <div>
        <form action="/teams/add" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Budget</td>
                    <td><input type="text" name="budget"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="save"/></td>
                </tr>
            </table>
        </form>
    </div>
<%--personal adding--%>
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
            <tr>
                <!-- Display each team's ID -->
                <td>${t.idTeam}</td>
                <!-- Display each team's name -->
                <td>${t.name}</td>
                <!-- Display each team's budget -->
                <td>${t.budget}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>