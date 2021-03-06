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
        height: 12%;
    }
    div.etl-body {
        height: 82%;
    }
    div.etl-footer {
        height: 6%;
    }

    .etl-header-menu {
        height: 60%;
        margin: 0 0 8px 0;
    }
    .etl-header-command {
        height: 35%;
        margin: 8px 0 0 0;
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

    .etl-left-side {
        height: 96%;
        margin: 8px 0;
        border-right: 1px solid #e2e2e2;
    }
    .etl-right-side {
        height: 96%;
        margin: 8px 0;
        border-left: 1px solid #e2e2e2;
    }
    .etl-content {
        height: 96%;
        margin: 8px 15px;
        border: 1px solid #e2e2e2;
    }

    .etl-editor {
        height: 100%;
        min-height: 100%;
    }

    .etl-bg-white {
        background-color: white !important;
        color: #626262;
    }
</style>

<div class="layui-fluid">
    <!-- Header -->
    <div class="layui-row etl-header">
        <div class="etl-header-menu layui-bg-gray">Header</div>
        <div class="etl-header-command layui-bg-gray">Header</div>
    </div>
    <!-- Body -->
    <div class="layui-row etl-body">
        <!-- Left -->
        <div class="layui-col-md2 etl-body-left etl-bg-white">
            <div class="etl-left-side etl-bg-white">Left</div>
        </div>
        <!-- Center -->
        <div class="layui-col-md8 etl-body-center etl-bg-white">
            <div class="etl-content etl-bg-white">
                <pre class="etl-editor" id="editor"></pre>
            </div>
        </div>
        <!-- Right -->
        <div class="layui-col-md2 etl-body-right etl-bg-white">
            <div class="etl-right-side etl-bg-white">Right</div>
        </div>
    </div>
    <!-- Footer -->
    <div class="layui-row etl-footer layui-bg-gray">
        <div class="">Footer</div>
    </div>
</div>


<script  data-main="/demo/resources/js/main.coding.js" src="/demo/resources/js/require.min.js"></script>

</body>
</html>