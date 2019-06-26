<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Drafy
  Date: 2019/6/25
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>埋点列表</title>
</head>
<body>
    <table>
        <tr>
            <th>p_type</th>
            <th>p_name</th>
            <th>p_state</th>
        </tr>

        <c:forEach items="${p}" var="point">
            <%--${c}就是request传过来得city--%>
            <tr>
                <td>${point.p_type}</td>
                <td>${point.p_name}</td>
                <td>${point.p_state}</td>
            </tr>
        </c:forEach>


    </table>
</body>
</html>
