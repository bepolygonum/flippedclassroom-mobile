<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>课程管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
    <script>
        function conf() {
            var r = confirm("确认报名该次讨论课？");
            if (r == true) {} else {}
        }
    </script>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="homepage.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>${seminar.getSeminarName()}</h3>
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
<div class="tpl-content-wrapper" style="margin-top: 5rem">
    <div class="tpl-portlet-components1">

<#assign count =0/>
        <div class="tpl-block">
            <div class="am-g tpl-amazeui-form">
                <div class="">
                    <#if attendanceList?exists>
                    <#list attendanceList?sort_by("teamOrder")  as attendance >
                    <#assign count++>
                    <#if attendance.getTeamOrder() == count>
                    <div style="margin-bottom:0.5rem">
                        <lable class="mylabel">第${attendance.getTeamOrder()}组：</lable>
                        <div class="myDiv">
                                <label class="myLabel">
                            <#if attendance.getPptName()?exists>
                                ${attendance.getPptName()}
                                <#else>
                                未上传
                            </#if>
                                </label>
                        </div>
                    </div>
                    <#else>
                    <div>
                        <lable class="mylabel">第${count}组</lable>
                        <div class="myDiv">
                            <a onclick="conf()" style="color: #23c0c0;font-size: 1.5rem;font-weight: 800;">可报名</a>
                        </div>
                    </div>
                    </#if>
                    </#list>
                        <#else>
                            <#list 1..roundCount as i>
                            <div>
                                <lable class="mylabel">第${i}组</lable>
                                <div class="myDiv">
                                    <a onclick="conf()" style="color: #23c0c0;font-size: 1.5rem;font-weight: 800;">可报名</a>
                                </div>
                            </div>
                            </#list>
</#if>

                </div>
            </div>


            <script src="../../../../assets/js/jquery.min.js"></script>
            <script src="../../../../assets/js/amazeui.min.js"></script>
            <script src="../../../../assets/js/app.js"></script>
</body>

</html>