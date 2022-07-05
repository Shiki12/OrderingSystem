// pages/pwd/pwd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
  },

  formSubmit:function(e){
    // var oldPwd=this.data.password
    // console.log(e)
    // console.log(oldPwd)
    if(e.detail.value.newPwd1!=e.detail.value.newPwd2){
      wx.showToast({
        title: '密码不一致！',
        icon: 'error',
        duration: 1000
      })
      return;
    }
    if(oldPwd==e.detail.value.newPwd1)
    {
      wx.showToast({
        title: '与原密码相同！',
        icon: 'error',
        duration: 1000
      })
    }
    else{
    //获取token
    wx.getStorage({
      key: 'token',
      success (res) {
        console.log(res.data)
        //把参数打包，同时发起请求
        wx.request({
          url: 'http://localhost:8001/wechat/updateUserPwd', //仅为示例，并非真实的接口地址
          method:"POST",
          data: {
            token: res.data,
            newPwd:e.detail.value.newPwd,
          },
          header: {
            'Content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success (res) {
            console.log(res.data)
            if(res.data.code==1){
              wx.navigateBack({
                delta: 1,
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
                duration: 1000
              })
            }
          }
        })
      }
    })
  }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    
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