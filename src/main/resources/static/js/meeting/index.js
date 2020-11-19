let vm = new Vue({
    el: "#app",
    data: {
        Meetings: {},
        title: "",
        status: ""
    },
    methods: {
        selectPage: function (pageNum = 1, pageSize = 5) {
            axios({
                url: `/meeting/${pageNum}/${pageSize}`,
                params: {title: this.title, status: this.status}
            }).then(response => {
                this.Meetings = response.data.data
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
    },
    mounted: function () {
        this.selectPage()
    },
})