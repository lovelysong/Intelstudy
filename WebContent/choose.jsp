<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>投票界面</title>
<link href="css/style2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="header">请进行投票</div>
   <form action="./ChooseServlet" method="post">
        <ul>
            <li>
                <div >
                     <input type="checkbox" name="company"
                       value="MicroSoft" > MicroSoft
                </div>
            </li>
            <li>
                <div >
                   <input type="checkbox" name="company"
                         value="Sun"> Sun
                </div>
            </li>
                        <li>
                <div >
                   <input type="checkbox" name="company"
                        value="IBM"> IBM
                </div>
            </li>
                        <li>
                <div >
                   <input type="checkbox" name="company"
                         value="Oracle"> Oracle
                </div>
            </li>
            <li>
                <input type="submit" value="投票">
            </li>
        </ul>
    </form>
    <div class="footer">
        <a href="">Copyright ©2018 Guo YuHao</a>
    </div>
</div>
</body>
</html>