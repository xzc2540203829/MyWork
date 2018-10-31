<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 4:23 PM
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
        width: 120px;
        height: 20px;
    }
    #b{
        width: 120px;
        font-size: 40px;
    }
    #c{
        width: 700px;
        height: 200px;
    }
</style>
<body>
﻿<jsp:include page="../WEB-INF/sideBar.jsp"></jsp:include>
<form action="<%=basePath%>/letter/createCipherKey" method="post">
    张华的学号：
    <input id="a" name="studentNum" value="0160478">
    <br>
    张华将李俊的密文解码后得到的明文：
    <br>
    <input  id="c" name="mess_cipher1" value="Welcome to cipher world!">
    <br>
    <input type="submit" id="b" value="创建张华的秘钥">
</form>
</body>
</html>
