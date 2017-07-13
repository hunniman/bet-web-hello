/**
 * Created by pengweiyuan on 12/06/2017.
 */
var register = function () {
    var self = this;
    var proPath=getProPath();
    self.init = function () {
        self.validationInit();

        $("#btnRegister").bind("click", function () {
            self.doRegister();
        });
    };


    self.doRegister = function () {
        $('#registerForm').bootstrapValidator('validate');
        if (!$('#registerForm').data('bootstrapValidator').isValid())
            return;

        var data = {
            "username": getStringValue("txtUserName"),
            "password": getStringValue("txtPassword"),
            "mobile": getStringValue("txtMobile"),
            "realName": getStringValue("txtRealName")
        }

        //var data = $('#registerForm').serialize();

        AJAX_POST(proPath+"/user/register/", data, "post", function (data) {
            if (data.code == 0) {
                toastr.success('操作成功！');
            } else {
                alert(data.msg);
            }

        });


    };


    self.validationInit = function () {
        //验证开始
        $('#registerForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    validators: {
                        notEmpty: {
                            message: '请输入你的用户名'
                        },
                        stringLength: {
                            min: 1,
                            max: 50,
                            message: '长度在1~50个字符长度'
                        }
                    }
                }, password: {
                    validators: {
                        notEmpty: {
                            message: '请输入密码'
                        }, stringLength: {
                            min: 1,
                            max: 12,
                            message: '长度在1~12个字符长度'
                        }
                    }
                },

                mobile: {
                    validators: {
                        notEmpty: {
                            message: '请输入你的手机号码'
                        }, phone: {
                            country: 'CN',
                            message: '格式不对'
                        }
                    }
                },

                realName: {
                    validators: {
                        notEmpty: {
                            message: '请输入真实姓名'
                        }, stringLength: {
                            min: 1,
                            max: 5,
                            message: '长度在1~5个字符长度'
                        }
                    }
                },


            }
        });

        //验证结束


    };


}

var reg;

$(document).ready(function () {
    reg = new register();
    reg.init();
});