
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

// 嵌套命名视图：组件配置
var SettingView = {
    data: function () {
        return {}
    },
    template: `
        <div>
            <h2>Setting</h2>
            <hr>
            <router-view name="auth"></router-view>
            <router-view name="basic"></router-view>
        </div>
    `
}
var AuthView = {
    data: function () {
        return {}
    },
    template: '<div>Auth</div>'
}
var BasicView = {
    data: function () {
        return {}
    },
    template: '<div>Basic</div>'
}

/**************************************************************
 * 路由配置
 **************************************************************/
var routes = [
    {
        path: '/upload',
        component: UploadView,
        meta: {
            id: 1,
            leaf: true,
            disabled: false,
            icon: 'el-icon-tickets',
            name: '待上传',
        },
    },
    { // 嵌套路由：组件配置
        path: '/workbench',
        component: WorkbenchView,
        meta: {
            id: 2,
            leaf: false,
            disabled: false,
            icon: 'el-icon-menu',
            name: '工作台',
        },
        children: [
            {
                path: '',
                component: WorkbenchHomeView,
            },
            {
                path: 'agent',
                component: AgentView,
                meta: {
                    id: 21,
                    disabled: false,
                    name: '代理商',
                }
            },
            {
                path: 'parts',
                component: PartsView,
                meta: {
                    id: 22,
                    disabled: false,
                    name: '零部件',
                }
            }
        ]
    },
    { // 嵌套命名视图：组件配置
        path: '/setting',
        component: SettingView,
        meta: {
            id: 3,
            leaf: false,
            disabled: false,
            icon: 'el-icon-setting',
            name: '设定',
        },
        children: [
            {
                path: 'total',
                components: {
                    auth: AuthView,
                    basic: BasicView
                },
                meta: {
                    id: 31,
                    disabled: false,
                    name: '基础与权限管理',
                }
            },
        ]
    }
];

let router = new VueRouter({
    routes: routes
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
            routes: routes,
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