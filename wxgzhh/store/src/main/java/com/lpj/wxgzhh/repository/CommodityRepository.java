package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommodityRepository extends JpaRepository<StoreCommodity, String> {
    StoreCommodity findByCommodityId(String CommodityId);

    // nativeQuery=true表示使用sql原生语句不使用hql
    @Query(value = "select * from store_commodity  order by CAST(monthly_sales as SIGNED) desc limit 3", nativeQuery=true)
    ArrayList<StoreCommodity> findBySales();
}
