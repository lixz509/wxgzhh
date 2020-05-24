package com.lpj.wxgzhh.repository;


import com.lpj.wxgzhh.domain.StoreClassify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ClassifyRepository extends JpaRepository<StoreClassify, String> {
    ArrayList<StoreClassify> findAll();
}
