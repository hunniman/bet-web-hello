/**分页帮助类
 * Created by pengweiyuan on 2016/11/4.
 */
var defaultLength = 10;//默认分页阑珊

var paging = function () {
    var _self = this;
    _self.total;
    _self.totalPage;
    _self.callback;
    _self.init = function (total, callback,init) {
        if (total < defaultLength){
            $(".pagination").empty();
            return;
        }
        _self.total = total;
        _self.totalPage = parseInt(total / defaultLength)+1;
        var initPageLength=defaultLength;
        if(_self.totalPage<initPageLength){
            initPageLength=_self.totalPage;
        }
        if(init===true) {
            _self.generateHtml(1, initPageLength, 1);
            _self.callback = callback;
        }
    }

    _self.generateHtml = function (start, end, current) {
        var content = "<li id='pre_page' class=\"disabled\"><a href=\"javascript:void(0);\"> &laquo;</a></li>";
        for (var i = start; i <= end; i++) {
            if (i == current) {
                content += "<li class='active'><a href=\"javascript:void(0);\" class='active' >" + i + "</a></li>";
            } else
                content += "<li><a href=\"javascript:void(0);\" >" + i + "</a></li>";
        }
        content += "<li id='next_page'><a href=\"javascript:void(0);\">&raquo;</a></li>";
        $(".pagination").empty();
        $(content).appendTo($(".pagination"));

        $(".pagination a").bind("click", function () {
            var number = parseInt($(this).text());
            if (isNaN(number)) {
                return;
            }
            _self.nextPage(number);
        });
        $("#pre_page").bind("click", function () {
            var initPageLength=defaultLength;
            if(_self.totalPage<initPageLength){
                initPageLength=_self.totalPage;
            }
            _self.generateHtml(1, initPageLength, 1);
            $("#pre_page").attr("class", "disabled");
            $("#next_page").removeAttr("class");
            _self.callback(1,defaultLength,false);
        });
        $("#next_page").bind("click", function () {
            var initPageLength=_self.totalPage-defaultLength+1;
            _self.generateHtml(initPageLength, _self.totalPage, _self.totalPage);
            $("#next_page").attr("class", "disabled");
            $("#pre_page").removeAttr("class");
            _self.callback( _self.totalPage,defaultLength,false);
        });
    }

    _self.nextPage = function (pageIndex) {
        //if(pageIndex<=defaultLength/2)return;
        var disableFlag = -1;
        var start = 0, end = 0;
        if (pageIndex <= defaultLength / 2 + 1) {
            start = 1;
            end = defaultLength;
        } else {
            if (_self.totalPage - pageIndex >= defaultLength / 2 - 1) {
                end = pageIndex + defaultLength / 2 - 1;
                start = pageIndex - defaultLength / 2;
                disableFlag = 0;
            } else {
                var temp = _self.totalPage - pageIndex;
                start = pageIndex - defaultLength / 2 + 1 - (defaultLength / 2 - temp);
                end = _self.totalPage;
                disableFlag = 1;
            }
        }
        _self.generateHtml(start, end, pageIndex);
        if (disableFlag == 0) {
            $("#pre_page").removeAttr("class");
            $("#next_page").removeAttr("class");
        } else if (disableFlag == -1) {
            $("#pre_page").attr("class", "disabled");
            $("#next_page").removeAttr("class");
        } else if (disableFlag == 1) {
            $("#next_page").attr("class", "disabled");
            $("#pre_page").removeAttr("class");
        }
        _self.callback(pageIndex,defaultLength,false);
    }

}
