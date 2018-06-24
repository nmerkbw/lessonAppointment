<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>课程列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>课程列表</h2>
        </div>
        <form name="firstForm" action="<%= request.getContextPath()%>/uestc/lesson/search" method="post">
            <div class="panel-heading ">
                <table class="table table-bookName">
                    <thead>
                    <tr>
                        <th width="90" align="lift">课程名称：</th>
                        <th width="150" align="lift">
                            <input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索课程^o^" />
                        </th>
                        <th>
                            <input type="submit" id="tabSub" value="检索" />
                        </th>
                    </tr>
                    </thead>
                </table>
            </div>
        </form>


        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>课程ID</th>
                    <th>课程名称</th>
                    <th>可选人数</th>
                    <th>课程信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.lessonId}</td>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td><a class="btn btn-info" href="/uestc/lesson/${sk.lessonId}/detail " target="_blank">详细</a></td>
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