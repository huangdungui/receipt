<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查看收据</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/index.css">
    <style>
        .tab-content .row > div {
            margin-top: 16px;
        }

        .tab-content {
            margin-bottom: 36px;
        }
    </style>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!-- 排行榜 start-->
<section id="content">
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="images/icon_5.jpg" alt="">
                <span>所有收据</span>
            </div>
        </div>
        <div class="jx_content">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="row">
                        <c:if test="${not empty pb.list}">
                            <c:forEach items="${pb.list}" var="route">
                                <div class="col-md-3">
                                    <a href="/invoice/receipt?methodName=findByReceipt&id=${route.id}" target="_blank">
                                        <div class="has_border">
                                            <h3>${route.name}</h3>
                                            <div class="price">收款时间：<strong>${route.time}</strong>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <div class="page_num_inf">
            <i></i> 共
            <span style="color: #FF4848;">${pb.totalPage}</span>页<span style="color: #FC8989;">${pb.totalCount}</span>条
            当前第
            <span style="color: #FF4444;">${pb.pageNumber}</span>页
        </div>

        <div class="pageNum">
            <ul>
                <c:if test="${pb.pageNumber != 1}">
                    <li><a href="http://localhost:8080/invoice/receipt?methodName=MyReceipt&pageNumber=1">首页</a></li>
                    <li class="threeword"><a
                            href="http://localhost:8080/invoice/receipt?methodName=MyReceipt&pageNumber=${pb.pageNumber - 1}">上一页</a>
                    </li>
                </c:if>


                <%--页码--%>

                <c:forEach begin="${pb.begin}" end="${pb.end}" step="1" var="page">
                    <li>
                        <a href="http://localhost:8080/invoice/receipt?methodName=MyReceipt&pageNumber=${page}">${page}</a>
                    </li>
                </c:forEach>


                <c:if test="${pb.pageNumber != pb.totalPage}">
                    <li class="threeword"><a
                            href="http://localhost:8080/invoice/receipt?methodName=MyReceipt&pageNumber=${pb.pageNumber + 1}">下一页</a>
                    </li>
                    <li class="threeword"><a
                            href="http://localhost:8080/invoice/receipt?methodName=MyReceipt&pageNumber=${pb.totalPage}">末页</a>
                    </li>
                </c:if>

            </ul>
        </div>
    </section>
</section>

</body>
</html>
