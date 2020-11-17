let vm = new Vue({
    el: "#app",
    data: {
        user: {
            username: "",
            password: ""
        }
    },
    methods: {
        login: function () {
            console.log(this.user)
            axios({
                url: "user/login",
                method: "get",
                params: {user: this.user}
            }).then(response => {
                if (response.data.flag) {
                    location.href = "html/home.html"
                } else {
                    layer.msg(response.data.message, {icon: 1})
                }
            }).catch(error => {
                layer.msg(error.message)
            })
        }

    }
})