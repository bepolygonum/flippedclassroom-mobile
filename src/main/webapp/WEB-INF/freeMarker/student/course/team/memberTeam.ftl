<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生组队</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../../../../../assets/i/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../../assets/css/app.css">
    <script src="../../../../../assets/js/echarts.min.js"></script>
    <script>
        function  conf() {
            var r=confirm("确认退出小组？");
            if(r==true)
            {}
            else
            {}
        }
    </script>

</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="seminar1.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>${course.getCourseName()}</h3>
    </div>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">

        <span class="am-icon-bars"></span>
    </button>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                    <li><a href="index_message.html"><span class="am-icon-envelope-o"></span> 消息管理</a></li>
                    <li><a href="index_personal.html"><span class="am-icon-user"></span> 个人信息</a></li>
                    <li><a href="index_personal.html"><span class="am-icon-leanpub"></span> 讨论课</a></li>
                    <li><a href="login.html"><span class="am-icon-power-off"></span>退出</a></li>
        </ul>
    </div>
</header>

<div class="tpl-page-container1 tpl-page-header-fixed" >
    <div class="tpl-portlet-components2">
        <div class="tpl-block">

            <div class="am-g">
                <div class="am-u-sm-12">
                    <div style="text-align: center"><span class="myLabel">${myteam.getTeamName()}</span>
                        <a  style="margin-left: 10%">
                        <#if myteam.getStatus()==0 > 不合法
                        <#else >合法
                        </#if>
                        </a>
                    </div>

                    <table class="am-table am-table-striped am-table-hover table-main">
                        <#list memberTeam as member>
                        <tr>
                            <#if member.getId()==myteam.getLeaderId()>
                                <td>组长</td>
                            <#else >
                                <td>组员</td>
                            </#if>
                            <td>${member.getAccount()}</td>
                            <td>${member.getStudentName()}</td>
                        </tr>
                        </#list>
                    </table>
                    <button onclick="conf()" class="am-btn am-btn-danger" style="margin-top: 3rem;width: 100%">退组</button>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>