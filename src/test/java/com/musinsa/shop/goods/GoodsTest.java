package com.musinsa.shop.goods;


import com.musinsa.shop.domain.goods.Goods;
import com.musinsa.shop.repository.GoodsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoodsTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    @Order(1)
    @DisplayName("Goods Regist")
    void registGoods(){

        Integer goodsNo = 4;
        String goodsNm = "프리미어 퓨어 울 발마칸 코트 [MELANGE TAUPE]";
        String comId = "MUSINSA";

        Goods params = Goods.builder()
                .goodsNo(goodsNo)
                .goodsNm(goodsNm)
                .comId(comId)
                .build();

        goodsRepository.save(params);

        Goods goods = goodsRepository.findById(goodsNo).get();
        assertThat(goods.getGoodsNo()).isEqualTo(goodsNo);
        assertThat(goods.getGoodsNm()).isEqualTo(goodsNm);
        assertThat(goods.getComId()).isEqualTo(comId);

    }

    @Test
    @Order(2)
    @DisplayName("Goods List")
    void getGoodsList(){

        List<Goods> goodsList = goodsRepository.findAll();
        assertNotNull(goodsList);
    }

    @Test
    @Order(3)
    @DisplayName("Goods Detail")
    void goodsDetail(){

        Integer goodsNo = 3;

        Goods goods = goodsRepository.findById(goodsNo).get();
        assertNotNull(goods);
    }

    @Test
    @Order(4)
    @DisplayName("Goods Update")
    void updateGoods(){

        Integer goodsNo = 2;
        String goodsNm = "프리미어 퓨어 울 발마칸 코트 [MELANGE TAUPE]";
        String description = "22 F/W 시즌, 절제된 유려함을 웨어러블하게 표현한 컬렉션을 선보입니다.";
        String comId = "MUSINSA";

        Goods goods = goodsRepository.findById(goodsNo).get();

        goods.update(goodsNm, description, comId);

        assertThat(goods.getGoodsNo()).isEqualTo(goodsNo);
        assertThat(goods.getGoodsNm()).isEqualTo(goodsNm);
        assertThat(goods.getDescription()).isEqualTo(description);
        assertThat(goods.getComId()).isEqualTo(comId);

    }

    @Test
    @Order(5)
    @DisplayName("Goods Delete")
    void deleteGoods(){

        Integer goodsNo = 1;
        Goods goods = goodsRepository.findById(goodsNo).get();

        goodsRepository.delete(goods);
        assertThatThrownBy(() -> goodsRepository.findById(goodsNo).get()).isInstanceOf(NoSuchElementException.class);
    }
}
