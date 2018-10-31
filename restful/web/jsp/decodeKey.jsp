<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #a{
        width: 700px;
        height: 100px;
    }
    #b{
        width: 120px;
        font-size: 40px;
    }
</style>
<body>
﻿<jsp:include page="../WEB-INF/sideBar.jsp"></jsp:include>
﻿  <form action="<%=basePath%>/letter/getCipherKey" method="post">
    李俊发给张华的秘文：
    <br>
    <input id="a" name="cipher1" value="2770d0b53955accfd6b97b160c699ebe7e0aeb843f1fff9cfd9498e8c6ae50358ffd37174f3880efcab8523ef692fcdd">
    <br>
    <input type="submit" id="b" value="解密李俊的秘文">
</form>
</body>
</html>
