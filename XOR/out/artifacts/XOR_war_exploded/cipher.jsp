<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="" method="post">
    张华的密钥：
    <br>
    <textarea id="c" name="key"></textarea>
    <br>
    张华的明文：
    <br>
    <textarea id="c" name="mess"></textarea>
    <br>
    <input type="submit" id="b" value="创建张华的密文">
</form>
</body>
</html>
