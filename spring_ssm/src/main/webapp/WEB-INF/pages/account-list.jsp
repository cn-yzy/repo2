
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
        <center>
            <table border="1" cellspacing="0" cellpadding="10">
                <thead>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>MONEY</th>
                </thead>
                <tbody>
                    <c:forEach var="account" items="${requestScope.accountList}">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.name}</td>
                            <td>${account.money}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </center>
</body>
</html>
