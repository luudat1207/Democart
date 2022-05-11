/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dal.OrderDao;
import dal.OrderDetailDao;
import java.util.ArrayList;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author lephu
 */
public class OrderLogic {
    Order order;
    ArrayList<OrderDetail> details;

    public OrderLogic(Order order, ArrayList<OrderDetail> details) {
        this.order = order;
        this.details = details;
    }
    
    public void insertOrder()
    {
        OrderDao orderdao = new OrderDao();
        OrderDetailDao detaildao = new OrderDetailDao();
        int orderid = orderdao.InsertOrderInfo(order);
        for(OrderDetail detail: details)
        {
            detail.setOrderId(orderid);
            detaildao.InsertOrderDetail(detail);
        }
    }
}
