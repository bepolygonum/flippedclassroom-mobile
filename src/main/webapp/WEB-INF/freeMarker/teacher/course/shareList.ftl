<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>讨论课</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
    <style type="text/css">
        .mybutton {
            height: 40px;
            border-radius: 5px;
            width: 100%;
            background-color: #337ab7;
            color: #ffffff;
            margin-top: 2%;
        }

        .tdstyle1 {
            word-break: keep-all;
            white-space: nowrap;
            width: 40%;
            color: #337ab7;
        }

        .tdstyle2 {
            word-break: keep-all;
            white-space: nowrap;
            width: 60%;
            text-align: center;
            font-size: 14xp;
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
         <#if seminarMainCourse?exists>
             <#if teacherList1?exists>
                 <#list teacherList1 as teacher>
                     <#if teacher.getId()==seminarMainCourse.getTeacherId()>
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <span>${seminarMainCourse.getCourseName()}(${teacher.getTeacherName()}老师)</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享类型：</td>
                                            <td class="tdstyle2">共享讨论课</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享情况：</td>
                                            <td class="tdstyle2">从课程</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <p><button type="submit" class="am-btn am-btn-default" style="float:right" onclick="addtablerow()">取消共享</button></p>
                            </li>

                        </ul>
                    </li>
                </div>

            </div>
        </div>
                     </#if>
                 </#list>
             </#if>
         </#if>

        <#if teamMainCourse?exists>
            <#if teacherList2?exists>
                <#list teacherList2 as teacher>
                    <#if teacher.getId()==teamMainCourse.getTeacherId()>
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <span>${teamMainCourse.getCourseName()}(${teacher.getTeacherName()}老师)</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享类型：</td>
                                            <td class="tdstyle2">共享分组</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享情况：</td>
                                            <td class="tdstyle2">从课程</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <p><button type="submit" class="am-btn am-btn-default" style="float:right" onclick="addtablerow()">取消共享</button></p>
                            </li>

                        </ul>
                    </li>
                </div>

            </div>
        </div>
                    </#if>
                </#list>
            </#if>
        </#if>


        <#if seminarCourseList?exists>
            <#list seminarCourseList as seminarCourse>
            <#if seminarCourse.getId()!=course.getId()>
            <#if teacherList1?exists>
            <#list teacherList1 as teacher>
            <#if teacher.getId()==seminarCourse.getTeacherId()>
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <span>${seminarCourse.getCourseName()}(${teacher.getTeacherName()}老师)</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享类型：</td>
                                            <td class="tdstyle2">共享讨论课</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享情况：</td>
                                            <td class="tdstyle2">主课程</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <p><button type="submit" class="am-btn am-btn-default" style="float:right" onclick="addtablerow()">取消共享</button></p>
                            </li>

                        </ul>
                    </li>
                </div>

            </div>
        </div>
            </#if>
            </#list>
            </#if>
            </#if>
            </#list>
        </#if>

        <#if teamCourseList?exists>
            <#list teamCourseList as teamCourse>
            <#if teamCourse.getId()!=course.getId()>
                <#if teacherList2?exists>
                    <#list teacherList2 as teacher>
                        <#if teacher.getId()==teamCourse.getTeacherId()>
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <span>${teamCourse.getCourseName()}(${teacher.getTeacherName()}老师)</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享类型：</td>
                                            <td class="tdstyle2">共享分组</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <a class="nav-link tpl-left-nav-link-list">
                                    <table>
                                        <tr>
                                            <td class="tdstyle1">共享情况：</td>
                                            <td class="tdstyle2">主课程</td>
                                        </tr>
                                    </table>
                                </a>
                            </li>
                            <li>
                                <p><button type="submit" class="am-btn am-btn-default" style="float:right" onclick="addtablerow()">取消共享</button></p>
                            </li>

                        </ul>
                    </li>
                </div>

            </div>
        </div>
                        </#if>
                    </#list>
                </#if>
            </#if>
            </#list>
        </#if>
    </div>

    <button type="submit" class="mybutton" onclick="window.location.href='newseminar.html'">新增共享</button>
</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>