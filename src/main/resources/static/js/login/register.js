let vm = new Vue({
    el: "#app",
    data: {
        user: {},
        confPassword: ""
    },
    methods: {
        register: function () {
            if (this.confPassword !== this.user.password) {
                layer.msg("两次输入密码不一致", {icon: 1})
                return;
            }
            axios({
                url: "index/register",
                method: "post",
                data: this.user
            }).then(response => {
                if (response.data.flag) {
                    location.href = "html/index.html"
                } else {
                    layer.msg(response.data.message, {icon: 1})
                }
            }).catch(error => {
                layer.msg(error.message)
            })
        },

    }
})