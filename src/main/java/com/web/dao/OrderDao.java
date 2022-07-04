package com.web.dao;


import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.wechat.entity.cart;
import com.web.wechat.entity.wxOrder;
import com.web.wechat.entity.wxOrderDetail;
import com.web.entity.po.AlipayDto;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;
import com.web.entity.po.ProductChild;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//订单接口
@Mapper
public interface OrderDao {
    //得到某人的订单
    List<Order> getCustomerOrderById(Customer customer);

    //添加order_表
    int addOrder(Order order);

    //添加 order_item
    int addOrderItem(OrderItem orderItem);

    int addOrderChild(OrderChild orderChild);

    List<cart> getOrderByToken(String token);

    void wxAddOrder(int pid, int cid ,int number);

    //统计最大的订单id
    int count();
    //更改订单状态
    int updateStatus(@Param("status") int status,@Param("id") int id);

    //创建沙箱支付的条件
    List<AlipayDto> selectAlipay(@Param("id") int id);

    ProductChild selectPriceAndName(@Param("id")int id);


    boolean addOrder(int pid, int cid ,int number);
    List<wxOrder> getOrderByStatusAndToken(int status, String token);

    List<wxOrder> getAllOrderByToken(String token);

    List<wxOrderDetail> getOrderDetailByCode(String code);

    //得到所有的订单
    List<Order> getAllOrder();


    void wxDeleteOrder(@Param("id")int id);

    wxOrderDetail getOrderDetailById(@Param("id")int id);
}
