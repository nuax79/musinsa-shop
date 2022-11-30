package com.musinsa.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Goods {

    @Id
    private Integer goodsNo;

    private String goodsNm;

    private String description;

    private String comId;

    private LocalDateTime regDm = LocalDateTime.now();

    private LocalDateTime updDm;

    @Builder
    public Goods(Integer goodsNo, String goodsNm, String description, String comId){
        this.goodsNo = goodsNo;
        this.goodsNm = goodsNm;
        this.description = description;
        this.comId = comId;
    }

    public void update(String goodsNm, String description, String comId){
        this.goodsNm = goodsNm;
        this.description = description;
        this.comId = comId;
        this.updDm = LocalDateTime.now();
    }
}
