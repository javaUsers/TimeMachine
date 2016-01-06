/**
 *把今天最好的表现当作明天最新的起点..
 *いま最高の表现として明日最新の始発..
 * @author：小莫(83387856)
 * @github：https://github.com/qq83387856
 * @Email：hupengbest@163.com
 * @date: 2015/11/24 10:20
 * @描述：${TODO}
 **/
$(function () {
    $("#btnClick").bind("click", function () {
        $.ajax({
            url: "http://www.hpbest.com/qq/callbackLogin",
            //data: { num: $("#txtNumber").val() },
            type: "post",
            dateType: "json",
            success: function (data) {
                $("#myInfo").append("<img src='data.btnClick'>")
            }
        });
    })
});