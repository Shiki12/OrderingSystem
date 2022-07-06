var dingdan={};
var numdingdan={};
var numsign=0;
var allprice=0;
function getmenuall(){
    var menumain=document.getElementById('menuone');
    var kindmenu=document.getElementById('kindmenu');
    menumain.innerHTML="";
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/category/getAllPro',
        dataType: 'text',
        success: function (data) {
            var jsondataone = $.parseJSON(data);
            console.log(jsondataone);
            for(var a=0;a<jsondataone.data.length;a++) {
                console.log(jsondataone.data[a]);
                menumain.innerHTML += "<div class=\"mainmenugetone\" >\n" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].price + "\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].id + "\">\n" +
                    "\t\t\t\t<div class=\"addmenuone\" onclick=\"getred(this)\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].id + "\">\n" +
                    "\t\t\t\t\t<i  class=\"addmenutoshopper\">√</i>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t   <div onclick=\"menupicexpress(" + jsondataone.data[a].id + ")\" name= \"mainonemenupress\" class=\"mainonemenu\">\n" +
                    "\t\t\t\t   <div class=\"dinedivone\">\n" +
                    "\t\t\t\t\t   <img src=\"../../static/img/1.jpg\"  class=\"dinepic\"  id=\"imgdinepic\" >\n" +
                    "\t\t\t\t\t   <span class=\"spanmenupic\">详细</span>\n" +
                    "\t\t\t\t   </div >\n" +
                    "\t\t\t\t   <div class=\"divmainmenu\">\n" +
                    "\t\t\t\t\t   <div><span>" + jsondataone.data[a].name + "</span></div>\n" +
                    "\t\t\t\t\t   <div class=\"menumiaoshu\">\n" +
                    "\t\t\t\t\t\t   <span>" + jsondataone.data[a].miaoshu + " </span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"\">\n" +
                    "\t\t\t\t\t\t   <span>月售出：1000</span>\n" +
                    "\t\t\t\t\t\t   <span>获赞：" + jsondataone.data[a].zan + "</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"yuanmenuprice\">\n" +
                    "\t\t\t\t\t\t   <span>原价：" + jsondataone.data[a].price * 3 + "</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"\">\n" +
                    "\t\t\t\t\t\t   <span>现价：" + jsondataone.data[a].price + "</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"addshoppingmenu\" onclick=''>\n" +
                    "<div class='divoneone'>" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].price + "\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].id + "\">\n" +
                    "\t\t\t\t\t\t   <span class=\"spanone\" onclick=\"jianqu(this)\">-</span>\n" +
                    "</div>" +
                    "             <div style='float: left;margin-left: -80px;'>" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + 0 + "\">\n" +
                    "                <span id=\"textone" + jsondataone.data[a].id + "\">数量:0</span>" +
                    "             </div>" +
                    "<div class='divoneone'>" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].price + "\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\"" + jsondataone.data[a].id + "\">\n" +
                    "\t\t\t\t\t\t   <span class=\"spantow\" onclick=\"addmenuorder(this)\">+</span>\n" +
                    "</div>" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t   </div>\n" +
                    "\t\t\t   </div>\n" +
                    "\t\t\t</div>";
            }
        },
        error(){
            alert("出现异常！！！");
        }
    })

}
function dineone(a){//获取某一类型的所有菜品
    console.log(typeof (a));
    var menumain=document.getElementById('menuone');
    menumain.innerHTML="";
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/category/getOneType',
        data:{"id":a},
        dataType: 'text',
        success: function (data) {
            var jsondataone = $.parseJSON(data);
            console.log(jsondataone);
            for(var a=0;a<jsondataone.data.length;a++)
            {
                console.log(jsondataone.data[a]);
                menumain.innerHTML+="<div class=\"mainmenugetone\" >\n" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].price+"\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].id+"\">\n" +
                    "\t\t\t\t<div class=\"addmenuone\" onclick=\"getred(this)\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].id+"\">\n" +
                    "\t\t\t\t\t<i  class=\"addmenutoshopper\">√</i>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t   <div onclick=\"menupicexpress("+jsondataone.data[a].id+'\',\''+jsondataone.data[a].cid+")\" name= \"mainonemenupress\" class=\"mainonemenu\">\n" +
                    "\t\t\t\t   <div class=\"dinedivone\">\n" +
                    "\t\t\t\t\t   <img src=\"../../static/img/1.jpg\"  class=\"dinepic\"  id=\"imgdinepic\" >\n" +
                    "\t\t\t\t\t   <span class=\"spanmenupic\">详细</span>\n" +
                    "\t\t\t\t   </div >\n" +
                    "\t\t\t\t   <div class=\"divmainmenu\">\n" +
                    "\t\t\t\t\t   <div><span>"+jsondataone.data[a].name+"</span></div>\n" +
                    "\t\t\t\t\t   <div class=\"menumiaoshu\">\n" +
                    "\t\t\t\t\t\t   <span>"+jsondataone.data[a].miaoshu+" </span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"\">\n" +
                    "\t\t\t\t\t\t   <span>月售出：1000</span>\n" +
                    "\t\t\t\t\t\t   <span>获赞："+jsondataone.data[a].zan+"</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"yuanmenuprice\">\n" +
                    "\t\t\t\t\t\t   <span>原价："+jsondataone.data[a].price*3+"</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"\">\n" +
                    "\t\t\t\t\t\t   <span>现价："+jsondataone.data[a].price+"</span>\n" +
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t\t   <div class=\"addshoppingmenu\" onclick=''>\n" +
                    "<div class='divoneone'>" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].price+"\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].id+"\">\n" +
                    "\t\t\t\t\t\t   <span class=\"spanone\" onclick=\"jianqu(this)\">-</span>\n" +
                    "</div>"+
                    "             <div style='float: left;margin-left: -80px;'>" +
                    "\t\t\t\t\t<input type='hidden' value=\""+0+"\">\n" +
                    "                <span id=\"textone"+jsondataone.data[a].id+"\">数量:0</span>"+
                    "             </div>"+
                    "<div class='divoneone'>" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].price+"\">\n" +
                    "\t\t\t\t\t<input type='hidden' value=\""+jsondataone.data[a].id+"\">\n" +
                    "\t\t\t\t\t\t   <span class=\"spantow\" onclick=\"addmenuorder(this)\">+</span>\n" +
                    "</div>"+
                    "\t\t\t\t\t   </div>\n" +
                    "\t\t\t\t   </div>\n" +
                    "\t\t\t   </div>\n" +
                    "\t\t\t</div>";
                var nameyumenupress=document.getElementsByClassName('mainonemenupress');
            }
        },
        error() {
        }
    })
}

