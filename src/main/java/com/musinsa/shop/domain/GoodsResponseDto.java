package com.musinsa.shop.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GoodsResponseDto {

    private Integer goodNo;

    private String goodsNm;

    private String description;

    private String comId;

    private LocalDateTime regDm;

    private LocalDateTime updDm;

    public GoodsResponseDto(Goods entity){
        this.goodNo = entity.getGoodsNo();
        this.goodsNm = entity.getGoodsNm();
        this.description = entity.getDescription();
        this.comId = entity.getComId();
        this.regDm = entity.getRegDm();
        this.updDm = entity.getUpdDm();
    }
}
