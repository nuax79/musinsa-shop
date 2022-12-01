package com.musinsa.shop.domain.goods;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsRequestDto {

    private Integer goodsNo;

    private String goodsNm;

    private String description;

    private String comId;


    public Goods toEntity(){
        return Goods.builder()
                .goodsNo(goodsNo)
                .goodsNm(goodsNm)
                .description(description)
                .comId(comId)
                .build();
    }
}
