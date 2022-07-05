// pages/address/address.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this
    wx.getStorage({
      key: 'token',
      success (res) {
        //console.log(" address页面取出用户token:",res.data)
        wx.request({
          url: 'http://localhost:8001/wechat/getUserInfo',
          data:{
            token:res.data,
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success (res) {
              that.setData({
                userInfo:res.data.data
              })
          }
        })
      }
    })
  },

  formSubmit(e) {
    //console.log('form发生了submit事件，携带数据为：', e.detail.value)
    wx.getStorage({
      key: 'token',
      success (res) {
        //console.log(" address页面取出用户token:",res.data)
        wx.request({
          url: 'http://localhost:8001/wechat/updateUserInfo',
          data:{
            token:res.data,
            name:e.detail.value.name_input,
            phone:e.detail.value.phone_input,
            address:e.detail.value.address_input,
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
                duration: 1500
              })
            }else{
              //显示提示
              wx.showToast({
                title: res.data.msg,
                icon: 'error',
                duration: 1500
              })
            }
          }
        })
      }
    })
  },

  toChangePwd(){
      wx.navigateTo({
        url: '/pages/pwd/pwd',
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