<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20/2/17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有的用户信息</h3>

    <c:forEach items="${inforList}" var="Infor">
        ${Infor.username}<br>
        ${Infor.tname}<br>
    </c:forEach>

</body>
</html>
