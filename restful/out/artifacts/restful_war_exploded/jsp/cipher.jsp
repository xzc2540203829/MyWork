<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 10:17 AM
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
﻿<style>
    #b{
        width: 120px;
        font-size: 40px;
    }
    #c{
        width: 600px;
        height: 100px;
    }
</style>
<body>
﻿<jsp:include page="../WEB-INF/sideBar.jsp"></jsp:include>
<form action="<%=basePath%>/letter/createCipherText" method="post">
    张华的密钥：
    <br>
    <input id="c" name="zh_key">
    <br>
    张华的明文：
    <br>
    <input id="c" name="zh_mess" value="This is a test !">
    <br>
    <input type="submit" id="b" value="创建张华的密文">
</form>
</body>
</html>
