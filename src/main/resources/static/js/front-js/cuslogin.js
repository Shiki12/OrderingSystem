function logincus1(){
    var username1=document.getElementById('Username1').value;
    var password1=document.getElementById('Password1').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/cuslogin',
        data :{"username": username1 , "password": password1},
        dataType: 'json',
        async: true,
        success: function (data) {
            if(data===4)
                document.getElementById("myDiv").innerHTML;
        },
        error() {
            alert("请求失败！！！")
        },
    });
}