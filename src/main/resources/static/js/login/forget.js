let vm = new Vue({
    el: "#app",
    data: {
        email: "",
        code: "",
        password: ""
    },
    methods: {
        sendEmail: function () {
            axios({
                url: "index/sendEmail",
                method: "get",
                params: {
                    email: this.email
                }
            }).then(response => {
                layer.msg(response.data.message, {icon: 1})
            }).catch(error => {
                layer.msg(error.message)
            })
        },
        forgetPassword: function () {
            axios({
                url: "index/forgetPassword",
                method: "get",
                params: {
                    email: this.email, password: this.password, code: this.code
                }
            }).then(response => {
                layer.msg(response.data.message, {icon: 1})
                location.href="html/index.html"
            }).catch(error => {
                layer.msg(error.message)
            })
        }
    }
})