require.config({
    // By default load any module IDs from js/lib
    baseUrl: '/demo/resources/js/lib',
    // except, if the module ID starts with "jquery",
    // load it from the layui/lay/modules/jquery directory. paths
    // config is relative to the baseUrl, and
    // never includes a ".js" extension since
    // the paths config could be for a directory.
    paths: {
        jquery: 'jquery-3.4.1.min',
        layui: 'layui/layui',
        ace: 'ace',
        jqContextMenu: 'plugins/jquery.contextMenu.min',
        jqPosition: 'plugins/jquery.ui.position.min',
        slideout: 'plugins/slideout.min',
    },
    // Remember: only use shim config for non-AMD scripts,
    // scripts that do not already call define(). The shim
    // config will not work correctly if used on AMD scripts,
    // in particular, the exports and init config will not
    // be triggered, and the deps config will be confusing
    // for those cases.
    shim: {
        layui: {
            exports: 'layui'
        },
    },
});
