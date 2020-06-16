package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreCommodity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommodityRepository extends JpaRepository<StoreCommodity, String> {

    StoreCommodity findByCommodityId(String CommodityId);

    // 搜索出商品月销售量前三的商品信息
    // nativeQuery=true表示使用sql原生语句不使用hql
    @Query(value = "select * from store_commodity  order by CAST(monthly_sales as SIGNED) desc limit 3", nativeQuery=true)
    ArrayList<StoreCommodity> findBySales();

    // 根据商品名模糊查询并按销量排序
    @Query(value = "SELECT * from store_commodity WHERE commodity_name LIKE CONCAT('%',:commodityName,'%') order by  " +
            "CAST(monthly_sales as SIGNED) DESC",nativeQuery=true)
    ArrayList<StoreCommodity> findByNameSales(@Param("commodityName")String commodityName);

    // 根据商品名模糊查询并按价格升序
    @Query(value = "SELECT * from store_commodity WHERE commodity_name LIKE CONCAT('%',:commodityName,'%') order by  " +
            "CAST(price as SIGNED) ASC",nativeQuery=true)
    ArrayList<StoreCommodity> findByNamePriceAsc(@Param("commodityName")String commodityName);

    // 根据商品名模糊查询并按价格降序
    @Query(value = "SELECT * from store_commodity WHERE commodity_name LIKE CONCAT('%',:commodityName,'%') order by  " +
            "CAST(price as SIGNED) DESC",nativeQuery=true)
    ArrayList<StoreCommodity> findByNamePriceDesc(@Param("commodityName")String commodityName);

    // 根据商品类型搜索商品并按销量排序
    @Query(value = "SELECT * from store_commodity WHERE classify_id =:classifyId order by  " +
            "CAST(monthly_sales as SIGNED) DESC",nativeQuery=true)
    ArrayList<StoreCommodity> findByClassifyIdSales(@Param("classifyId")String classifyId);

    // 根据商品类型搜索商品并按价格升序
    @Query(value = "SELECT * from store_commodity WHERE classify_id =:classifyId order by CAST(price as SIGNED) ASC",nativeQuery=true)
    ArrayList<StoreCommodity> findByClassifyIdPriceAsc(@Param("classifyId")String classifyId);

    // 根据商品类型搜索商品并按价格降序
    @Query(value = "SELECT * from store_commodity WHERE classify_id =:classifyId order by CAST(price as SIGNED) DESC",nativeQuery=true)
    ArrayList<StoreCommodity> findByClassifyIdPriceDesc(@Param("classifyId")String classifyId);
}
