<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>预约课程列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>您已预约课程列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>预定学号</th>
                    <th>预约时间</th>
                    <th>课程ID</th>
                    <th>课程名称</th>
                    <th>上课教师信息</th>
                    <th>预约数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${appointList}" var="al">
                    <tr>
                        <td>${al.studentId}</td>
                        <td>${al.appointTime}</td>
                        <td>${al.lessonId}</td>
                        <td>${al.lesson.getName()}</td>
                        <td>${al.lesson.getIntrod()}</td>
                        <td>1</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>