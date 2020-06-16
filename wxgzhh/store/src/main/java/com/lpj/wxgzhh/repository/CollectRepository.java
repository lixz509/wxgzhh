package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.StoreCollect;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface CollectRepository extends JpaRepository<StoreCollect, String> {

    // 根据用户id及商品id查询收藏信息
    @Query(value = "SELECT * FROM store_collect where user_id=:userId and commodity_id=:commodityId limit 1",nativeQuery=true)
    StoreCollect findByUserIdAndCommodityId(@Param("userId")String userId, @Param("commodityId")String commodityId);

    // 增加收藏
    <S extends StoreCollect> S save(S entity);

    // 根据用户id，商品id删除收藏
    @Transactional
    @Modifying
    @Query(value = "delete from store_collect WHERE user_id=:userId and commodity_id=:commodityId",nativeQuery=true)
    int deleteByUserIdAndCommodityId(@Param("userId")String userId,@Param("commodityId")String commodityId);

    // 根据用户id，查询收藏
    ArrayList<StoreCollect> findByUserId(@Param("userId")String userId);

}
