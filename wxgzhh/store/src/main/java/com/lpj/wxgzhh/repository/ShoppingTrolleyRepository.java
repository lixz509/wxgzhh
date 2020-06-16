package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreShoppingTrolley;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface ShoppingTrolleyRepository extends JpaRepository<StoreShoppingTrolley, String> {

    // 根据用户id查询购物车信息
    @Query(value = "SELECT * FROM wxgzhh.store_shopping_trolley where user_id=:userId", nativeQuery=true)
    ArrayList<StoreShoppingTrolley> findShoppingTrolleyByUserId(@Param("userId")String userId);

    // 根据购物车id，数量，修改该购物信息数量
    @Transactional
    @Modifying
    @Query(value = "update store_shopping_trolley set purchase_quantity=:num where shopping_trolley_id=:shoppingTrolleyId",
            nativeQuery=true)
    int saveShoppingTrolleyNumById(@Param("shoppingTrolleyId")String shoppingTrolleyId,@Param("num")String num);

    // 根据购物车id查询信息
    StoreShoppingTrolley findByShoppingTrolleyId(@Param("shoppingTrolleyId")String shoppingTrolleyId);

    // 根据购物车id删除购物车信息
    @Transactional
    @Modifying
    @Query(value = "delete from store_shopping_trolley WHERE shopping_trolley_id=:shoppingTrolleyId",nativeQuery=true)
    int deleteByShoppingTrolleyId(@Param("shoppingTrolleyId")String shoppingTrolleyId);

    // 根据用户id及商品id查询购物车信息
    @Query(value = "SELECT * FROM wxgzhh.store_shopping_trolley where user_id=:userId and " +
            "commodity_id=:commodityId limit 1",nativeQuery=true)
    StoreShoppingTrolley findByUserIdAndCommodityId(@Param("userId")String userId,@Param("commodityId")String commodityId);

    // 添加购物车
    <S extends StoreShoppingTrolley> S save(S entity);

}
