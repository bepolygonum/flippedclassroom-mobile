<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>新建班级</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../../assets/css/app.css">
    <script src="../../../../../assets/js/echarts.min.js"></script>
    <style type="text/css">
        .inputxext {
            height: 30px;
            border-radius: 5px;
            outline: none;
            border-top-style: groove;
            border-right-style: groove;
            border-bottom-style: groove;
            border-left-style: groove;
            border: 1px solid #a1a1a1;
        }

        .tdstyle {
            word-break: keep-all;
            white-space: nowrap;
        }

        .mybutton {
            height: 40px;
            border-radius: 5px;
            width: 100%;
            background-color: #337ab7;
            color: #ffffff;
        }
    </style>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="classinformation.html">
            <div class="am-icon-times" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>新建班级</h3>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">
        <span class="am-icon-bars"></span>
    </button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">

            <li><a href="index_message.html" class="tpl-header-list-link"><span class="am-icon-envelope-o"></span> 消息管理</a></li>
            <li><a href="index_personal.html" class="tpl-header-list-link"><span class="am-icon-user"></span> 个人信息</a></li>
            <li><a href="index_personal.html" class="tpl-header-list-link"><span class="am-icon-leanpub"></span> 讨论课</a></li>
            <li><a href="login.html" class="tpl-header-list-link"><span class="am-icon-power-off"></span>退出</a></li>

        </ul>
    </div>
</header>

<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-portlet-components">
        <table style="table-layout:fixed;">
            <tr>
                <td class="tdstyle">班级名: </td>
                <td><input type="text" class="inputxext" placeholder="年级-班级"></td>
            </tr>
            <tr>
                <td class="tdstyle">上课时间: </td>
                <td><input type="text" class="inputxext"></td>
            </tr>
            <tr>
                <td class="tdstyle">上课地点: </td>
                <td><input type="text" class="inputxext"></td>
            </tr>
            <tr>
                <td class="tdstyle">学生名单: </td>
                <td><input type="file" style="width: 100%"></td>
            </tr>
        </table>
    </div>
    <button type="submit" class="mybutton">保存</button>
</div>

<script src="../../../../../assets/js/jquery.min.js"></script>
<script src="../../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../../assets/js/app.js"></script>
</body>

</html>