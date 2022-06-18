function getdine(){
    var name1=document.getElementById('dinenum1123').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/search',
        data :{"dinename": name1},
        dataType: 'json',
        success: function (data) {
            if(data=="登录成功")
                alert("登录成功！！");
        },
        error() {
            alert(data);
        },
    });
}
function getsortfromindex(num){
    location.href=encodeURI("http://localhost:8001/index/about?a="+num)
}