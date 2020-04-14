/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */
;layui.define(["table", "form", "element"], function (e) {
    var t = layui.$, i = layui.table, r = (layui.form, layui.element);
    i.render({
        elem: "#LAY-app-system-order",
        url: "/layuiadmin/log/getLogs",
        dataType:'json',
        contentType:"appliction/json;charset=utf-8",
        cols: [[{type: "numbers", fixed: "left"}, {
            field: "ip",
            width: 200,
            title: "访问IP"
        }, {field: "url", width: 600, title: "请求资源"},
            {title: "操作", align: "right", fixed: "right", toolbar: "#table-system-order"}]],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！",
        parseData: function (res) {
            return {
                "code": res.status, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": res.data //解析数据列表
            };
        },
        done: function () {
            r.render("progress")
        }
    }), i.on("tool(LAY-app-system-order)", function (e) {
        e.data;
        if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑工单",
                content: "../../../views/app/workorder/listform.html",
                area: ["450px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var r = window["layui-layer-iframe" + e], l = "LAY-app-workorder-submit",
                        o = t.find("iframe").contents().find("#" + l);
                    r.layui.form.on("submit(" + l + ")", function (t) {
                        t.field;
                        i.reload("LAY-user-front-submit"), layer.close(e)
                    }), o.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }), e("workorder", {})
});