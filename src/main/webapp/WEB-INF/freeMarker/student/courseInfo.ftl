<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../../../assets_student/i/favicon.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../../../assets_student/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../assets_student/css/app.css">
    <script src="../../../assets_student/js/echarts.min.js"></script>
</head>
<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="seminar1.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>${course.getCourse_name()}</h3>
    </div>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">

        <span class="am-icon-bars"></span>
    </button>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${student.getStudent_name()}</span>
                </a>
                <ul class="am-dropdown-content" id="topbat-content">
                    <li><a href="index_message.html"><span class="am-icon-envelope-o"></span> 消息管理</a></li>
                    <li><a href="index_personal.html"><span class="am-icon-user"></span> 个人信息</a></li>
                    <li><a href="index_personal.html"><span class="am-icon-leanpub"></span> 讨论课</a></li>
                    <li><a href="login.html"><span class="am-icon-power-off"></span>退出</a></li>
                </ul>

            </li>
        </ul>
    </div>
</header>
<div class="tpl-content-wrapper" style="margin-top: 5rem">
    <div class="tpl-portlet-components1">
        <div class="tpl-block">
            <div class="am-g tpl-amazeui-form">
                <div class="">
                    <div>
                        <lable class="mylabel">课程简介：</lable>
                        <div class="myDiv">
                            <label class="myLabel"></label>
                        </div>
                    </div>
                    <br><br>
                    <div >
                        <lable class="mylabel">成绩计算规则：</lable>
                        <div class="myDiv">
                            <label class="myLabel">课堂展示${course.getPresentation_percentage()}%</label><br>
                            <label class="myLabel">课堂提问${course.getQuestion_percentage()}%</label><br>
                            <label class="myLabel">书面报告${course.getReport_percentage()}%</label>
                        </div>
                    </div>
                    <div>
                        <lable class="mylabel">小组人数：</lable>
                        <div class="myDiv">
                            <label class="myLabel">${courseMemberLimitStrategy.getMin_member()}~${courseMemberLimitStrategy.getMax_member()}</label>
                        </div>
                    </div>
                    <div>
                        <lable class="mylabel">组队开始时间：</lable>
                        <div class="myDiv">
                            <label class="myLabel">${course.getTeam_start_time()}</label>
                        </div>
                    </div>
                    <div >
                        <lable class="mylabel">组队截止时间：</lable>
                        <div class="myDiv">
                            <label class="myLabel">${course.getTeam_end_time()}</label>
                        </div>
                    </div>
                    <div >
                        <lable class="mylabel">组队性别要求：</lable>
                        <div class="myDiv">
                            <label class="myLabel">男：2~4 女：2~4</label>
                        </div>
                    </div>
                    <div >
                        <lable class="mylabel">组员星座要求：</lable>
                        <div class="myDiv">
                            <label class="myLabel" >无</label>
                        </div>
                    </div>
                    <div >
                        <lable class="mylabel">冲突课程：</lable>
                        <div class="myDiv">
                            <label class="myLabel" >.Net（xx老师）</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../../../assets_student/js/jquery.min.js"></script>
        <script src=../../../assets_student/js/amazeui.min.js"></script>
        <script src="../../../assets_student/js/app.js"></script>
</body>

</html>