function getone(){
    var menumain=document.getElementById('menu');
    menumain.innerHTML="";

    $.ajax({
        type: "get",
        url: 'http://localhost:8001/category/getList',
        dataType: 'json',
        success: function (data) {
            console.log(data)
            var photos = data.data;//获取返回的JSON结果集
            var a;
            for(var i=0;i<photos.length;i++)
            {
                var trone=document.createElement("tr");
                var thone=document.createElement("th");
                thone.className="thname";
                thone.innerText=photos[i].name;
                trone.appendChild(thone);
                var thtow=document.createElement("th");
                thtow.className="thpicture";
                thtow.innerHTML='<img src="../../static/img/front-images/food-menu-1.jpg">';
                trone.appendChild(thtow);
                var ththree=document.createElement("th");
                ththree.className="thmiaoshu";
                ththree.innerText=photos[i].miaoshu;
                trone.appendChild(ththree);
                var thfour=document.createElement("th");
                thfour.className="thname";
                thfour.innerText=photos[i].price;
                trone.appendChild(thfour);
                var thfive=document.createElement("th");
                thfive.className="thname";
                thfive.innerText="下单";
                trone.appendChild(thfive);
                tbody.appendChild(trone);
            }
        },
        error() {
            alert(data);
        },
    });
}

function testone(){
    alert("执行")
    var menumain=document.getElementById('menuone');
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/product/getAll',
        data:{"page":"1"},
        success: function (data) {
            var photos=data.data;
            for(var i=0;i<photos.length;i++)
            {
                var divone=document.createElement('div');
                divone.className="col-md-3 w3-agileits-gallery-grids";

                var aone=document.createElement('a');
                aone.css(data-wow-delay,".9s");
                aone.css(href,"../../static/img/cus/1.jpg");
                aone.css(data-lightbox,"example-set");
                aone.css(data-title,"描述");

                var imgone=document.createElement('img');
                imgone.css(src,"../../static/img/cus/1.jpg");
                imgone.className="img-responsive zoom-img";
                aone.appendChild(imgone);

                var divtow=document.createElement('div');
                divtow.className="agile-b-wrapper";
                var h5one=document.createElement('h5');
                var spanone=document.createElement('span');
                spanone.innerText="$";
                h5one.innerText="价格";
                h5one.appendChild(spanone);
                divtow.appendChild(h5one);
                aone.appendChild(divtow);
                divone.appendChild(aone);
                menumain.appendChild(divone);
            }
        },
        error() {
            alert("有错");
        },
    });
}

function StandardPost(html) {
    localStorage.removeItem('callbackHTML');
    localStorage.setItem('callbackHTML',html);
    window.location.href = window.location.href.split('/h5/')[0] + '/h5/callBack.html';
}
function menupicexpress(one) {
    console.log(one);
    document.cookie="orderproductid"+'='+one;
    window.location.href="http://localhost:8001/index/order";
}
function toshopping(one){
    var customer=getcustomer();
    console.log(one);
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/category/getOneType',
        data:{"pid":one,"oid":"","cstid":customer.id,},
        dataType: 'text',
        success: function (data) {},
        error(){
        }
    })

}
function subnummenu(){
    var num=document.getElementById('nummenu');
    var numtrue=parseInt(num.childNodes[0].data);
    if (numtrue >=1)
    {
        numtrue--;
        num.innerText=numtrue;
    }
    else {
        alert("数量不能未负！！！");
    }
}
function addnummenu(){
    var num=document.getElementById('nummenu');
    var numtrue=parseInt(num.childNodes[0].data);
    if (numtrue >=0)
    {
        numtrue++;
        num.innerText=numtrue;
    }
    else {
        alert("数量不能未负！！！");
    }
}

