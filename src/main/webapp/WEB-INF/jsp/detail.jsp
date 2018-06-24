<%--<%@page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--&lt;%&ndash;<%@include file="common/tag.jsp" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!DOCTYPE html>&ndash;%&gt;--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>预约详情页</title>--%>
    <%--<%@include file="common/head.jsp" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading text-center">--%>
            <%--<h2>课程详情</h2>--%>
        <%--</div>--%>
        <%--<div class="panel-body">--%>
            <%--<table class="table table-hover">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th>课程ID</th>--%>
                    <%--<th>课程名称</th>--%>
                    <%--<th>上课教师</th>--%>
                    <%--<th>剩余数量</th>--%>
                    <%--<th>预约数量</th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--<tr>--%>
                    <%--<td>${lesson.lessonId}</td>--%>
                    <%--<td>${lesson.name}</td>--%>
                    <%--<td>${lesson.introd}</td>--%>
                    <%--<td>${lesson.number }</td>--%>
                    <%--<td>1</td>--%>
                <%--</tr>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
        <%--<div class="panel-body text-center">--%>
            <%--<h2 class="text-danger">--%>
                <%--<!--用来展示预约控件-->--%>
                <%--<span id="appoint-box"></span> <!--class="glyphicon"在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->--%>

                <%--<span><a href="/uestc/lesson/appoint?studentId=${cookie['studentId'].value}" target="_blank">查看我的已预约课程</a></span>--%>
            <%--</h2>           <!--class="glyphicon"如何获取该页面弹出层输入的学生ID， 传给上面的url class="btn btn-primary btn-lg" -->--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
<%--<!--  登录弹出层 输入电话   -->--%>
<%--<div id="varifyModal" class="modal fade"><!--todo id-->--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<h3 class="modal-title text-center">--%>
                    <%--<span ></span>请输入学号和密码:<!--class="glyphicon glyphicon-studentId"-->--%>
                <%--</h3>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<div class="row">--%>
                    <%--<div class="col-xs-8 col-xs-offset-2">--%>
                        <%--<input type="text" name="studentId" id="studentIdKey"--%>
                               <%--placeholder="填写学号^o^" class="form-control">--%>
                    <%--</div>--%>
                    <%--<div class="col-xs-8 col-xs-offset-2">--%>
                        <%--<input type="password" name="password" id="passwordKey"--%>
                               <%--placeholder="输入密码^o^" class="form-control">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer">--%>
                <%--<!--  验证信息 -->--%>
                <%--<span id="studentMessage" class="glyphicon"> </span>--%>
                <%--<button type="button" id="studentBtn" class="btn btn-success">--%>
                    <%--<span ></span><!--将glyphicon-student改为glyphicon-studentId class="glyphicon glyphicon-student"-->--%>
                    <%--Submit--%>
                <%--</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--</body>--%>
<%--&lt;%&ndash;jQery文件,务必在bootstrap.min.js之前引入&ndash;%&gt;--%>
<%--<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>--%>
<%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--&lt;%&ndash;使用CDN 获取公共js http://www.bootcdn.cn/&ndash;%&gt;--%>
<%--&lt;%&ndash;jQuery Cookie操作插件&ndash;%&gt;--%>
<%--<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>--%>
<%--&lt;%&ndash;jQuery countDown倒计时插件&ndash;%&gt;--%>
<%--<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>--%>

<%--<script src="/resources/script/lessonappointment.js" type="text/javascript"></script>--%>

<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--//使用EL表达式传入参数--%>
        <%--lessonappointment.detail.init({--%>
            <%--lessonId:${lesson.lessonId}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--</html>--%>




<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>预约详情页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h2>课程详情</h2>
        </div>

        <div class="panel-body text-center">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>课程ID</th>
                    <th>课程名称</th>
                    <th>授课信息</th>
                    <th>剩余数量</th>
                    <th>预约数量</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${lesson.lessonId}</td>
                    <td>${lesson.name}</td>
                    <td>${lesson.introd}</td>
                    <td>${lesson.number }</td>
                    <td>1</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!--用来展示预约控件-->
                <span class="glyphicon" id="appoint-box"></span> <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->

                <span class="glyphicon"><a class="btn btn-primary btn-lg" href="/uestc/lesson/appoint?studentId=${cookie['studentId'].value}" target="_blank">查看我的已预约课程</a></span>
            </h2>           <!--如何获取该页面弹出层输入的学生ID， 传给上面的url-->
        </div>

    </div>
</div>
<!-- 登录弹出层，输入电话，模态框（Modal） -->
<div class="modal fade" id="varifyModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-pencil"></span> 请输入学号和密码：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="studentId" id="studentIdKey"
                               placeholder="填写学号O(∩_∩)O~" class="form-control"/>
                    </div>
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="password" name="password" id="passwordKey"
                               placeholder="输入密码^o^" class="form-control">
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <span id="studentMessage" class="glyphicon"></span>
                <button type="button" id="studentBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-hand-up"></span>
                    Submit
                </button>
            </div>
        </div><!-- /.modal-content -->

    </div><!-- /.modal -->
</div>
</body>
<!-- jQuery文件，务必在bootstrap.min.js 之前引入 -->
<%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- 倒计时插件-->
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>

<script src="/resources/script/lessonappointment.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
        lessonappointment.detail.init({
            lessonId:${lesson.lessonId}
        });
    });
</script>
</html>








