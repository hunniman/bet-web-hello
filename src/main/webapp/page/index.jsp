<%--
  Created by IntelliJ IDEA.
  User: OPtilex
  Date: 2016/11/2
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/css.jsp"></jsp:include>
    <jsp:include page="common/js.jsp"></jsp:include>
    <jsp:include page="common/loading.jsp"></jsp:include>
    <jsp:include page="common/validator.jsp"></jsp:include>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/dashboard.css"/>

    <script src="<%=request.getContextPath()%>/resources/pagejs/common.js"></script>
    <%-- <script src="<%=request.getContextPath()%>/resources/pagejs/resources.js"></script>--%>

</head>
<body>

<input type="hidden" id="txtProPath" value="<%=request.getContextPath()%>">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <%--       <div class="navbar-header">
                   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                           aria-expanded="false" aria-controls="navbar">
                       <span class="sr-only">Toggle navigation</span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                   </button>
                   <a class="navbar-brand" href="#">Project name</a>
               </div>--%>
        <div class="row">
            <div class="col-sm-6">
                <a class="navbar-brand" href="#">赌赌赌赌赌</a>
            </div>
            <div class="col-sm-2 ">
                <div id="loadingDiv"
                     style="margin-top: 28px; background-color: #428bca;width: 80px;height:20px; text-align: center;display:none;">
                    loading.....
                </div>
            </div>
            <div class="col-sm-4">
                <div style="text-align: right;">
                    <a class="navbar-brand" href="#">你好,${sessionScope.user.realName}</a>
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/user/logout">,退出</a>
                </div>
            </div>
        </div>


    </div>
</nav>


<!-- 内容部分-->
<div class="container-fluid">
    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="common/leftmenu.jsp"></jsp:include>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div id="mainContent">
                demo 版本
            </div>
        </div>
    </div>
    '
</div>
<!-- 内容部分结束-->
</body>
</html>
