<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>收据</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
</head>

<body>


<form id="registerForm">

    <div class="modal-body">
        <%--隐藏域提交数据--%>
        <input type="hidden" name="methodName" value="register"/>


        <div class="form-group">
            <label for="date">收款日期</label>
            <input type="date" class="form-control" name="time" id="date">
        </div>
        <div class="form-group">
            <label for="money">现金</label>
            <input type="text" class="form-control" name="money" id="money" placeholder="请输入收款金额">
        </div>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入姓名">
        </div>


    </div>
    <div class="modal-footer" style="text-align: center">
        <span id="errorMsg" style="color: red;"></span>
        <button type="button" class="btn btn-primary" id="registerId">提交</button>
    </div>
</form>

<script>

    $(function () {
        $("#registerId").click(function () {

            var url = "/invoice/receipt";
            var data = $("#registerForm").serialize();
            $.post(url, data, function (d) {
                if (d == 0) {
                    $("#errorMsg").html("服务器发生了错误，请稍后尝试");
                } else if (d == 1) {
                    $("#errorMsg").html("收据添加成功");
                    //清除填写框
                    $("#name").val("");
                    $("#money").val("");
                    $("#date").val("");
                }
            })
        })
    });

</script>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
