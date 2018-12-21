<!doctype html>
<html>

<<head>
    <meta charset="utf-8">
    <title>学生成绩</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../assets/css/admin.css">
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script src="../../assets/js/echarts.min.js"></script>
</head>


<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="seminar.html">
            <div class="am-icon-chevron-left" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>学生成绩</h3>
    </div>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">

        <span class="am-icon-bars"></span>
    </button>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">用户名</span>
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
                <div class="am-u-sm-12">
                <#if roundScoreList?exists>
                    <#list  roundScoreList as item>
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>第${item.getRound_id()}轮讨论课</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>

                        <ul class="tpl-left-nav-sub-menu">
                            <#if teamList?exists>
                                <#list teamList as team>
                                    <#if team.getId()==item.getTeam_id()>
                            <li class="tpl-left-nav-item">
                                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                                    <span>${team.getTeam_name()}</span><!-- 1-1 -->
                                    <span style="margin-left: 100px">${item.getTotal_score()}</span>
                                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                                </a>
                                <ul class="tpl-left-nav-sub-menu">
                                    <li>
                                        <#if seminarScoreList?exists>
                                            <#list seminarScoreList as seminarScore>
                                                <#if seminarScore.getTeam_id()==team.getId()>
                                                    <#if klassSeminarList?exists>
                                                        <#list klassSeminarList as klassSeminar>
                                                            <#if klassSeminar.getId()==seminarScore.getKlass_seminar_id()>
                                                                <#if seminarList?exists>
                                                                    <#list seminarList as seminar>
                                                                        <#if seminar.getId()==klassSeminar.getSeminar_id()>
                                                                            <#if seminar.getRound_id()==item.getRound_id()>
                                        <span class="table-title"style="margin-left: 25%">${seminar.getSeminar_name()}</span>
                                        <table class="am-table am-table-striped am-table-hover table-main">
                                            <thead>
                                            <tr>
                                                <th class="table-title">展示</th>
                                                <th class="table-title">提问</th>
                                                <th class="table-title">报告</th>
                                                <th class="table-set">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>${seminarScore.getPresentation_score()}</td>
                                                <td>${seminarScore.getQuestion_score()}</td>
                                                <td>${seminarScore.getReport_score()}</td>
                                                <td>
                                                    <div class="am-btn-toolbar">
                                                        <div class="am-btn-group am-btn-group-xs">
                                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                                    class="am-icon-pencil-square-o"></span>
                                                                修改</button>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                                                            </#if>
                                                                        </#if>

                                                                    </#list>
                                                                </#if>
                                                            </#if>
                                                        </#list>
                                                    </#if>
                                                </#if>
                                            </#list>
                                        </#if>
                                    </li>
                                </ul>
                            </li>
                                    </#if>
                                </#list>
                            </#if>
                        </ul>

                    </li>
                    </#list>
                </#if>
                </div>
            </div>

        </div>
    </div>

</div>

<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>