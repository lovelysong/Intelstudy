<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>投票结果</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <link href="css/style3.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper">
            <div class="header">投票结果</div>
       <form action="./ShowServlet" method="post">
    <div id="main" style="width: 400px;height:400px;"></div>
    </form>
        <div class="footer">
        <a href="">Copyright ©2018 Guo YuHao</a>
    </div>
    </div>
    <script type="text/javascript" >
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var a = '<%=session.getAttribute("a")%>';
    var b = '<%=session.getAttribute("b")%>';
    var c = '<%=session.getAttribute("c")%>';
    var d = '<%=session.getAttribute("d")%>';
    // 指定图表的配置项和数据
    var option = {
        tooltip: {},
        xAxis: {
            data: ["MicroSoft","Sun","IBM","Oracle"]
        },
        yAxis: {},
        series: [{
            name: '票数',
            type: 'bar',
            data: [a, b, c, d]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    </script>
</body>
</html>