let vm = new Vue({
    el: "#app",
    data: {
        pageInfo: {},
        name: "",
        myfocus: {},
        flag: true
    },
    methods: {
        selectPage: function (pageNum = 1, pageSize = 5) {
            axios({
                url: `/user/${pageNum}/${pageSize}`,
                params: {name: this.name}
            }).then(response => {
                this.pageInfo = response.data.data
                this.myFocus()
            }).catch(error => {
                layer.msg(error.message)
            })

        },
        toDetail: function (user) {
            layer.user = user;
            layer.open({
                type: 2,
                title: false,
                area: ['60%', '80%'],
                content: ['html/user_detail.html', "yes"]
            })
        },
        myFocus: function () {
            axios({
                url: "user/myfocus",
            }).then(response => {
                this.myfocus = response.data.data
                for (let i = 0; i < this.pageInfo.list.length; i++) {
                    this.$set(this.pageInfo.list[i], "check", false)
                }
                for (let i = 0; i < this.pageInfo.list.length; i++) {
                    for (let j = 0; j < this.myfocus.length; j++) {
                        if (this.pageInfo.list[i].id === this.myfocus[j].userFocusId) {
                            this.$set(this.pageInfo.list[i], "check", true)
                        }
                    }
                }
            }).catch(error => {
                layer.msg(error.message)
            })
        },
        changeFocus: function (user) {
            // for (let i = 0; i < this.pageInfo.list.length; i++) {
            //     if (this.pageInfo.list[i].id === user.id) {
            //         this.pageInfo.list[i].check = !this.pageInfo.list[i].check
            //         user.check = this.pageInfo.list[i].check
            //         break;
            //     }
            // }
            if (user.check) {
                //关注
                axios({
                    url: `user/changeFocus/${user.id}`,
                    method: "post",
                }).then(response => {
                    layer.msg(response.data.message, {icon: 1})
                }).catch(error => {
                    layer.msg(error.message)
                })
            } else {
                //取关
                axios({
                    url: `user/deleteFocus/${user.id}`,
                    method: "delete",
                }).then(response => {
                    layer.msg(response.data.message, {icon: 1})
                }).catch(error => {
                    layer.msg(error.message)
                })
            }
        }
    },
    mounted: function () {
        this.selectPage()
    },
})