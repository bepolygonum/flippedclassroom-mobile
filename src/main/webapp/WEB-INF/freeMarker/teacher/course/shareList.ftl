<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>${course.getCourseName()}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>

    <script>
        function conf() {
            confirm("确认取消与"+"\n"+"软件工程 （林老师）"+"\n"+"的分组共享？")

        }
    </script>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <form id="_form" action="/teacher/courseManage" method="post">
            <a onclick="document.getElementById('_form').submit();">
                <input value="${id}" name="id" hidden="hidden">
                <div class="am-icon-times" style="color: darkgray"></div>
            </a>
        </form>
    </div>
    <div class="am-topbar-brand">
        <h3>共享设置</h3>
    </div>
</header>

<div class="tpl-page-container1 tpl-page-header-fixed">
    <div class="tpl-portlet-components2">
        <div class="tpl-block">
        <div class="am-g">
<#if seminarMainCourse?exists>
    <#if teacherList1?exists>
        <#list teacherList1 as teacher>
            <#if teacher.getId()==seminarMainCourse.getTeacherId()>

                <div class="am-u-sm-12" >
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list" style="width: 100%;">
                            <label class="courseName">${seminarMainCourse.getCourseName()}(${teacher.getTeacherName()}老师)</label>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right" style="margin-top: 0.1rem"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li class="tpl-left-nav-item">
                                <table class="am-table am-table-striped am-table-hover table-main"  style="padding-right: 2%">
                                    <tbody>
                                    <tr>
                                        <td>共享类型:</td><td>共享讨论课</td>
                                    </tr>
                                    <tr>
                                        <td>共享情况:</td><td>从课程</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <button onclick="conf()" class="am-btn am-btn-danger am-radius" style="margin-left: 60%;margin-top: 1rem">取消共享</button>
                            </li>
                        </ul>
                    </li>
                </div>
            </#if>
        </#list>
    </#if>
</#if>

    <#if teamMainCourse?exists>
        <#if teacherList2?exists>
            <#list teacherList2 as teacher>
                <#if teacher.getId()==teamMainCourse.getTeacherId()>

                <div class="am-u-sm-12" >
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list" style="width: 100%;">
                            <label class="courseName">${teamMainCourse.getCourseName()}(${teacher.getTeacherName()}老师)</label>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right" style="margin-top: 0.1rem"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li class="tpl-left-nav-item">
                                <table class="am-table am-table-striped am-table-hover table-main"  style="padding-right: 2%">
                                    <tbody>
                                    <tr>
                                        <td>共享类型:</td><td>共享分组</td>
                                    </tr>
                                    <tr>
                                        <td>共享情况:</td><td>从课程</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <button onclick="conf()" class="am-btn am-btn-danger am-radius" style="margin-left: 60%;margin-top: 1rem">取消共享</button>
                            </li>
                        </ul>
                    </li>
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

                <div class="am-u-sm-12" >
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list" style="width: 100%;">
                            <label class="courseName">${seminarCourse.getCourseName()}(${teacher.getTeacherName()}老师)</label>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right" style="margin-top: 0.1rem"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li class="tpl-left-nav-item">
                                <table class="am-table am-table-striped am-table-hover table-main"  style="padding-right: 2%">
                                    <tbody>
                                    <tr>
                                        <td>共享类型:</td><td>共享讨论课</td>
                                    </tr>
                                    <tr>
                                        <td>共享情况:</td><td>主课程</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <button onclick="conf()" class="am-btn am-btn-danger am-radius" style="margin-left: 60%;margin-top: 1rem">取消共享</button>
                            </li>
                        </ul>
                    </li>
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

                <div class="am-u-sm-12" >
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list" style="width: 100%;">
                            <label class="courseName">${teamCourse.getCourseName()}(${teacher.getTeacherName()}老师)</label>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right" style="margin-top: 0.1rem"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li class="tpl-left-nav-item">
                                <table class="am-table am-table-striped am-table-hover table-main"  style="padding-right: 2%">
                                    <tbody>
                                    <tr>
                                        <td>共享类型:</td><td>共享分组</td>
                                    </tr>
                                    <tr>
                                        <td>共享情况:</td><td>主课程</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <button onclick="conf()" class="am-btn am-btn-danger am-radius" style="margin-left: 60%;margin-top: 1rem">取消共享</button>
                            </li>
                        </ul>
                    </li>
                </div>
                        </#if>
                    </#list>
                </#if>
            </#if>
        </#list>
    </#if>



            </div>
        </div>

    <a href="/teacher/course/createShare?id=${id}&courseId=${course.getId()}">
        <button class="am-btn am-btn-success am-radius am-button" style="margin-top: 3rem">新增共享</button>
    </a>

    </div>

</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>
