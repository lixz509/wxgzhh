package com.lpj.wxgzhh.repository;


import com.lpj.wxgzhh.domain.StoreClassify;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClassifyRepository extends JpaRepository<StoreClassify, String> {
    // 查询所有分类
    ArrayList<StoreClassify> findAll();

    // 根据分类id查询分类
    StoreClassify findByClassifyId(@Param("classifyId")String classifyId);
}
