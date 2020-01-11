
layui.use(['element', 'layer', 'form', 'table', 'tree', 'jquery'], function() {
    var element, layer, form, table, tree, $;

    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var tree = layui.tree;
    var $ = layui.$;

    $('#hideBtn').hide();

    $('#showBtn').click(function () {
        $('body').removeClass('finn-collapsed');
        $(this).hide();
        $('#hideBtn').show();
        element.render('nav', 'head');
    });

    $('#hideBtn').click(function () {
        $('body').addClass('finn-collapsed');
        $(this).hide();
        $('#showBtn').show();
        element.render('nav', 'head');
    });

    $('#showBtn').trigger('click');
});