// pages/cart/cart.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cart: [],
    isAllSelected: false,
    totalPrice: 0,
    totalSelectedGoodsNum: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this
    //请求用户购物车
    wx.getStorage({
      key: 'token',
      success(res) {
        //console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wx_order/getOrderByToken', //仅为示例，并非真实的接口地址
          data: {
            token: res.data
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success(res) {
            //console.log(res.data)
            that.setData({
              cart: res.data.data
            })
          }
        })
      }
    })
  },
  onChangeSelectItem(ev) {
    var isAllSelected = this.data.isAllSelected
    var totalPrice = this.data.totalPrice
    var totalSelectedGoodsNum = this.data.totalSelectedGoodsNum
    const carts = this.data.cart
    //console.log(carts)
    for (let i = 0, lenI = carts.length; i < lenI; ++i) {
      if (carts[i].id === ev.currentTarget.dataset.id) {
        if (carts[i].checked == false) {
          carts[i].checked = true;
          totalSelectedGoodsNum++;
          totalPrice+=carts[i].price;
          break;
        }
        if (carts[i].checked == true) {
          totalSelectedGoodsNum--;
          totalPrice-=carts[i].price;
          carts[i].checked = false;
          break;
        }
      }
    }
    isAllSelected=true;
    for(let i = 0, lenI = carts.length; i < lenI; ++i){
      if(carts[i].checked == true)
        continue;
      else{
        isAllSelected = false;
        break;
      }
    }

    this.setData({
      cart:carts,
      isAllSelected,
      totalPrice,
      totalSelectedGoodsNum
    })
  },

  onChangeSelectAll() {
    var isAllSelected = this.data.isAllSelected
    var totalPrice = this.data.totalPrice
    var totalSelectedGoodsNum = this.data.totalSelectedGoodsNum
    const carts = this.data.cart
    if (isAllSelected == true) {
      for (let i = 0, lenI = carts.length; i < lenI; ++i) {
        carts[i].checked=false;
        totalSelectedGoodsNum--;
        totalPrice-=carts[i].price;
      }
      isAllSelected=false
    } else {
      for (let i = 0, lenI = carts.length; i < lenI; ++i) {
        carts[i].checked=true;
        totalSelectedGoodsNum++;
        totalPrice+=carts[i].price;
      }
      isAllSelected=true
    }
    //console.log(carts)
    this.setData({
      cart:carts,
      isAllSelected,
      totalPrice,
      totalSelectedGoodsNum
    })
  },

  onTapPay() {
    const {
      totalSelectedGoodsNum
    } = this.data;

    if (totalSelectedGoodsNum === 0) {
      wx.showToast({
        title: '请选购商品',
        icon:'error'
      });
      return;
    }
    wx.navigateTo({
      url:'/pages/pay/pay'
    });
  },

  DeleteItem(e){
    var that =this
    //console.log(e.currentTarget.dataset.id);
    wx.getStorage({
      key: 'token',
      success (res) {
        console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wx_order/wxDeleteOrder',
          data: {
            id: e.currentTarget.dataset.id,
            //number: e.currentTarget.dataset.id,
            token:res.data
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success (res) {
            //console.log(res.data)
            if(res.data.code==1){
              wx.showToast({
                title: res.data.msg,
                icon: 'success',
                duration: 2000
              })
            }else{
              //显示提示
              wx.showToast({
                title: res.data.msg,
                icon: 'error',
                duration: 2000
              })
            }
          }
        })
      }
    })

  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    var that = this
    //请求用户购物车
    wx.getStorage({
      key: 'token',
      success(res) {
        console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wx_order/getOrderByToken', //仅为示例，并非真实的接口地址
          data: {
            token: res.data
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success(res) {
            //console.log(res.data)
            that.setData({
              cart: res.data.data
            })
          }
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})