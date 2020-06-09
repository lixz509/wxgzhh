package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface StoreUserRepository extends JpaRepository<StoreUser, String> {

    // 根据用户id查询用户信息
    StoreUser findByUserId(String userId);

    // 根据用户id，用户新余额，修改用户余额
    @Transactional
    @Modifying
    @Query(value = "update store_user set balance=:balance where user_id=:userId",nativeQuery=true)
    int saveBalance(String userId,String balance);
}
