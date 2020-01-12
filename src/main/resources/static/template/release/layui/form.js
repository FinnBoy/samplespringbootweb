layui.define(['element', 'layer', 'form', 'jquery'], function (exports) {
    //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    var element, layer, form, $, xform;

    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.$;

    form.render();

    var obj = {
        exec: function () {
            // form.render();
        }
    };

  //输出test接口
  exports('formPage', obj);
});