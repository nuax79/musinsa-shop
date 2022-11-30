package com.musinsa.shop.repository;

import com.musinsa.shop.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
