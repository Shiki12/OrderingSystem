function getdine(){
    var name1=document.getElementById('dinenum1123').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/index1',
        data :{"dinename": name1},
        dataType: 'json',
        async: true,
        success: function (data) {
            alert(name1)
        },
        error() {
            alert("请求失败！！！")
        },
    });
}