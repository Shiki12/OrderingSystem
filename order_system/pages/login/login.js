// pages/login/login.js
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
    wx.getStorage({
      key: 'userInfo',
      success (res) {
        console.log("取出缓存成功：",res.data,"，即将页面跳转至大厅，无需再次获权")
        wx.reLaunch({
          url: '/pages/start/start'
        })
      }
    })
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于员资完善会料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res.userInfo)
        wx.setStorage({
          key:"userInfo",
          data:res.userInfo
        })
        wx.reLaunch({
          url: '/pages/start/start'
        })
      }
    })    
  },

  exitMiniProgram(e){
    wx.showModal({
      title: '退出',
      content:'要离开了吗',
      success (res) {
        if (res.confirm) {
          console.log('exit'),
          wx.exitMiniProgram({
            success:function(){
              console.log('exit_ok')
            }
          });
        } else if (res.cancel) {
          console.log('exit_cancel')
        }
      }
    })

  },
  /*
  exitMiniProgram(e){
    wx.showActionSheet({
      alertText:"要离开了吗",
      itemList: ['确定', '取消'],
      success () {
        wx.exitMiniProgram()
      },
      fail () {
      }
    })
  },

  */
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