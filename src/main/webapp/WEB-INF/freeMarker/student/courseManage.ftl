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
    <link rel="stylesheet" href="../../../assets_student/css/admin.css">
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
        <h3>我的课程</h3>
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

<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-portlet-components">
        <div class="tpl-block">
            <div class="am-g">
            <#list  courseList as course>
            <#list  klassList as klass>

                <div class="am-u-sm-12">
                    <li class="tpl-left-nav-item"  >
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list" style="width: 120%;margin-left: -2rem">
                            <label class="courseName">${course.getCourse_name()}</label><span style="margin-left: 1rem">${klass.getGrade()}-(${klass.getKlass_serial()})</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right" style="margin-top: 0.1rem"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li class="tpl-left-nav-item">
                                <a href="javascript:doPost('/student/courseInfo', {'course_id':'${course.getId()}','name':'${student.getStudent_name()}','id':'${student.getId()}'})">
                                    <span>课程信息</span>
                                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                                </a>
                            </li>
                            <li class="tpl-left-nav-item">
                                <a href="javascript:doPost('/student/courseScore', {'course_id':'${course.getId()}','klass_id':'${klass.getId()}','name':'${student.getStudent_name()}','id':'${student.getId()}'})">
                                    <span>我的成绩</span>
                                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                                </a>
                            </li>
                            <li class="tpl-left-nav-item">
                                <a href="score.html">
                                    <span>我的组队</span>
                                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                </div>
            </#list>
            </#list>


            </div>
        </div>
    </div>
</div>


<script src="../../../assets_student/js/jquery.min.js"></script>
<script src="../../../assets_student/js/amazeui.min.js"></script>
<script src="../../../assets_student/js/app.js"></script>
</body>

</html>