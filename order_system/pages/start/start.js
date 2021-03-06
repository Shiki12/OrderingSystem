// pages/start/start.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  formSubmit:function(e){
    wx.login({
      success (res) {
        console.log(res.code)
        if (res.code) {
          //发起网络请求
          wx.request({
            url: 'http://localhost:8001/wechat/login',
            method:"POST",
            header: {
              'Content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            data: {
              code: res.code,
              phone:e.detail.value.phone,
              password:e.detail.value.password
            },
            success (res) {
              console.log(res.data)
              if(res.data.code==1){
                wx.reLaunch({
                  url: '/pages/index/index'
                })
                //把token缓存
                wx.setStorage({
                  key:"token",
                  data:res.data.data
                })
                wx.showToast({
                  title: res.data.msg,
                  icon: 'success',
                  duration: 1000
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
      }
    })
  },
toRegister(){
  wx.navigateTo({
    url: '/pages/register/register'
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