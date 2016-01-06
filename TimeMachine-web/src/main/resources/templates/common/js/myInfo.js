/**
 *把今天最好的表现当作明天最新的起点..
 *いま最高の表现として明日最新の始発..
 * @author：小莫(83387856)
 * @github：https://github.com/qq83387856
 * @Email：hupengbest@163.com
 * @date: 2015/11/24 10:20
 * @描述：${TODO}
 **/
$(document).ready(
    $(function () {
        $("#btnClick").bind("click", function () {
            $.ajax({
                url: "/qq/toLogin",
                type: "get",
                dateType: "jsonp",
                jsonp: "callback",
                success: function (data) {
                    alert(data);
                },
                error: function (jqXHP) {
                    console.log(jqXHP.status);
                }
            });
        })
    })
);