
var componentA = {
    data: function () {
        return {}
    },
    template: '<span>upload</span>'
}
var componentB = {
    data: function () {
        return {}
    },
    template: '<span>workbench</span>'
}
var componentC = {
    data: function () {
        return {}
    },
    template: '<span>setting</span>'
}

let router = new VueRouter({
    routes: [
        {
            path: '/upload',
            component: componentA
        },
        {
            path: '/workbench/agent',
            component: componentB
        },
        {
            path: '/setting/auth',
            component: componentC
        }
    ]
})

new Vue({
    el: '#app',
    router: router,
    data: function () {
        return {
            collapsed: true,
            show: true,
            drawer: false,
            asideWidth: '50px',
            routes: [
                {
                    id: 1,
                    leaf: true,
                    disabled: false,
                    icon: 'el-icon-tickets',
                    name: '待上传',
                    path: '/upload'
                },
                {
                    id: 2,
                    leaf: false,
                    disabled: false,
                    icon: 'el-icon-menu',
                    name: '工作台',
                    path: '/workbench',
                    children: [
                        {id: 21, path: '/agent', disabled: false, name: '代理商'},
                        {id: 22, path: '/parts', disabled: false, name: '零部件'}
                    ]
                },
                {
                    id: 3,
                    leaf: false,
                    disabled: false,
                    icon: 'el-icon-setting',
                    name: '设定',
                    path: '/setting',
                    children: [
                        {id: 31, path: '/auth', disabled: false, name: '权限管理'},
                        {id: 32, path: '/basic', disabled: false, name: '基础设定'}
                    ]
                },
            ],
        }
    },
    methods: {
        toggleCollapsed: function () {
            var val = !this.collapsed;
            if (val) {
                this.asideWidth = '50px';
                this.collapsed = val;
            } else {
                this.collapsed = val;
                this.asideWidth = '240px'; // 300px
            }

        },
    },
    components: {

    }
})