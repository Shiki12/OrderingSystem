function logincus1(){//登录账号
    var username1=document.getElementById('loguser').value;
    var password1=document.getElementById('logpass').value;
    console.log(password1+"123");
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
    var resuser=document.getElementById('resuser').value;
    var respass=document.getElementById('respass').value;
    var ressure=document.getElementById('ressure').value;
    var resmail=document.getElementById('resmail').value;

    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/register',
        data: {"resuser":resuser,"respass":respass,"ressure":ressure,"resmail":resmail},
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
function forgetnumber(){//找回密码

    var foruser=document.getElementById('foruser').value;
    var formail=document.getElementById('formail').value;

    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/forget',
        data:{"foruser":foruser,"formail":formail},
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
function tosureuserout(one){
    console.log(one.value)
    if(one.value!=""){
        $.ajax({
            type: "get",
            url: 'http://localhost:8001/login/forget',
            data:{"tosureuser":one.value},
            dataType: 'text',
            success: function (data) {
                if(data.toString()=="success")
                {
                    var imgworry=document.getElementById('worryimgone');
                    imgworry.className="worrypicon";
                    var testone=document.getElementById('resjaguser');
                    testone.innerText="请输入账号";
                }
                else{
                    var resjag=document.getElementById('resjaguser');
                    resjag.innerText="该用户名已经被注册过！！！";
                    var imgworry=document.getElementById('worryimgone');
                    imgworry.className="worrypicno";
                }
            },
            error() {
                alert("出现异常！！！");
            },
        });
    }
    else {
        console.log("执行");
    }
}

function tosurepass(one){
    if(one.value!=""){
        var imgworry=document.getElementById('worryimgtow');
        imgworry.className="worrypicno";
        var testone=document.getElementById('resjagpass');
        testone.innerText="请输入密码";
    }
    else {
        var imgworry=document.getElementById('worryimgtow');
        imgworry.className="worrypicon";
        var testone=document.getElementById('resjagpass');
        testone.innerText="密码不能为空";
    }
}

function tosurepasssame(one){
    var tow=document.getElementById('respass').value;

    if(one.value!=tow){
        var imgworry=document.getElementById('worryimgthree');
        imgworry.className="worrypicon";
        var testone=document.getElementById('ressurepass');
        testone.innerText="两次新密码输入不一样！";
    }
    else {
        var imgworry=document.getElementById('worryimgthree');
        imgworry.className="worrypicno";
        var testone=document.getElementById('ressurepass');
        testone.innerText="请确认密码";
    }
}

function toregist(){//更改login的样式到regist
    var bottomres=document.getElementById('logincus');
    var titleres=document.getElementById('titlelogin');
    titleres.innerHTML="";
    titleres.innerText="用户注册";
    bottomres.innerHTML="";
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input onmouseout=\"tosureuserout(this)\" type=\"text\" id=\"resuser\" required=\"\">\n" +
        "            <label id=\"resjaguser\" >请输入用户名</label>\n" +
        "            <img id=\"worryimgone\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input onmouseout=\"tosurepass(this)\" type=\"password\" id=\"respass\" required=\"\">\n" +
        "            <label id=\"resjagpass\">请输入密码</label>\n" +
        "            <img id=\"worryimgtow\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input onmouseout=\"tosurepasssame(this)\" type=\"password\" id=\"ressure\" required=\"\">\n" +
        "            <label id=\"ressurepass\">请确认密码</label>\n" +
        "            <img id=\"worryimgthree\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" id=\"resmail\" required=\"\">\n" +
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
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"foruser\" required=\"\">\n" +
        "            <label>请输入用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" id=\"formail\" required=\"\">\n" +
        "            <label>请输入邮箱</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <input type=\"submit\" id=\"\" value=\"找回\" onclick=\"forgetnumber()\">\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <input type=\"submit\" id=\"\" value=\"返回\" onclick=\"tologin()\">\n" +
        "        </div>\n" +
        "    </form>";
}
function tologin() {
    var bottomres=document.getElementById('logincus');
    bottomres.innerHTML="";
    var titleres=document.getElementById('titlelogin');
    titleres.innerHTML="";
    titleres.innerText="用户登录";
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"loguser\" required=\"\">\n" +
        "            <label>用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" id=\"logpass\" required=\"\">\n" +
        "            <label>密码</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <input type=\"submit\" id=\"\" value=\"登录\" onclick=\"logincus1()\">\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <input type=\"submit\" name=\"\" value=\"注册\" onclick=\"toregist()\">\n" +
        "        </div>\n" +
        "        <div class=\"divforgetcus\">\n" +
        "            <span class=\"spanlogincus\" onclick=\"toforgetnumber()\">忘记密码</span>\n" +
        "        </div>\n" +
        "    </form>";
}