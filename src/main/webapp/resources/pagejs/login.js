/**
 * Created by pengweiyuan on 12/06/2017.
 */
var login = function () {
    var self = this;
    var proPath=getProPath();
    self.init = function () {
        $("#btnLogin").bind("click", function () {
            self.doLogin();
        });
    };


    self.doLogin = function () {
        if (!self.validationInit())return;
        var data = {
            "username": getStringValue("txtUserName"),
            "password": getStringValue("txtPassword")
        }

        //var data = $('#registerForm').serialize();

        AJAX_POST(proPath+"/user/login/", data, "post", function (data) {
            if (data.code == 0) {
                toastr.success('登陆成功！');
                window.location.href = proPath+"/equipment/index";
            } else {
                alert(data.msg);
            }

        });


    };


    self.validationInit = function () {
        //验证开始
        if (getStringValue("txtUserName").length <= 0) {
            alert("请输入账号");
            return false;
        }
        if (getStringValue("txtPassword").length <= 0) {
            alert("请输入密码");
            return false;
        }
        return true;

    };


}

var log;

$(document).ready(function () {
    log = new login();
    log.init();
});