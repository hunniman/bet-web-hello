<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="<%=request.getContextPath()%>/resources/pagejs/register.js"></script>

<h3 class="page-header">注册用户33</h3>


<form id="registerForm" class="form-horizontal">
    <input type="hidden" id="txtProPath" value="<%=request.getContextPath()%>">
    <input type="hidden" value="" id="txtId">
    <div class="form-group">
        <label class="col-sm-2 control-label">用户账号</label>
        <div class="col-sm-3">
            <input class="form-control" type="text" class="form-control" id="txtUserName" name="username"
                   value="">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input class="form-control" type="password" id="txtPassword" name="password" value="">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">手机号码</label>
        <div class="col-sm-3">
            <input class="form-control" type="text" id="txtMobile" name="mobile" value="">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">真实姓名</label>
        <div class="col-sm-3">
            <input class="form-control" type="text" id="txtRealName" name="realName" value="">
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-1">
        </div>
        <div class="col-sm-4">
            <div style="text-align: right;">
                <button id="btnBack" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
                    <span class="ladda-label">返回</span>
                </button>
                <button id="btnRegister" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
                    <span class="ladda-label">保存</span>
                </button>
            </div>
        </div>
    </div>

</form>

</body>