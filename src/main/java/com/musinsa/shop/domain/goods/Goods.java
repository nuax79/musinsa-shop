package com.musinsa.shop.domain.goods;

import com.musinsa.shop.domain.company.Company;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "company")
@Entity
public class Goods {

    @Id
    private Integer goodsNo;

    private String goodsNm;

    private String description;

    private String comId;

    @ManyToOne(optional=false)
    @JoinColumn(name="comId", referencedColumnName="com_id", insertable=false, updatable=false)
    private Company company;

    private LocalDateTime regDm = LocalDateTime.now();

    private LocalDateTime updDm;

    @Builder
    public Goods(Integer goodsNo, String goodsNm, String description, String comId, Company company){
        this.goodsNo = goodsNo;
        this.goodsNm = goodsNm;
        this.description = description;
        this.comId = comId;
        this.company = company;
    }

    public void update(String goodsNm, String description, String comId){
        this.goodsNm = goodsNm;
        this.description = description;
        this.comId = comId;
        this.updDm = LocalDateTime.now();
    }
}
