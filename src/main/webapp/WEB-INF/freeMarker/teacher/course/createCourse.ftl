<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>新建课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../../../assets/i/favicon.png">
    <link rel="stylesheet" href="../../../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../../../assets/css/admin.css">
    <link rel="stylesheet" href="../../../../assets/css/app.css">
    <script src="../../../../assets/js/echarts.min.js"></script>
    <style type="text/css">
        .inputext {
            height: 30px;
            border-radius: 5px;
            margin-left: 5%;
            margin-bottom: 3%;
            outline: none;
            border-top-style: groove;
            border-right-style: groove;
            border-bottom-style: groove;
            border-left-style: groove;
            border: 1px solid #a1a1a1;
        }

        .divtext {
            outline: none;
            border: none;
            width: 100%;
        }

        .tdstyle {
            word-break: keep-all;
            white-space: nowrap;
        }

        .mybutton {
            height: 40px;
            border-radius: 5px;
            width: 100%;
            background-color: #337ab7;
            color: #ffffff;
        }
    </style>
    <script type="text/javascript">
        function addtablerow() {
            var Table = document.getElementById("tab"); //取得自定义的表对象
            NewRow = Table.insertRow(); //添加行
            NewCell = NewRow.insertCell(); //添加列
            NewCell.innerHTML = "<select name='conflict' id=''><option value='1'>.Net(**老师)</option> </select>";
        }
    </script>
</head>

<body data-type="index">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand1">
        <a href="courseinformation.html">
            <div class="am-icon-times" style="color: darkgray"></div>
        </a>
    </div>
    <div class="am-topbar-brand">
        <h3>新建课程</h3>
    </div>
</header>

<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-portlet-components">
        <form action="/teacher/course/createCourse" method="post" onsubmit="return test();">
        <hr>
            <input value="${id}" name="id" hidden="hidden">
        <div><input type="text" placeholder="课程名称" id="courseName" name="courseName"></div>
        <hr>
        <div>
            <textarea rows="5" cols="30" class="divtext" placeholder="课程要求" id="courseRequest" name="courseRequest"></textarea>
        </div>
        <hr>
        <div>
            成绩计算规则:
            <table>
                <tr>
                    <td>课堂展示</td>
                    <td><input type="text" width="40%" class="inputext" id="presentation" name="presentation"></td>
                </tr>
                <tr>
                    <td>课堂提问</td>
                    <td><input type="text" width="40%" class="inputext" id="question" name="question"></td>
                </tr>
                <tr>
                    <td>书面报告</td>
                    <td><input type="text" width="40%" class="inputext" id="report" name="report"></td>
                </tr>
            </table>
        </div>
        <hr>
        <div>
            <table>
                <tr>
                    <td class="tdstyle">小组人数</td>
                    <td>
                        <table style="margin-left: 3%">
                            <tr>
                                <td class="tdstyle">上限</td>
                                <td><input type="text" class="inputext" style="width: 70%" id="max" name="max"></td>
                            </tr>
                            <tr>
                                <td class="tdstyle">下限</td>
                                <td><input type="text" class="inputext" style="width: 70%" id="min" name="min"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="tdstyle">组队开始时间</td>
                    <td>
                        <table>
                            <tr><input type="date" id="startDate" name="startDate"></tr>
                            <tr><input type="time" id="startTime" name="startTime"></tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="tdstyle">组队结束时间</td>
                    <td>
                        <table>
                            <tr><input type="date" id="endDate" name="endDate"></tr>
                            <tr><input type="time" id="endTime" name="endTime"></tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <hr>
        <div>
            <table>
                <tr>
                    <td class="tdstyle">冲突课程</td>
                    <td>
                        <table id="tab">
                            <tr>
                                <td>
                                    <select name="conflict" id="">
                                        <option value="1">.Net(**老师)</option>
                                        <option value="2">.Net()</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <p><button type="submit" class="am-btn am-btn-default" style="float:right" onclick="addtablerow()">新增对象</button></p>
        </div>
        <button type="submit" class="mybutton">发布</button>
        </form>
    <script>
        function test() {
            var courseName = document.getElementById('courseName');
            var courseRequest = document.getElementById('courseRequest');
            var question = document.getElementById('question');
            var report = document.getElementById('report');
            var max = document.getElementById('max');
            var min = document.getElementById('min');
            var startDate = document.getElementById('startDate');
            var startTime = document.getElementById('startTime');
            var endDate = document.getElementById('endDate');
            var endTime = document.getElementById('endTime');
            ///?？新增对象
            if (courseName.value == ''|courseRequest.value == ''|question.value == ''|report.value == ''|max.value==''|min.value==''
            |startDate.value==''|startTime.value==''|endDate.value==''|endTime.value=='')
            {
                alert("These items cannot be empty!");
                return false;
            }
            return true;
        }
    </script>
    </div>

</div>

<script src="../../../../assets/js/jquery.min.js"></script>
<script src="../../../../assets/js/amazeui.min.js"></script>
<script src="../../../../assets/js/app.js"></script>
</body>

</html>