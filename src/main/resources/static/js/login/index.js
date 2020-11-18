let vm = new Vue({
    el: "#app",
    data: {
        user: {
            username: "",
            password: ""
        },
        code: "",
        render: "index/render"
    },
    methods: {
        login: function () {
            console.log(this.user)
            axios({
                url: "index/login",
                method: "get",
                params: {
                    username: this.user.username, password: this.user.password, code: this.code
                }
            }).then(response => {
                if (response.data.flag) {
                    location.href = "html/home.html"
                } else {
                    this.refresh()
                    layer.msg(response.data.message, {icon: 1})
                }
            }).catch(error => {
                layer.msg(error.message)
            })
        },
        refresh: function () {
            this.render = "index/render?" + new Date()
        }

    }
})