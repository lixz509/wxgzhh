package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreEvaluate;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateRepository extends JpaRepository<StoreEvaluate, String> {

    // 根据商品id查询最后一条评论
    @Query(value = "select * from (select * from store_evaluate where commodity_id=:commodityId Order By evaluate_time Desc) " +
            "as t limit 1", nativeQuery=true)
    StoreEvaluate findByCommodityId(@Param("commodityId")String commodityId);


}
