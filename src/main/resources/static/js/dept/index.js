let vm = new Vue({
    el: "#app",
    data: {
        pageInfo: "",
        name: ""
    },
    methods: {
        selectPage: function () {
            axios({
                url: "dept/",
                method: "get",
                params: {name: this.name}
            }).then(response => {
                this.pageInfo = response.data.data
            }).catch(error => {
                layer.msg(error.message)
            })
        },
    }
})