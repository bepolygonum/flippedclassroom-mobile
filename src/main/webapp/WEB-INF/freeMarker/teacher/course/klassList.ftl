<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>班级信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
    <style type="text/css">
        .tdstyle {
            word-break: keep-all;
            white-space: nowrap;
        }
    </style>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="courselist.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>班级信息</h3>
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
    <#if klassList?exists>
        <#list klassList as klass>
    <div class="tpl-portlet-components">
        <hr>
        <div style="text-align: center">
            <h3 style="color:#337ab7">${klass.getGrade()}-${klass.getKlassSerial()}</h3>
        </div>
        <table>
            <tr>
                <td class="tdstyle">讨论课时间:</td>
                <td style="float: right">
                    <table>
                        <tr>
                            <td>${klass.getKlassTime()}</td>
                        </tr>

                    </table>
                </td>
            </tr>
            <tr>
                <td class="tdstyle">讨论课地点:</td>
                <td style="float: right">
                    <table>
                        <tr>
                            <td>${klass.getKlassLocation()}</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>学生名单:</td>
                <td style="float: right">
                    <table>
                        <tr>
                            <td>学生文件</td>
                        </tr>
                        <tr>
                            <td><input type="file" style="width: 100%">
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>
                    <p><button type="submit" class="am-btn am-btn-default" style="color: #337ab7">提交</button></p>
                </td>
                <td style="float: right">
                    <p><button type="submit" class="am-btn am-btn-default">删除班级</button></p>
                </td>
            </tr>
        </table>
    </div>
        </#list>
    </#if>


    <div class="tpl-portlet-components">
        <li class="tpl-left-nav-item">
            <a class="nav-link tpl-left-nav-link-list" href="/teacher/course/klass/create?id=${id}&courseId=${courseId}">
                <i class="am-icon-plus"></i>
                <span>新建班级</span>
                <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
            </a>
        </li>
    </div>
</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>