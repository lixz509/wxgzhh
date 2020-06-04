package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreShoppingTrolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingTrolleyRepository extends JpaRepository<StoreShoppingTrolley, String> {
    
}
