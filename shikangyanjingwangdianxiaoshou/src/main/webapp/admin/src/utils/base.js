const base = {
    get() {
        return {
            url : "http://localhost:8080/shikangyanjingwangdianxiaoshou/",
            name: "shikangyanjingwangdianxiaoshou",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shikangyanjingwangdianxiaoshou/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "视康眼镜网店销售系统"
        } 
    }
}
export default base
