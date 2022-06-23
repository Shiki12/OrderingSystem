function getdine(){
    var name1=document.getElementById('dinenum1123').value;
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/search',
        data :{"dinename": name1},
        dataType: 'json',
        success: function (data) {
            console.log(data)
            var photos = data.data;//获取返回的JSON结果集
            console.log(photos);
            var tbody = document.getElementById("search-dine");
            tbody.innerText="";
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
function recommendfood(){
    var com1=document.getElementById('commondone');//用户图片，用于定位的
    var com2=document.getElementById('commmodtow');
    com1.innerHTML="";
    com2.innerHTML="";
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/commod',
        dataType: 'json',
        success: function (data) {
            var commoddata=data.data;
            for (let i=0;i<commoddata.length;i++)
            {
                var divmain=document.createElement("div");
                divmain.className="client-box";

                var h4=document.createElement("h4");
                h4.className="title";
                h4.innerHTML=commoddata[i].content;
                divmain.appendChild(h4);

                var p1=document.createElement("p");
                p1.innerHTML="";
                divmain.appendChild(p1);

                var divone=document.createElement("div");
                divone.className="user mt-40";
                var divtow=document.createElement("div");
                divtow.className="thumb";
                var imgone=document.createElement("img");
                imgone.innerHTML="";//用户图片展示
                divtow.appendChild(imgone);

                var spanone=document.createElement("span");
                spanone.innerHTML="";//评论用户名字

                var pone=document.createElement("p");
                pone.innerHTML="";

                divone.appendChild(divtow);
                divone.appendChild(spanone);
                divone.appendChild(pone);

                divmain.appendChild(divone);
                com2.appendChild(divmain);
            }
        }
    })

}
