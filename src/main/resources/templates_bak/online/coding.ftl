<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Coding</title>
    <link rel="stylesheet" href="/demo/resources/component/layui/css/layui.css">
    <link rel="stylesheet" href="/demo/resources/component/layui/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="/demo/resources/component/layui/css/layui.css">
</head>
<body>

<style>
    html,body {
        height: 100%;
    }

    div.layui-fluid {
        height: 100%;
    }

    div.etl-header {
        height: 10%;
    }
    div.etl-body {
        height: 80%;
    }
    div.etl-footer {
        height: 10%;
    }

    .etl-body-left {
        height: 100%;
    }
    .etl-body-center {
        height: 100%;
    }
    .etl-body-right {
        height: 100%;
    }

    .etl-content {
        height: 100%;
    }

    .etl-editor {
        height: 100%;
        min-height: 100%;
    }
</style>

<div class="layui-fluid layui-bg-gray">
    <!-- Header -->
    <div class="layui-row etl-header layui-bg-red">
        <div class="layui-bg-blue">Header</div>
    </div>
    <!-- Body -->
    <div class="layui-row etl-body">
        <!-- Left -->
        <div class="layui-col-md2 etl-body-left layui-bg-green">
            <div class="">Left</div>
        </div>
        <!-- Center -->
        <div class="layui-col-md8 etl-body-center layui-bg-cyan">
            <div class="etl-content">
                <pre class="etl-editor" id="editor"></pre>
            </div>
        </div>
        <!-- Right -->
        <div class="layui-col-md2 etl-body-right layui-bg-green">
            <div class="">Right</div>
        </div>
    </div>
    <!-- Footer -->
    <div class="layui-row etl-footer layui-bg-red">
        <div class="">Footer</div>
    </div>
</div>


<script  data-main="/demo/resources/js/main.coding.js" src="/demo/resources/js/require.min.js"></script>

</body>
</html>