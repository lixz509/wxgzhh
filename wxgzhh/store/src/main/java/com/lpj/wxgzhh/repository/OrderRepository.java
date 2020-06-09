package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreDialogue;
import com.lpj.wxgzhh.domain.StoreOrder;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository  extends JpaRepository<StoreOrder, String> {

    // 增加订单
    <S extends StoreOrder> S save(S entity);

    // 根据订单id修改订单订单状态为未发货
    @Transactional
    @Modifying
    @Query(value = "update store_order set order_state=:orderState where order_id=:orderId",nativeQuery=true)
    int saveOrderState(@Param("orderId")String orderId, @Param("orderState")String orderState);

    // 根据订单id删除订单
    void deleteByOrderId(String orderId);

    // 根据订单id查找订单
    StoreOrder findByOrderId(String orderId);
}
