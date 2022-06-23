function logincus1(){//登录账号
    var username1=document.getElementById('name').value;
    var password1=document.getElementById('pass').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/customer',
        data :{"username": username1 , "password": password1},
        dataType: 'text',
        success: function (data) {
            if(data.toString()=="success")
            {
                alert("登录成功！！！");
                window.location.href='http://localhost:8001/index/index'
            }
            else{
                alert("登录失败！！！");
            }
        },
        error() {
            alert("出现异常！！！");
        },
    });
}
function registercus(){//注册账号
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/register',
        dataType: 'text',
        success: function (data) {
            if(data.toString()=="success")
            {
                alert("注册成功");
                window.location.href='http://localhost:8001/index/index'
            }
            else{
                alert("注册失败！！！");
            }
        },
        error() {
            alert("出现异常！！！");
        },
    });
}
function toregist(){//更改login的样式到regist
    var bottomres=document.getElementById('logincus');
    var titleres=document.getElementById('titlelogin');
    titleres.innerHTML="";
    titleres.innerText="用户注册";
    bottomres.innerHTML="";
    bottomres.innerHTML="<form class=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" name=\"\" required=\"\">\n" +
        "            <label>请输入用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" name=\"\" required=\"\">\n" +
        "            <label>请输入密码</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" name=\"\" required=\"\">\n" +
        "            <label>请确认密码</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" name=\"\" required=\"\">\n" +
        "            <label>请输入邮箱</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"注册\" onclick=\"registercus()\">\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"返回\" onclick=\"tologin()\">\n" +
        "        </div>\n" +
        "    </form>";

}
function toforgetnumber(){
    var bottomres=document.getElementById('logincus');
    bottomres.innerHTML="";
    var titleres=document.getElementById('titlelogin');
    titleres.innerHTML="";
    titleres.innerText="密码找回";
    bottomres.innerHTML="<form class=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" name=\"\" required=\"\">\n" +
        "            <label>请输入用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" name=\"\" required=\"\">\n" +
        "            <label>请输入邮箱</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"找回\" onclick=\"forgetnumber()\">\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"返回\" onclick=\"tologin()\">\n" +
        "        </div>\n" +
        "    </form>";
}
function forgetnumber(){//找回密码
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/register',
        dataType: 'text',
        success: function (data) {
            if(data.toString()=="success")
            {
                alert("这是你的密码"+data.data);
                window.location.href='http://localhost:8001/index/cuslogin'
            }
            else{
                alert("找回密码失败！！！");
            }
        },
        error() {
            alert("出现异常！！！");
        },
    });
}
function tologin() {
    var bottomres=document.getElementById('logincus');
    bottomres.innerHTML="";
    var titleres=document.getElementById('titlelogin');
    titleres.innerHTML="";
    titleres.innerText="用户登录";
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" name=\"\" required=\"\">\n" +
        "            <label>用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" name=\"\" required=\"\">\n" +
        "            <label>密码</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"登录\" onclick=\"logincus1()\">\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"注册\" onclick=\"toregist()\">\n" +
        "        </div>\n" +
        "        <div class=\"divforgetcus\">\n" +
        "            <span class=\"spanlogincus\" onclick=\"toforgetnumber()\">忘记密码</span>\n" +
        "        </div>\n" +
        "    </form>";
}