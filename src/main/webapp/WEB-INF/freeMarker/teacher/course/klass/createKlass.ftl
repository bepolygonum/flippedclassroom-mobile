<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>新建讨论课</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../../assets/css/app.css">
    <script src="../../../../../assets/js/echarts.min.js"></script>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <form id="_form" action="/teacher/course/seminar" method="get">
            <a onclick="document.getElementById('_form').submit();">
                <input value="${id}" name="id" hidden="hidden">
                <input value="${courseId}" name="courseId" hidden="hidden">
                <div class="am-icon-times" style="color: darkgray"></div>
            </a>
        </form>
    </div>
    <div class="am-topbar-brand">
        <h3>新建班级</h3>
    </div>
</header>
<form action="/teacher/course/seminar/createKlass" method="post" onsubmit="return test();">
    <div class="tpl-page-container1 tpl-page-header-fixed">
        <div class="tpl-portlet-components2">
            <div>
                <input value="${id}" name="id" hidden="hidden">
                <input value="${courseId}" name="courseId" hidden="hidden">
                <p style="margin-left: 6%" class="Top">班级名</p>
                <hr>
                <div class="top">
                    <p style="width: 30%;float: left;margin-left: 6%">年级:</p>
                    <input style="width: 30%;margin-left: 10%;" class="border" type="number" name="grade" id="grade"/>
                </div>
                <div class="top">
                    <p style="width: 30%;float: left;margin-left: 6%">班级:</p>
                    <input style="width: 30%;margin-left: 10%;" class="border" type="number" name="klass" id="klass"/>
                </div>
            </div>
            <hr>
            <div class="Top">
                <p style="margin-left: 6%;width: 30%;float: left">上课时间</p>
                <input style="width: 20%;margin-left: 0%;float: left" class="border" type="number" name="firstCourse"
                       id="firstCourse"/>
                <input style="width: 24%;margin-left: 10%;" class="border" type="number" name="secondCourse"
                       id="secondCourse"/>
            </div>
            <hr>

            <div class="Top">
                <p style="margin-left: 6%;width: 30%;float: left">上课地点</p>
                <input style="width: 60%;margin-left: 0%" class="border" type="text" name="location" id="location"/>
            </div>
            <hr>
            <div class="Top">
                <p style="margin-left: 6%;width: 35%;">班级学生名单:</p>
                <input class="am-btn" type="file" name="file" id="file"/>
            </div>
            <button type="submit" class="am-btn am-btn-success"
                    style="width: 80%;margin-left: 10%;margin-top: 3rem;margin-bottom: 3rem">保存
            </button>
        </div>

    </div>

</form>
<script>
    function test() {
        var grade = document.getElementById('grade');
        var klass = document.getElementById('c=klass');
        var firstCourse = document.getElementById('firstCourse');
        var secondCourse = document.getElementById('secondCourse');
        var location = document.getElementById('location');
        if (grade.value == '' | klass.value == '' | firstCourse.value == '' | secondCourse.value == '' | location.value == '') {
            alert("These items cannot be empty!");
            return false;
        }
        return true;
    }
</script>
<script src="../../../../../assets/js/jquery.min.js"></script>
<script src="../../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../../assets/js/app.js"></script>
</body>

</html>