package com.lpj.wxgzhh.service;

import com.lpj.wxgzhh.domain.StoreOrder;
import com.lpj.wxgzhh.repository.OrderRepository;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.lpj.wxgzhh.domain.StoreOrder.orderState.IS_SHIPMENTS;


@Service
public class OrderContentService {

    @Autowired
    private OrderRepository OR;

    @Autowired
    private StoreUserRepository SUR;

    // 根据订单id，用户id，判断余额是否大于订单金额，大于则将订单状态改为未发货并扣除相应金额
    public String updateShipmentsOrder(String userId,String orderId){
        int balance=Integer.parseInt(SUR.findByUserId(userId).getBalance());
        int price=Integer.parseInt(OR.findByOrderId(orderId).getTotalPrice());
        if(balance>price){
            OR.saveOrderState(orderId,"IS_SHIPMENTS");
            String newBalance=String.valueOf(balance-price);
            SUR.saveBalance(userId,newBalance);
            return "ok";
        }else {
            return "no";
        }
    }
    // 根据订单id，查询订单信息
    public String findOrderBalance(String orderId){
        String balance=OR.findByOrderId(orderId).getTotalPrice();
        return balance;
    }
}
