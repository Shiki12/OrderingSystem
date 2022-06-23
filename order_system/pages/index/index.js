// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //循环推荐
    bannerData: [],
    //左导航
    leftMenuList:[],
    currentLeftmenuIndex:0,
    //右商品
    RightItems: [],
    currentRightmenuIndex:0,
    //商品排列表
    RightItemsNumber:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this
    //请求商品分类
    wx.request({
      url: 'http://localhost:8001/wx_category/getAll',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
          that.setData({
            leftMenuList:res.data
          })
      }
    }),
    //请求所有商品清单
    wx.request({
      url: 'http://localhost:8001/wx_product/getProInfos', 
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        if(res.data.code == 1){
          that.setData({
            RightItems:res.data.data
          })
        }
      }
    }),
    //请求各类商品数量
    wx.request({
      url: 'http://localhost:8001/wx_product/getProNum', 
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        if(res.data.code == 1){
          that.setData({
            RightItemsNumber:res.data.data
          })
        }
      }
    })

  },

  /**
   * 左导航切换
   */
  onTapLeftmenu(ev) {
    // console.log(ev)
    this.setData({
      currentLeftmenuIndex:ev.currentTarget.dataset.index,
      currentRightmenuIndex:ev.currentTarget.dataset.rightindex,
    });
  },

  /**
   * 商品详细界面跳转
   */
  toProDetail:function(e){
    //console.log("点击商品id为：",e.currentTarget.dataset.id)
    //页面跳转至项目详情页面
    wx.navigateTo({
      url: '/pages/proDetail/proDetail?id='+e.currentTarget.dataset.id,
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