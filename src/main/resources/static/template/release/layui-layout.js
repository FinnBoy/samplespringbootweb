
layui.use(['element', 'layer', 'form', 'table', 'tree', 'jquery'], function() {
    var element, layer, form, table, tree, $;

    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var tree = layui.tree;
    var $ = layui.$;

    var $hideBtn = $('#hideBtn');
    var $showBtn = $('#showBtn');
    var $side = $('.layui-side');
    var $body = $('.layui-body');
    var $layout = $('.layui-layout');

    $hideBtn.hide();

    $showBtn.click(function () {
        $layout.removeClass('finn-menu-shrink');
        $layout.removeClass('finn-item-shrink');

        $layout.addClass('finn-do-spread');
        $layout.removeClass('finn-do-shrink');

        $(this).hide();
        $hideBtn.show();
        element.render('nav', 'head');
    });

    $hideBtn.click(function () {
        $layout.removeClass('finn-do-spread');
        $layout.addClass('finn-do-shrink');

        $(this).hide();
        $showBtn.show();
        element.render('nav', 'head');

        $layout.addClass('finn-item-shrink');
    });

    $('body').on('click', '.finn-item-shrink .layui-side', function () {
        $showBtn.trigger('click');
    });

});