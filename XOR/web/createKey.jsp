<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
﻿<style>
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
<form action="" method="post">
    张华的学号：
    <input id="a" name="studentNum">
    <br>
    张华将李俊的密文解码后得到的明文：
    <br>
    <textarea id="c" name="key"></textarea>
    <br>
    <input type="submit" id="b" value="创建张华的秘钥">
</form>
</body>
</html>
