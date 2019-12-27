<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>收据详情</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
</head>

<body>
<!-- 详情 start -->
<%--style="position:absolute;width:200px;height:200px;left:35%;top:50%;margin-left:-250px;margin-top:-120px " --%>
<div class="wrap" style="position: absolute;left: 25%;top: 40%">
    <div class="prosum_box">
        <p class="pros_title" style="font-size: 20px">收款人：<font color="red">${route.name}</font></p>
        <%--<p class="hot">${route.routeIntroduce}</p>--%>
        <div class="pros_other">
            <p style="font-size: 20px">今收到财务部 <font color="red">${route.time}</font> 现金工资 <font color="red">${route.money}</font>，人民币大写 <font
                    color="red">${route.bigMoney}</font></p>
        </div>

    </div>
    <p class="collect" style="text-align: center">
        <%--红色按钮--%>
        <a id="bt1" onclick="downloadWord()" class="btn">
            点击下载
        </a>
    </p>
    <%--<div class="pros_price">

    </div>--%>
</div>

<!--引入头部-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->

<script>

    function downloadWord() {
        window.location.href = "${pageContext.request.contextPath}/receipt?methodName=downloadWord&id=${route.id}";
    }
</script>


</body>
</html>
