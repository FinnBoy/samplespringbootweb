<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <#assign contextPath=request.getContextPath()>
    <#assign rup=Request["org.springframework.web.servlet.resource.ResourceUrlProvider"]>
    <#assign req=Request.request>
    <title>layout 后台大布局 - Layui</title>
    <#--
    <link rel="stylesheet" href="../resources/component/layui/css/layui.css">
    <link rel="stylesheet" href="../resources/component/layui/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="../resources/css/layout-coding.css"> -->

    <link rel="stylesheet" href="${contextPath + rup.getForLookupPath('/resources/component/layui/css/layui.css')!}">
    <link rel="stylesheet" href="${contextPath + rup.getForLookupPath('/resources/component/layui/css/modules/layer/default/layer.css')!}">
    <link rel="stylesheet" href="${contextPath + rup.getForLookupPath('/resources/css/layout-coding.css')!}">
</head>
<body class="layui-layout-body">

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
                <a href="javascript:;" title="侧边伸缩">
                    <i class="layui-icon layui-icon-shrink-right"></i>
                </a>
            </li>
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
            <ul class="layui-nav layui-nav-tree" lay-shrink="all">
                <li data-name="index" data-jump="" class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;" lay-tips="编辑" lay-direction="2">
                        <i class="layui-icon layui-icon-file"></i>
                        <cite>编辑</cite>
                    </a>
                </li>
                <li data-name="senior" data-jump="" class="layui-nav-item">
                    <a href="javascript:;" lay-tips="组件" lay-direction="2">
                        <i class="layui-icon layui-icon-component"></i>
                        <cite>组件</cite>
                    </a>
                </li>
                <li data-name="user" data-jump="" class="layui-nav-item">
                    <a href="javascript:;" lay-tips="工具" lay-direction="2">
                        <i class="layui-icon layui-icon-util"></i>
                        <cite>工具</cite>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <!-- 主体内容 -->
    <div class="layui-body layui-bg-gray">
        <div style="padding: 2px;">
            <pre id="editor">
function foo(items) {
    var i;
    for (i = 0; i &lt; items.length; i++) {
        alert("Ace Rocks " + items[i]);
    }
}
            </pre>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>

<script src="${contextPath + rup.getForLookupPath('/resources/component/layui/layui.js')!}"></script>
<script src="${contextPath + rup.getForLookupPath('/resources/component/ace/src-noconflict/ace.js')!}"></script>
<script src="${contextPath + rup.getForLookupPath('/resources/component/ace/src-noconflict/ext-themelist.js')!}"></script>
<script src="${contextPath + rup.getForLookupPath('/resources/component/ace/src-noconflict/ext-language_tools.js')!}"></script>
<script src="${contextPath + rup.getForLookupPath('/resources/component/ace/src-noconflict/theme-twilight.js')!}"></script>
<script src="${contextPath + rup.getForLookupPath('/resources/component/ace/src-noconflict/mode-groovy.js')!}"></script>
<#--
<script src="../resources/component/layui/layui.js"></script>
<script src="../resources/component/ace/src-noconflict/ace.js"></script>
<script src="../resources/component/ace/src-noconflict/ext-themelist.js"></script>
<script src="../resources/component/ace/src-noconflict/ext-language_tools.js"></script>-->
<script>
/*
var dom = ace.require("ace/lib/dom");

// add command to all new editor instances
ace.require("ace/commands/default_commands").commands.push({
    name: "Toggle Fullscreen",
    bindKey: "F10",
    exec: function(editor) {
        var fs = dom.toggleCssClass(document.body, "full-screen");
        dom.setCssClass(editor.container, "full-screen", fs);
        editor.setAutoScrollEditorIntoView(!fs);
        editor.resize();
    }
});*/

ace.define('layui', function () {
    return layui;
});

ace.require(['layui'], function (layui) {

    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/twilight");
    editor.session.setMode("ace/mode/groovy");
    // editor.session.setMode("ace/mode/javascript");

    ace.config.set("enableBasicAutocompletion", true);

    // enable autocompletion and snippets
    editor.setOptions({
        enableBasicAutocompletion: true,
        enableSnippets: false,
        enableLiveAutocompletion: true
    });

    // editor.renderer.setScrollMargin(10, 10);
    editor.setOptions({
        // "scrollPastEnd": 0.8,
        autoScrollEditorIntoView: true
    });

    layui.use(['layer', 'form', 'jquery', 'element'], function (layer, form, $, element) {
        var element = layui.element;
        $('#side-menu-btn').click(function () {
            $('#side-menu').toggleClass('layui-side-collapse');
        });
        $('#save-btn').click(function () {
            var src = editor.getValue();
            if (src) {
                $.ajax({
                    url: 'save',
                    type: 'post',
                    data: {code: src},
                    success: function (response) {
                        alert('save success: ' + response);
                    }
                });
            }
        });
    });
});

</script>
</body>
</html>