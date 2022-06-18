function logincus1(){
    var username1=document.getElementById('Username1').value;
    var password1=document.getElementById('Password1').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/customer',
        data :{"username": username1 , "password": password1},
        dataType: 'json',
        async: true,
        success: function (data1) {
            if(data1.responseText==="success")
                alert("success");
        },
        error(data1) {
            console.log(data1.responseText);
        },
    });
}