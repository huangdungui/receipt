<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>收据</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/waves.min.css?v=0.7.2">
    <style>
        #colored-button .btn {
            color: #fff;
        }

        #colored-button a,
        #colored-button a:hover {
            background: #01BCFF;
        }

        #colored-button button,
        #colored-button button:hover {
            background: #1bb556;
        }

        #colored-button input,
        #colored-button input:hover {
            background: #ff4f0f;
        }
    </style>

</head>

<body>
<div class="center-in-center">
    <p id="colored-button" class="text-center">
        <a target="_blank" class="btn float-buttons waves-effect waves-button waves-float" href = 'receipt.jsp'>添加收据</a>
        <i class="btn float-buttons waves-input-wrapper waves-effect waves-button waves-float" style="color: rgb(255, 255, 255); background: rgb(255, 79, 15)">
            <input onclick='window.open("/invoice/receipt?methodName=MyReceipt&pageNumber=1")' class="waves-button-input" type="submit" value="查看收据" style="background-color: rgba(0,0,0,0);"></i>
    </p>

</div>

  <style type="text/css">
      *{
          margin: 0;
          padding: 0;
          background-color: #EAEAEA;
      }

      .center-in-center{
          position: absolute;
          top: 50%;
          left: 50%;
      }
  </style>


  <script type="text/javascript">
    Waves.attach('.flat-buttons', ['waves-button']);
    Waves.attach('.float-buttons', ['waves-button', 'waves-float']);
    Waves.attach('.float-button-light', ['waves-button', 'waves-float', 'waves-light']);
</script>
<script type="text/javascript" src="js/waves.min.js?v=0.7.1"></script>
<!-- jQuery  -->
  <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
    var currentRoute = false;
    $(document).on('ready', function () {

        // Init Waves
        Waves.init();
        Waves.attach('.drag-ripple', 'waves-block', true);
        Waves.attach('#bg-pattern', null, true);
        init();
        $(window).on('hashchange', routing);
        /**
         * Example source code click
         */
        $('#example .top-button').on('click', function () {
            var type = $(this).data('code');
            $('#source-code .box .code').addClass('hide');
            $('#source-code .box #code-' + type).removeClass('hide');
            $('#source-code').removeClass('hide');
            setTimeout(function () {
                $('#source-code').addClass('show');
            }, 50);
        });
        $('#source-code .top-button').on('click', function () {

            $('#source-code').removeClass('show');

            setTimeout(function () {
                $('#source-code .box .code').addClass('hide');
                $('#source-code').addClass('hide');
            }, 500);
        });
    });

</script>

</body>
</html>
