new Vue({
    el: '#app',
    data: function () {
        return {
            collapsed: true,
            show: true,
            drawer: false,
            asideWidth: '50px',
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
                this.asideWidth = '300px';
            }

        },
    },
    components: {

    }
})