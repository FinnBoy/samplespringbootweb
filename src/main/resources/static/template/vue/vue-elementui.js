new Vue({
    el: '#app',
    data: function () {
        return {
            visible: false,
            menu_data: [{
                "index": "1",
                "name": "用户管理",
                "children": [{
                    "index": "1-2",
                    "name": "用户列表",
                    "children": [{
                        "index": "1-2-1",
                        "name": "用户列表查询",
                        "children": [{
                            "index": "1-2-1-1",
                            "name": "用户列表查询",
                            "children": [{
                                "index": "1-2-1-1-1",
                                "name": "用户列表查询",
                                "children": [{
                                    "index": "1-2-1-1-1-1",
                                    "name": "用户列表查询"
                                }]
                            }]
                        }]

                    }]
                }]
            }, {
                "index": "2",
                "name": "角色管理"
            }, {
                "index": "3",
                "name": "用户管理"
            }, {
                "index": "4",
                "name": "角色管理"
            }]
        }
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        }
    },
    components: {
        menutree: {
            template: '#menutree',
            props: ['data'],
            name:'menutree'
        }
    }
})