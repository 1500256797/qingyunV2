/** kit_admin-v1.0.4 MIT License By http://kit/zhengjinfan.cn */
 ;/**
 * Name:app.js
 * Author:Van
 * E-mail:zheng_jinfan@126.com
 * Website:http://kit.zhengjinfan.cn/
 * LICENSE:MIT
 */
var tab;
layui.define(['nprogress', 'form', 'table', 'loader', 'tab', 'navbar'],
    function(exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        navbar = layui.navbar,
        tab = layui.tab;
    var app = {
        hello: function(str) {
            layer.alert('Hello ' + (str || 'test'));
        },
        config: {
            type: 'iframe'
        },
        set: function(options) {
            var that = this;
            $.extend(true, that.config, options);
            return that;
        },
        init: function() {
            var that = this,
                _config = that.config;
            if (_config.type === 'iframe') {
                //tab.set().render()起什么作用?
                tab.set({
                    elem: '#container',
                    onSwitch: function(data) { //选项卡切换时触发
                        console.log("打印id:"+data.layId); //lay-id值
                        console.log("tab下标"+data.index); //得到当前Tab的所在下标  下标指的是顶部的tab  关闭前一个taab后,自身下标-1.控制面版下标默认是0.
                        console.log("tab大容器"+data.elem); //得到当前的Tab大容器
                        console.log("tab的Url" + data.url);
                    },
                    closeBefore: function(data) { //关闭选项卡之前触发
                        console.log("关闭时触发")
                        console.log(data);
                        console.log(data.icon); //显示的图标
                        console.log(data.id); //lay-id
                        console.log(data.title); //显示的标题
                        console.log(data.url); //跳转的地址
                        return true; //返回true则关闭
                    }
                }).render();
                navbar.bind(function(data) {
                    tab.tabAdd(data);
                });

            }
            return that;
        }
    };

    //输出test接口
    exports('app', app);
});