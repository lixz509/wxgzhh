package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreHotSale;
import com.lpj.wxgzhh.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Srping Data JPA 会自动生成此接口的实例，程序员不需要写实现类，实现的原理是动态代理技术
// 继承JpaRepository可以得到几乎所有的CRUD方法
// <User, String>前者表示管理哪个类的数据（对应那个表）,后者表示主键的数据类型
public interface HotSaleRepository extends JpaRepository<StoreHotSale, String> {
//    ArrayList<StoreHotSale> findAll();
//    ArrayList<StoreHotSale> findByHotSaleId(String a);
    ArrayList<StoreHotSale> findByHotSaleState(StoreHotSale.hotSaleState hotSaleState);
}
