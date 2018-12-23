<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>课程信息</title>
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
            <div class="am-icon-times" style="color: darkgray"></div>
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

            <li><a href="index_message.html" class="tpl-header-list-link"><span class="am-icon-envelope-o"></span> 消息管理</a></li>
            <li><a href="index_personal.html" class="tpl-header-list-link"><span class="am-icon-user"></span> 个人信息</a></li>
            <li><a href="index_personal.html" class="tpl-header-list-link"><span class="am-icon-leanpub"></span> 讨论课</a></li>
            <li><a href="login.html" class="tpl-header-list-link"><span class="am-icon-power-off"></span>退出</a></li>

        </ul>
    </div>
</header>

<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-portlet-components">
        <hr/>
        <div style="text-align: center">
            <h3 style="color:#337ab7">${course.getIntroduction()}</h3>
        </div>
        <hr/>

        <div>
            <table style="margin: 0 15%">
                <tr>
                    <td>成绩计算规则: </td>
                    <td style="padding-left: 10%">
                        <table>
                            <tr>
                                <td>展示 ${course.getPresentationPercentage()}%</td>
                            </tr>
                            <tr>
                                <td>提问 ${course.getQuestionPercentage()}%</td>
                            </tr>
                            <tr>
                                <td>报告 ${course.getReportPercentage()}%</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>小组人数:</td>
                    <td style="float: right">${courseMemberLimitStrategy.getMinMember()}~${courseMemberLimitStrategy.getMaxMember()}</td>
                </tr>
                <tr>
                    <td>组队开始:</td>
                    <td style="float: right">
                        <table>
                            <tr>
                                <td>${course.getTeamStartTime()}</td>
                            </tr>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td>组队截止:</td>
                    <td style="float: right">
                        <table>
                            <tr>
                                <td>${course.getTeamEndTime()}</td>
                            </tr>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td>冲突课程:</td>
                    <td style="float: right">
                        <table>
                            <#if courseList?exists>
                                <#list courseList as conflictCourse>
                                    <#if teacherList?exists>
                                        <#list teacherList as teacher>
                                            <#if teacher.getId()==conflictCourse.getTeacherId()>
                            <tr>
                                <td>${conflictCourse.getCourseName()}(${teacher.getTeacherName()}老师)</td>
                            </tr>
                                            </#if>
                                        </#list>
                                    </#if>
                                </#list>
                            </#if>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <p><button type="submit" class="am-btn am-btn-default" style="float: right">删除此课程</button></p>
    </div>
</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>