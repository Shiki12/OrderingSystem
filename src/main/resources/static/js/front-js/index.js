function getdine(){
    var name1=document.getElementById('dinenum1123').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/search',
        data :{"dinename": name1},
        dataType: 'json',
        async: true,
        success: function (data) {
            if(data==4)
                document.getElementById("myDiv").innerHTML;
        },
        error() {
            alert("请求失败！！！")
        },
    });
}
function getsortfromindex(num){
    location.href=encodeURI("http://localhost:8001/index/about?a="+num)
}