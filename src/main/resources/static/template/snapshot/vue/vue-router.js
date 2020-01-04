
var UploadView = {
    data: function () {
        return {}
    },
    template: '#upload-view'
}

var WorkbenchView = {
    data: function () {
        return {}
    },
    template: '#workbench-view'
}
var WorkbenchHomeView = {
    data: function () {
        return {}
    },
    template: '#workbench-home-view'
}
var AgentView = {
    data: function () {
        return {}
    },
    template: '<div>Agent</div>'
}
var PartsView = {
    data: function () {
        return {}
    },
    template: '<div>Parts</div>'
}

var componentC = {
    data: function () {
        return {}
    },
    template: '<div>setting</div>'
}

let router = new VueRouter({
    routes: [
        {
            path: '/upload',
            component: UploadView
        },
        { // 嵌套路由：组件配置
            path: '/workbench',
            component: WorkbenchView,
            children: [
                {
                    path: '',
                    component: WorkbenchHomeView
                },
                {
                    path: 'agent',
                    component: AgentView
                },
                {
                    path: 'parts',
                    component: PartsView
                }
            ]
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