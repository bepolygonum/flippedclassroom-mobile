<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>账户邮箱</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
    <script>
        function mailIsAvail() {
            var x=document.getElementById("email").value
            if(x==0)
            {
                q=document.getElementById("hidemail");
                q.innerHTML="*请输入新邮箱";
            }
            else if(/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(x))
            {
                q=document.getElementById("hidemail");
                q.innerHTML="";
            }
            else
            {
                q=document.getElementById("hidemail");
                q.innerHTML="*请输入正确的邮箱格式!";
            }
        }
        
        function checkmail() {
            
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
        <h3>账户邮箱</h3>
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


<div class="tpl-page-container1 tpl-page-header-fixed">
    <div class="tpl-portlet-components1">
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form" action="/student/newmail" method="post">
                        <div class="am-form-group">
                            <input type="email" name="newmail" id="email" placeholder="填写新邮箱"  onblur="mailIsAvail()">
                            <input name="id" value="${student.getId()}" hidden="hidden"/>
                            <p class="hidden" id="hidemail" style="float: left;font-size: 1rem;color: #be2924 "></p>
                        </div>
                        <div class="am-form-group">
                            <p style="float: left;font-size: 1rem;margin-top: 5%; ">邮箱格式如： user@host.domainnames</p>
                        </div>
                        <button type="submit" class="am-btn am-btn-success" style="width: 100%;margin-top: 1%" onclick="checkmail()" >确认提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script src="../../../../assets/js/jquery.min.js"></script>
    <script src="../../../../assets/js/amazeui.min.js"></script>
    <script src="../../../../assets/js/app.js"></script>
</body>

</html>