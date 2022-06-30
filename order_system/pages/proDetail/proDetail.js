// pages/proDetail/proDetail.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    proInfo:{},

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this
    //console.log("项目详情页面获取的id为：",options.id)
    wx.request({
      url: 'http://localhost:8001/wx_product/getProDetail', //仅为示例，并非真实的接口地址
      data: {
        id: options.id
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        //console.log(res.data.data)
        that.setData({
          proInfo:res.data.data
        })
      }
    })
  },
  onTapAddToCart(e){
    //console.log(e)
    wx.getStorage({
      key: 'token',
      success (res) {
        console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wx_order/addOrder', //仅为示例，并非真实的接口地址
          method:"POST",
          data: {
            pid: e.currentTarget.dataset.id,
            number: e.currentTarget.dataset.id,
            token:res.data,
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success (res) {
            console.log(res.data)
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
  onTapNowToPay(){

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