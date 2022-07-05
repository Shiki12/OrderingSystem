function shoppingget(){//判定登录成功后直接载入订单
    $.ajax({
        type: "get",
        url: 'http://localhost:8001/index/search',
        data :{"dinename": name1},
        dataType: 'json',
        success: function (data) {

        },
        error (){
        }
    })
}
function getshoping(){//获取订单

    $.ajax({
        type: "get",
        url: 'http://localhost:8001/order/get',
        dataType: 'text',
        success: function (data) {
            var jsondata = $.parseJSON(data);
            console.log(jsondataone);
            var ordershopping=document.getElementById('ordershopping');
            for(var a=0;a<jsondataone.data.length;a++)
            {
                var divtow=document.createElement('div');

                var done=document.createElement('div');
                var dtow=document.createElement('div');
                var dthree=document.createElement('div');
                var dfour=document.createElement('div');
                var dfive=document.createElement('div');
                var dsix=document.createElement('div');
                var inputone=document.createElement('input');

                inputone.className="spaceone";
                inputone.value=0;

                done.className="divthirdone";
                done.innerHTML="<span>加入</span>";
                done.id="aaaaaa";

                dtow.className="divthirdtow";
                dtow.innerHTML="<span>商品的描述，需要单独从后端获取</span>";

                dthree.className="divthirdthree";
                dthree.innerHTML="<span>商品的价格，</span>";

                dfour.className="divthirdfour";
                dfour.innerHTML="<input>1</input>";

                dfive.className="divthirdfive";
                dfive.innerHTML="<button>金额</button>";

                dsix.className="divthirdsix";
                dsix.innerHTML="<button>操作</button>";

                divtow.appendChild(done);
                divtow.appendChild(dtow);
                divtow.appendChild(dthree);
                divtow.appendChild(dfour);
                divtow.appendChild(dfive);
                divtow.appendChild(dsix);
                ordershopping.appendChild(divtow);

            }
        },
        error (){
        }
    })
}