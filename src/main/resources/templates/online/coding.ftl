<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Coding</title>
    <#assign contextPath=request.getContextPath()>
    <#assign rup=Request["org.springframework.web.servlet.resource.ResourceUrlProvider"]>
    <#import "/macros/macros.ftl" as m>

    <@m.link "/resources/component/layui/css/layui.css" contextPath rup/>
    <@m.link "/resources/component/layui/css/modules/layer/default/layer.css" contextPath rup/>
    <#--
    <@m.link "/resources/css/layout-coding.css" contextPath rup/> -->
</head>
<body>

<div class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <a href="javascript:;" title="侧边伸缩" id="side-menu-btn">
                <i class="layui-icon layui-icon-shrink-right"></i>
            </a>
            <span>Logo</span>
        </div>
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item" lay-unselect="">
                <a href="javascript:;" title="上传" id="save-btn">
                    <i class="layui-icon layui-icon-upload-circle"></i>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect="">
                <a href="javascript:;" title="刷新">
                    <i class="layui-icon layui-icon-refresh-3"></i>
                </a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-notice"></i>
                    <span class="layui-badge-dot"></span>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-note"></i>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-screen-full"></i>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <cite>Finn</cite>
                    <span class="layui-nav-more"></span>
                </a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit">
                    <dd><a href="javascript:;">基本资料</a></dd>
                    <dd><a href="javascript:;">修改密码</a></dd>
                    <hr>
                    <dd style="text-align: center;"><a>退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <!-- 侧边菜单 -->
    <div class="layui-side layui-side-menu" id="side-menu">
        <div class="layui-side-scroll">



        </div>
    </div>

    <!-- 主体内容 -->
    <div class="layui-body layui-bg-gray">
        <div style="padding: 2px;">
            <pre id="editor">function foo(items) {
    var i;
    for (i = 0; i &lt; items.length; i++) {
        alert("Ace Rocks " + items[i]);
    }
}</pre>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>

</div>

<script  data-main="/demo/resources/js/main.coding.js" src="/demo/resources/js/require.min.js"></script>

</body>
</html>