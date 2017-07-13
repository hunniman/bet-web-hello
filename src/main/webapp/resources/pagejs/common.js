/**
 * Created by OPtilex on 2016/11/25.
 */
var menu = function () {
    var _self = this;

    _self.initEvent = function () {
        $(".nav-sidebar li").bind("click", function () {
            var url = $(this).attr("url");
            $(".nav-sidebar li").removeAttr("class");
            $(this).attr("class", "active");
            $("#loadingDiv").show();
            $("#mainContent").load(url, function () {
                $("#loadingDiv").fadeOut();
            });
        });
    }
    _self.loadPage = function (url, data) {
        $("#loadingDiv").show();
        $("#mainContent").load(url, data, function () {
            $("#loadingDiv").fadeOut();
        });
    }


}
var mu;

$(document).ready(function () {
    mu = new menu();
    mu.initEvent();
});


function AJAX(url, data, methodType, callback) {
    $.ajax({
        type: methodType,
        dataType: "json",
        url: url,
        contentType: "application/json",
        data: data,
        beforeSend: function () {
            if (methodType === "get" || methodType === "GET") {
                $("#loadingDiv").show();
            }
        },
        success: function (data) {
            $("#loadingDiv").fadeOut();
            callback(data);
            /*if(data.code===0){
             callback(data);
             }else{
             toastr.error('操作失败');
             }*/
        },
        error: function (err) {
            $("#loadingDiv").fadeOut();
            toastr.error('操作失败');
        }
    }).done(function () {
        $("#loadingDiv").fadeOut();
    });
}


function AJAX_POST(url, data, methodType, callback) {
    $.ajax({
        type: methodType,
        dataType: "json",
        url: url,
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(data),
        beforeSend: function () {
            $("#loadingDiv").show();
        },
        success: function (data) {
            $("#loadingDiv").fadeOut();
            callback(data);
            /*if(data.code===0){
             callback(data);
             }else{
             toastr.error('操作失败');
             }*/
        },
        error: function (err) {
            $("#loadingDiv").fadeOut();
            toastr.error('操作失败');
        }
    }).done(function () {
        $("#loadingDiv").fadeOut();
    });
}


function getStringValue(key) {
    return $("#" + key).val().trim();
}

function getProPath() {
    return $("#txtProPath").val();
}