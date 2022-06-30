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

    //请求用户购物车
    wx.getStorage({
      key: 'token',
      success (res) {
        console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wx_order/getOrderByToken', //仅为示例，并非真实的接口地址
          data: {
            token:res.data
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success (res) {
            
          }
        })
      }
    })
  },

  onTapPay() {
    const {
      totalSelectedGoodsNum
    } = this.data;

    if (totalSelectedGoodsNum === 0) {
      wx.showToast({
        title: '您还没有选购商品',
      });
      return;
    }
    //wx.navigateTo({url:'/pages/pay/index'});
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