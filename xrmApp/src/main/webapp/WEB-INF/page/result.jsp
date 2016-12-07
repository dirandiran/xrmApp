<%--
  Created by IntelliJ IDEA.
  User: diran
  Date: 07.12.2016
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>

</head>
<body>

<table>
    <thead align="center" >
    <tr>
        <th> id </th>
        <th> Company name </th>

    </tr>
    </thead>
    <tbody align="center">
    <c:forEach items="${listCompany}" var="company">
        <tr>
            <td> ${company.id} </td>
            <td> ${company.companyName} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
