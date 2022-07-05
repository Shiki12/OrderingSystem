function logincus1(){//登录账号
    var username1=document.getElementById('loguser').value;
    var password1=document.getElementById('logpass').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/customer',
        data :{"username": username1 , "password": password1},
        dataType: 'text',
        success: function (data) {
            if(data.toString()=="success")
            {
                alert("登录成功！！！");
               window.location.href='http://localhost:8001/index/index';
            }
            else{
                alert("登录失败！！！");
            }
        },
        error() {
            alert("出现异常！！！");
        },
    });
    return false;
}
function registercus(){//注册账号
    var resuser=document.getElementById('resuser').value;
    var respass=document.getElementById('respass').value;
    var resmail=document.getElementById('resmail').value;
    var resnum=document.getElementById('resnumsureone').value;
    console.log(resnum)
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/login/register',
        data: {"resuser":resuser,"respass":respass,"resmail":resmail,"vcode":resnum},
        dataType: 'text',
        success: function (data) {
            var jsondata=$.parseJSON(data);
            if(jsondata.code!==0)
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
            if(data.toString()==="success")
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
function tosureuserout(){
    var testone=document.getElementById('resjaguser');
    var testtow=document.getElementById('resuser');
    var imgworry=document.getElementById('worryimgone');

    if(testtow.value!==""){
        $.ajax({

            type: "get",
            url: 'http://localhost:8001/login/check',
            data:{"name":testtow.value},
            dataType: 'text',
            success: function (data) {
                var jsondata=$.parseJSON(data);
                console.log(jsondata);
                if(jsondata.code === 1)
                {
                    imgworry.className="worrypicno";
                    testone.innerText="账号可用";
                }
                else{
                    testone.innerText="该用户名已经被注册过！！！";
                    imgworry.className="worrypicon";
                }
            },
            error() {
                alert("出现异常！！！");
            },
        });
    }
    else {
        testone.innerText="账号不能为空！！！";
        imgworry.className="worrypicno";
    }
}

function tosurepass(){
    var one=document.getElementById('respass');
    if(one.value!==""){
        var imgworry =document.getElementById('worryimgtow');
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

function tosurepasssame(){
    var tow=document.getElementById('respass').value;
    var one=document.getElementById('ressure');

    if(one.value!==tow){
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

function tosuremissage(one) {//注册获取验证码
    var imgworry=document.getElementById('worryimgthree');
    var resmail=document.getElementById('resmail');
    var mailtext=document.getElementById('mailtext');
    console.log(resmail.value);
    if(resmail.value!=="")
    {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if(!reg.test(resmail.value))
        {
            mailtext.innerText="邮件格式有错";
            imgworry.className="worrypicno";
        }
        else{
            mailtext.innerText="邮件正确";
            $.ajax({
                type: "get",
                url: 'http://localhost:8001/login/mail',
                data:{"mail":resmail.value},
                dataType: 'text',
                success: function (data) {
                    if(data.toString()=="发送成功")
                    {
                        mailtext.innerText="邮件发送成功";
                        imgworry.className="worrypicno";
                        for(let a=0;a<60;a++){
                            one.value=a;
                            setInterval("RandomImage();",1000);
                        }
                    }
                    else{
                    }
                },
                error() {
                    alert("出现异常！！！");
                },
            });
        }
    }
    else{
        mailtext.innerText="邮件不能为空";
        imgworry.className="worrypicno";
    }

}
function tosuremissageone(one) {//注册获取验证码
    var imgworry=document.getElementById('forimgthree');
    var resmail=document.getElementById('formail');
    console.log(resmail.value);
    if(resmail.value!=="")
    {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if(!reg.test(resmail.value))
        {
            mailtext.innerText="邮件格式有错";
            imgworry.className="worrypicno";
        }
        else{
            mailtext.innerText="邮件正确";
            $.ajax({
                type: "get",
                url: 'http://localhost:8001/login/mail',
                data:{"mail":resmail.value},
                dataType: 'text',
                success: function (data) {
                    if(data.toString()=="发送成功")
                    {
                        alert("邮件发送成功！！！");
                        imgworry.className="worrypicno";
                        for(let a=0;a<60;a++){
                            one.value=a;
                            setInterval("RandomImage();",1000);
                        }
                    }
                    else{
                    }
                },
                error() {
                    alert("出现异常！！！");
                },
            });
        }
    }
    else{
        mailtext.innerText="邮件不能为空";
        imgworry.className="worrypicno";
    }

}

function toregist(){//更改login的样式到regist
    var bottomres=document.getElementById('logincus');
    var titleres=document.getElementById('titlelogin');
    var titlerone=document.getElementById('titleloginone');
    titlerone.innerText="";
    titlerone.innerText="密码注册";

    titleres.innerHTML="";
    titleres.innerText="用户注册";
    bottomres.innerHTML="";
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div onmouseout=\"tosureuserout()\" class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"resuser\" required=\"\">\n" +
        "            <label id=\"resjaguser\" >请输入用户名</label>\n" +
        "            <img id=\"worryimgone\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div onmouseout=\"tosurepass(this)\" class=\"inputBox\">\n" +
        "            <input  type=\"password\" id=\"respass\" required=\"\">\n" +
        "            <label id=\"resjagpass\">请输入密码</label>\n" +
        "            <img id=\"worryimgtow\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div onmouseout=\"tosurepasssame(this)\"  class=\"inputBox\">\n" +
        "            <input type=\"password\" id=\"ressure\" required=\"\">\n" +
        "            <label id=\"ressurepass\">请确认密码</label>\n" +
        "            <img id=\"worryimgthree\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"test\" id=\"resmail\" required=\"\">\n" +
        "            <label id='mailtext'>请输入邮箱</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBoxnumber\">\n" +
        "            <input class=\"inputone\" type=\"text\" id=\"resnumsureone\" required=\"\">\n" +
        "            <label id=\"ressurenumber\">验证码</label>\n" +
        "            <button class=\"inputtow\" onclick=\"tosuremissage(this)\" type=\"button\" id=\"resnumsure\">获取验证码</button>>\n" +
        "            <img id=\"worryimgfour\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <button type=\"button\" onclick=\"registercus()\">注册</button>>\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <button type=\"button\" onclick=\"tologin()\">返回</button>>\n" +
        "        </div>\n" +
        "    </form>";

}
function toforgetnumber(){
    var bottomres=document.getElementById('logincus');
    bottomres.innerHTML="";
    var titleres=document.getElementById('titlelogin');
    var titlerone=document.getElementById('titleloginone');
    titlerone.innerText="";
    titlerone.innerText="密码找回";

    titleres.innerHTML="";
    titleres.innerText="密码找回";
    bottomres.innerHTML="<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"foruser\" required=\"\">\n" +
        "            <label>请输入用户名</label>\n" +
        "            <img id=\"forimgone\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"formail\" required=\"\">\n" +
        "            <label>请输入邮箱</label>\n" +
        "            <img id=\"forimgtow\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"inputBoxnumber\">\n" +
        "            <input class=\"inputone\" type=\"text\" id=\"fornumsureone\" required=\"\">\n" +
        "            <label id=\"ressurenumber\">验证码</label>\n" +
        "            <button class=\"inputtow\" onclick=\"tosuremissageone(this)\" type=\"button\" id=\"fornumsure\">获取验证码</button>>\n" +
        "            <img id=\"forimgthree\" src=\"../../static/img/front-images/icon/worry.png\" class=\"worrypicno\">"+
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <button type=\"button\" onclick=\"forgetnumber()\">找回</button>>\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <button type=\"button\" onclick=\"tologin()\">返回</button>>\n" +
        "        </div>\n" +
        "    </form>";
}
function tologin() {
    var bottomres = document.getElementById('logincus');
    bottomres.innerHTML = "";
    var titleres = document.getElementById('titlelogin');
    titleres.innerHTML = "";
    var titlerone=document.getElementById('titleloginone');
    titlerone.innerText="";
    titlerone.innerText="用户登录";
    titleres.innerText = "用户登录";
    bottomres.innerHTML = "<form class=\"logincus\" id=\"logincus\">\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"text\" id=\"loguser\" required=\"\">\n" +
        "            <label>用户名</label>\n" +
        "        </div>\n" +
        "        <div class=\"inputBox\">\n" +
        "            <input type=\"password\" id=\"logpass\" required=\"\">\n" +
        "            <label>密码</label>\n" +
        "        </div>\n" +
        "        <div class=\"cusloginbottom\">\n" +
        "            <button type=\"button\" onclick=\"logincus1()\">登录</button>>\n" +
        "        </div>\n" +
        "        <div class=\"cusregistbottom\">\n" +
        "            <button type=\"button\" onclick=\"toregist()\">注册</button>>\n" +
        "        </div>\n" +
        "        <div class=\"divforgetcus\">\n" +
        "            <span class=\"spanlogincus\" onclick=\"toforgetnumber()\">忘记密码</span>\n" +
        "        </div>\n" +
        "    </form>";
}