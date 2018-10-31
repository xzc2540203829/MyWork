<%--
  Created by IntelliJ IDEA.
  User: xiongzhongchi
  Date: 2018/10/28
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
﻿<style>
a,p{ word-wrap:break-word; word-break:normal; }
</style>
<aside style=" border-right:solid black 2px; padding-right: 6px;margin-right:10px;width: 20%; float: left;height: 100%">
    <div style="margin: auto;text-align:center">导航栏</div>
    <p>初始李俊发给张华的密文：2770d0b53955accfd6b97b160c699ebe7e0aeb843f1fff9cfd9498e8c6ae50358ffd37174f3880efcab8523ef692fcdd</p>
    <p>张华的学号：0160478</p>
    <ol>
        <li><a href="decodeKey.jsp">张华对李俊的cipher1进行解码</a> </li>
        <li><a href="createKey.jsp">张华创建自己的秘钥</a> </li>
        <li><a href="cipher.jsp">张华利用自己的秘钥加密明文</a> </li>
        <li><a href="decodeText.jsp">李俊收到张华的密文后进行解码</a> </li>
    </ol>
</aside>
