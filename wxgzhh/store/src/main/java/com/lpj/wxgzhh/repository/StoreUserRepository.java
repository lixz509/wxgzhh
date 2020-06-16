package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreUser;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface StoreUserRepository extends JpaRepository<StoreUser, String> {

    // 根据用户id查询用户信息
    StoreUser findByUserId(@Param("userId")String userId);

    // 根据用户id，用户新余额，修改用户余额
    @Transactional
    @Modifying
    @Query(value = "update store_user set balance=:balance where user_id=:userId",nativeQuery=true)
    int saveBalance(@Param("userId")String userId, @Param("balance")String balance);

    // 根据用户id，用户名，地区，修改相应信息
    @Transactional
    @Modifying
    @Query(value = "update store_user set user_name =:userName,location=:location where user_id=:userId",nativeQuery=true)
    int saveUsernameAndLocation(@Param("userId")String userId,@Param("userName")String userName,@Param("location")String location);

    // 根据传入用户id，新的地址，修改地址
    @Transactional
    @Modifying
    @Query(value = "update store_user set address =:address where user_id=:userId",nativeQuery=true)
    int saveAddress(@Param("userId")String userId,@Param("address")String address);

    // 根据传用户id，密码，修改密码
    @Transactional
    @Modifying
    @Query(value = "update store_user set password =:password where user_id=:userId",nativeQuery=true)
    int savePassword(@Param("userId")String userId,@Param("password")String password);
}
