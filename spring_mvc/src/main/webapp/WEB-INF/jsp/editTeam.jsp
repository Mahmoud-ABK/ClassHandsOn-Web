<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>edit Team</title>
    <!-- Link to the CSS stylesheet for styling -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>

<h1>edit Team</h1>
<div>
    <!-- Start of the form for editing team details -->
    <form action="/teams/edit" method="get">
        <!-- Specifies that the form will be submitted as a GET request to "/teams/edit" -->

        <table>
            <tr>
                <td>REF</td>
                <td><input type="text" name="ref" value="${idTeam}" readonly/></td>
                <!-- The team ID is displayed as a read-only field. The value is populated with the "idTeam" variable from the model. -->
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${name}"/></td>
                <!-- The name field for the team. The value is populated with the "name" variable from the model. -->
            </tr>
            <tr>
                <td>Budget</td>
                <td><input type="text" name="budget" value="${budget}"/></td>
                <!-- The budget field for the team. The value is populated with the "budget" variable from the model. -->
            </tr>
            <tr>
                <td><input type="hidden" name="mc" value="${motCle}"/></td>
                <!-- A hidden field to store the search keyword (motCle) that was used for filtering. -->
                <td><input type="hidden" name="edit" value="1"/></td>
                <!-- A hidden field indicating that this is an edit operation. "1" means it is an edit action. -->
            </tr>
            <tr>
                <td><input type="submit" name="action" value="save"/></td>
                <!-- A submit button to save the changes. When clicked, it sends the form data to the server. -->
            </tr>
        </table>
    </form>
</div>

</body>
</html>
