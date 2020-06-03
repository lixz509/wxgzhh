package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreUserRepository extends JpaRepository<StoreUser, String> {

    StoreUser findByUserId(String userId);
}
