package com.lpj.wxgzhh.repository;


import com.lpj.wxgzhh.domain.StoreClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClassifyRepository extends JpaRepository<StoreClassify, String> {
    ArrayList<StoreClassify> findAll();
}
