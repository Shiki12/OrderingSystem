// pages/feedback/feedback.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    feedbackText:'',
    chooseImgsPath:[],
    items: [
      {value: 'quality', name: '质量问题',checked: 'true'},
      {value: 'purchase', name: '购买问题',},
      {value: 'advise', name: '商品建议'},
      {value: 'function', name: '功能建议'},
      {value: 'others', name: '其他'},
    ]
  },

  radioChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
    const items = this.data.items
    for (let i = 0, len = items.length; i < len; ++i) {
      items[i].checked = items[i].value === e.detail.value
    }
    this.setData({
      items
    })
  }, 
  onInputFeedback(ev) {
    this.setData({feedbackText:ev.detail.value});
  },

  onTapSubmit(ev) {
    // 校验表单
    let {feedbackText, chooseImgsPath} = this.data;
    if (!feedbackText.trim()) {
      wx.showToast({title:'请输入您要反馈的问题', icon:'none', mask:true});
      return;
    }
    if (chooseImgsPath.length > 0) {
      // 暂时不做图片上传功能
      return;

    } else {
      wx.showToast({
        title: '提交成功',
        icon: 'success',
        duration: 2000,
        complete:[
          console.log('只提交反馈文本'),
          // 返回到上一个页面
          wx.navigateBack({delta:1})
        ]
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