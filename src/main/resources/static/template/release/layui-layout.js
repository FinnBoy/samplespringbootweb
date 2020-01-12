
layui.use(['element', 'layer', 'form', 'table', 'tree', 'laytpl', 'jquery'], function() {
    var element, layer, form, table, tree, laytpl, $;

    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var tree = layui.tree;
    var laytpl = layui.laytpl;
    var $ = layui.$;

    jQuery.extend({
      pages: {}
    });

    var $hideBtn = $('#hideBtn');
    var $showBtn = $('#showBtn');
    var $side = $('.layui-side');
    var $body = $('.layui-body');
    var $layout = $('.layui-layout');
    var $content = $('.finn-body-content');

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
                    title: '表单样例',
                    path: 'layui/form'
                },
                {
                    id: '12',
                    title: '页面二',
                    path: ''
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
                    title: '系统设定',
                    path: ''
                },
                {
                    id: '22',
                    title: '我的设定',
                    path: ''
                }
            ]
        },
        {
            id: '3',
            icon: 'layui-icon-auz',
            title: '授权',
            path: ''
        }
    ];

    var renderBreadcrumb = function () {
        var args = arguments;
        if (!args) {
            return;
        }
        if (0 === args.length) {
            return;
        }
        var length = args.length;
        var pathsLength = length - 1;
        var paths = [];
        for (var i = 0; i < pathsLength; i++) {
            paths.push(args[i]);
        }
        var data = {
            paths: paths,
            current: args[length - 1]
        }
        var $template = $('#breadcrumb-template')[0].innerHTML;
        laytpl($template).render(data, function(html) {
            var $c = $content.children('.layui-card').find('.layui-card-header');
            $c.empty();
            $c.append(html);
            element.render('breadcrumb');
        });
    }

    var $template = $('#side-menu-template')[0].innerHTML;
    laytpl($template).render({menuList: menuList}, function(html) {
        var $sample = $side.find('.layui-nav');
        var $container = $sample.parent();

        $sample.remove();
        $container.append(html);

        element.render('nav', 'side-menu');

        var $nav = $side.find('.layui-nav');
        $nav.on('click', 'a', function () {
            var containsSubMenu = $(this).parent().find('dl').length > 0;
            var isMenu = $(this).parent().find('li');
            if (containsSubMenu) {
                return;
            }

            var path = $(this).data('href');
            if (path) {
                var $page = $content.find('.finn-page');
                $page.load(path+'.html', function () {
                    // $.getScript(path+'.js');
                    // $page.find('.finn-import-script').load();
                    // form.render();
                });
            }

            var datas = [];

            if (!isMenu) {
                var $li = $(this).parents('li');
                if (1 === $li.length) {
                    var $a = $li.children('a');
                    datas.push({
                        title: $a.find('cite').text()
                    });
                }
            }

            var $dd = $(this).parent().parents('dd');
            $dd.each(function () {
                var $a = $(this).children('a');
                datas.push({
                    title: $a.find('cite').text()
                });
            });

            datas.push({
                title: $(this).find('cite').text()
            });

            renderBreadcrumb.apply(this, datas);
        });
    });
});