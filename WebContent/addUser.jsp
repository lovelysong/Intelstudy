 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"         "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册页面</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
 <div class="wrapper">
    <div class="header">欢迎来到注册界面</div>
   <form action="./AddUserServlet" method="post">
        <ul>
            <li>
                <div class="text">
                    <span class="yonghu"></span><input type="text" name="username" placeholder="请输入用户名">
                </div>
            </li>
             <li>
                <div class="text">
                    <span class="di"></span><input type="text" name="name" placeholder="请输入姓名">
                </div>
            </li>
            <li>
                <div class="password">
                    <span class="mima"></span><input type="password" name="password" placeholder="请输入密码">
                </div>
            </li>
            <li>
                <input type="submit" value="注册">
            </li>
        </ul>
    </form>
    <div class="footer">
        <a href="">Copyright ©2018 Guo YuHao</a>
    </div>
</div>
    </body>
    </html>