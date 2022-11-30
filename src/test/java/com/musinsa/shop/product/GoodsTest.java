package com.musinsa.shop.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.shop.domain.Goods;
import com.musinsa.shop.repository.GoodsRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {

    @Autowired
    GoodsRepository productRepository;

    @Before("goods test")
    void save(){
        Goods params = Goods.builder()
                .goodsNm("테스트 상품")
                .description("테스트 상품설명")
                .comId("테스트 회사 아이디")
                .build();


        productRepository.save(params);

        Goods entity = productRepository.findById((Integer) 5).get();
        assertThat(entity.getGoodsNm()).isEqualTo("테스트 상품");
        assertThat(entity.getDescription()).isEqualTo("테스트 상품설명");

    }

    @Test
    void findAll(){
        long goodsCount = productRepository.count();

        List<Goods> products = productRepository.findAll();
    }

    @Test
    void delete(){
        Goods product = productRepository.findById((Integer) 5).get();
        productRepository.delete(product);
    }



}