//存购物车
function toshoppingdata(){
    var customer=getcustomer();
    console.log(customer);

    // $.ajax({
    //     type: "get",
    //     url: 'http://localhost:8001/category/getList',
    //     data:{"pid":customer,"oid":,},
    //     dataType: 'text',
    //     success: function (data) {
    //
    //     },
    //     error() {
    //     }
    // })

}
function getred(one){
    var main=one.childNodes;
    console.log(main);
    if(main[3].className==="addmenutoshopperone")
        main[3].className="addmenutoshopper";
    else
        main[3].className="addmenutoshopperone";
    var maintow=one.previousSibling.previousElementSibling;
    var mainthree=maintow.previousSibling.previousSibling;
    var textone=document.getElementById('textone'+maintow.value.toString());
    console.log(textone);
    var tem=textone.previousSibling.previousSibling;
    if(tem.value.toString()==="0")
        tem.value=1;
    var c=0;
    for (let a in dingdan) {
        if (dingdan[a] === maintow.value.toString()) {
            c = 1;
            break;
        }
    }
    if(c===0){
        dingdan[maintow.value]=maintow.value;
        numsign++;
        allprice=Number(allprice)+Number(mainthree.value)*Number(tem.value);
    }
    else if(c===1){
        numsign--;
        allprice=Number(allprice)-Number(mainthree.value)*Number(tem.value);
        tem.value=0;
        dingdan[maintow.value]=undefined;
    }
    var allpr=document.getElementById('allpriceorder');
    textone.innerText="数量："+tem.value;
    allpr.innerText="总价："+allprice;
}
function topaymenu(){
    var liname=document.getElementsByClassName('addmenutoshopperone');
    var address=document.getElementById('adressmenu');
    if(address.value==="")
    {
        alert("请填写地址");
    }
    else{
        console.log(liname);
        for(var a=0;a<liname.length;a++)
        {
            var one=liname[a].previousSibling.previousSibling;
            var linameone=document.getElementById('textone'+one.value.toString());
            var linametow=linameone.previousSibling.previousSibling;
            var custom=getcustomer();
            console.log(custom);
            console.log(linametow);
            $.ajax({
                type: "get",
                url: 'http://localhost:8001/order/placeOrder',
                data:{"pid":one.value,"cstid":custom,"address":address.value,"number":linametow.value},
                dataType: 'text',
                success: function (data) {
                    StandardPost(data);
                    document.write(localStorage.getItem('callbackHTML'));
                    document.close();
                    alert("成功");
                }, error() {
                    alert("失败");
                }
            })
        }
    }
}
function jianqu(one){
    var tow=one.previousSibling.previousSibling;
    var textone=document.getElementById('textone'+tow.value.toString());
    console.log(textone);
    var tem=textone.previousSibling.previousSibling;
    var three=tow.previousSibling.previousSibling;
    if(tem.value.toString()!=="0")
    {
        allprice=Number(allprice)-Number(three.value);
        tem.value--;
    }
    var allpr=document.getElementById('allpriceorder');
    allpr.innerText="总价："+allprice;
    textone.innerText="数量："+tem.value;
}
function addmenuorder(one){
    var tow=one.previousSibling.previousSibling;
    var textone=document.getElementById('textone'+tow.value.toString());
    console.log(textone);
    var tem=textone.previousSibling.previousSibling;
    var three=tow.previousSibling.previousSibling;
    console.log(three);
    if(tem.value.toString()!=="-1")
    {
        console.log(three);
        allprice=Number(allprice)+Number(three.value);
        tem.value++;
    }
    var allpr=document.getElementById('allpriceorder');
    allpr.innerText="总价："+allprice;
    textone.innerText="数量："+tem.value;
}
function togocar(){
    var liname=document.getElementsByClassName('addmenutoshopperone');
    console.log(liname);
    for(var a=0;a<liname.length;a++)
    {
        var one=liname[a].previousSibling.previousSibling;
        var linameone=document.getElementById('textone'+one.value.toString());
        var linametow=linameone.previousSibling.previousSibling;
        var custom=getcustomer();
        console.log(custom)
        console.log(linametow)
        $.ajax({
            type: "get",
            url: 'http://localhost:8001/order/addOrderShop',
            data:{"pid":one.value,"cstid":custom,"number":linametow.value},

            dataType: 'text',
            success: function (data) {
                alert("添加成功");
            }, error() {
                alert("添加失败");
            }
        })
    }
}