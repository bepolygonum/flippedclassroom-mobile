<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>学生组队</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="courselist.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>学生组队</h3>
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
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <#if teamList?exists>
                        <#list teamList as team>
                            <#if klassList?exists>
                                <#list klassList as klass>
                                    <#if klass.getId()==team.getKlass_id()>
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <span>${klass.getKlass_serial()}-${team.getTeam_serial()}</span>
                            <span style="margin-left: 30px">${team.getTeam_name()}</span>
                            <span style="margin-left: 40px">
                                <#if team.getStatus()==0> invaild
                                <#elseif team.getStatus()==1> vaild
                                <#else> audit
                                </#if>
                            </span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <#if klassStudentList?exists>
                                        <#list klassStudentList as klassStudent>
                                        <#if klassStudent.getTeam_id()==team.getId()>
                                    <#if studentList?exists>
                                        <#list studentList as student>
                                        <#if student.getId()==klassStudent.getStudent_id()>

                                            <#if student.getId()==team.getLeader_id()>
                                        <tr>
                                            <td>组长</td>
                                            <td>${student.getAccount()}</td>
                                            <td>${student.getStudent_name()}</td>
                                        </tr>

                                            <#else>
                                        <tr>
                                            <td>组员</td>
                                            <td>${student.getAccount()}</td>
                                            <td>${student.getStudent_name()}</td>
                                        </tr>
                                            </#if>
                                        </#if>
                                        </#list>
                                    </#if>
                                        </#if>
                                        </#list>
                                    </#if>
                                </table>
                            </li>

                        </ul>
                    </li>
                                    </#if>
                                </#list>
                            </#if>
                        </#list>
                    </#if>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>