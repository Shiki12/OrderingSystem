function getmenuone(){
    var menumain=document.getElementById('menu');
    menumain.innerHTML="";

    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/search',
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

function menupicexpress(one) {
    var mainmenu=document.getElementById('menuone');
    var divone=document.createElement('div');
    var a=one.src;
    console.log(a);
    divone.className="expressdinepic";
    divone.id="picexpr";
    divone.style.backgroundImage="url("+a+")";
    mainmenu.appendChild(divone);
    divone.onclick=backfirst;
}
function backfirst(){
    var mainmenu=document.getElementById('menuone');
    var divone=document.getElementById('picexpr');
    mainmenu.removeChild(divone);
}