
layui.use(['element', 'layer', 'form', 'table', 'tree', 'laytpl', 'jquery'], function() {
    var element, layer, form, table, tree, laytpl, $;

    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var tree = layui.tree;
    var laytpl = layui.laytpl;
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
        element.render('nav', 'head-left-menu');
    });

    $hideBtn.click(function () {
        $layout.removeClass('finn-do-spread');
        $layout.addClass('finn-do-shrink');

        $(this).hide();
        $showBtn.show();
        element.render('nav', 'head-left-menu');

        $layout.addClass('finn-item-shrink');
    });

    $('body').on('click', '.finn-item-shrink .layui-side', function () {
        $showBtn.trigger('click');
    });

    var menuList = [
        {
            id: '1',
            icon: 'layui-icon-template',
            title: '页面',
            children: [
                {
                    id: '11',
                    title: '页面一'
                },
                {
                    id: '12',
                    title: '页面二'
                }
            ]
        },
        {
            id: '2',
            icon: 'layui-icon-set',
            title: '设定',
            children: [
                {
                    id: '21',
                    title: '系统设定'
                },
                {
                    id: '22',
                    title: '我的设定'
                }
            ]
        },
        {
            id: '3',
            icon: 'layui-icon-auz',
            title: '授权'
        }
    ];

    var $template = $('#side-menu-template')[0].innerHTML;
    laytpl($template).render({menuList: menuList}, function(html) {
        var $sample = $side.find('.layui-nav');
        var $container = $sample.parent();

        $sample.remove();
        $container.append(html);

        element.render('nav', 'side-menu');

        var $nav = $side.find('.layui-nav');
        $.each(menuList, function (i, item) {

        });
    });
});