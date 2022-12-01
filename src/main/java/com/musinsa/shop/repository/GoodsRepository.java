package com.musinsa.shop.repository;

import com.musinsa.shop.domain.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    @Query("select g from Goods g join fetch g.company")
    List<Goods> findAllWithCompanyUsingFetchJoin();
}
