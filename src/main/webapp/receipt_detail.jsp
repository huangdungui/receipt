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
<div class="wrap">
    <div class="prosum_box">
        <p class="pros_title">收款人：${route.name}</p>
        <%--<p class="hot">${route.routeIntroduce}</p>--%>
        <div class="pros_other">
            <p>今收到财务部 <font color="red">${route.time}</font> 现金工资 <font color="red">${route.money}</font>，人民币大写 <font
                    color="red">${route.bigMoney}</font> 元整</p>
        </div>

    </div>
    <p class="collect" style="text-align: center">
        <%--红色按钮--%>
        <a id="bt1" class="btn">
            点击下载
        </a>
    </p>
    <%--<div class="pros_price">

    </div>--%>
</div>
<!-- 详情 end -->

<!--引入头部-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->


<%--

&lt;%&ndash;根据用户状态显示不同的按钮&ndash;%&gt;
<script>
    $(function(){
        var url="/travel/favorite";
        var data="methodName=isFavorite&rid=${route.rid}";
        $.post(url,data,function(d){
            if(d==0){
                //没登录 隐藏灰色
                $("#bt2").hide();
            }else if(d==1){
                //用户登录了没有收藏
                $("#bt2").hide();
            }else if(d==2){
                //用户登录了也收藏了
                $("#bt1").hide();
            }
        });
    })
</script>

<script>
    $(function(){
        $("#bt1").click(function(){
            var url="/travel/favorite";
            var data="methodName=saveFavorite&rid=${route.rid}";
            $.post(url,data,function(d){
                if(d=="no"){
                    // 登录页面
                    location.href="/travel/login.jsp";
                }else{
                    // 隐藏红色按钮显示灰色按钮
                    $("#bt1").hide();
                    $("#bt2").show();
                    // 显示收藏次数
                    $("#sp1").html("已收藏"+d+"次");
                }
            })
        })
    })
</script>--%>


</body>
</html>
