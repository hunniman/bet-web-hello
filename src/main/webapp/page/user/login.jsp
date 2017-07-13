<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 07/06/2017
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>
    <jsp:include page="../common/loading.jsp"></jsp:include>
    <jsp:include page="../common/validator.jsp"></jsp:include>

    <script src="<%=request.getContextPath()%>/resources/pagejs/common.js"></script>
    <%-- <script src="<%=request.getContextPath()%>/resources/pagejs/resources.js"></script>--%>

    <script src="<%=request.getContextPath()%>/resources/pagejs/login.js"></script>


    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>
</head>
<body>

<div class="container">
    <input type="hidden" id="txtProPath" value="<%=request.getContextPath()%>">
    <form class="form-signin">
        <h2 class="form-signin-heading">登陆</h2>
        <label for="txtUserName" class="sr-only">Email address</label>
        <input type="text" id="txtUserName" class="form-control" placeholder="用户名" required="" autofocus="">
        <label for="txtPassword" class="sr-only">Password</label>
        <input type="password" id="txtPassword" class="form-control" placeholder="密码" required="">
        <%--  <div class="checkbox">
              <label>
                  <input type="checkbox" value="remember-me"> 记住密码
              </label>
          </div>--%>
        <button class="btn btn-lg btn-primary btn-block" id="btnLogin" type="button">登陆</button>
    </form>

</div>


</body>
</html>
