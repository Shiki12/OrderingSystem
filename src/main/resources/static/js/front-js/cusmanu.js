function getmenu(){
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