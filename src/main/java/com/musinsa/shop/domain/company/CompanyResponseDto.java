package com.musinsa.shop.domain.company;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CompanyResponseDto {

    private String comId;

    private int comType;

    private String passwd;

    private String ceo;

    private String comNm;

    private String bizType;

    private String bizNum;

    private BigDecimal payFee;

    private String useYn;

    private LocalDateTime regDm;

    private LocalDateTime updDm;

    public CompanyResponseDto(Company entity) {
        this.comId = entity.getComId();
        this.comType = entity.getComType();
        this.passwd = entity.getPasswd();
        this.ceo = entity.getCeo();
        this.comNm = entity.getComNm();
        this.bizType = entity.getBizType();
        this.bizNum = entity.getBizNum();
        this.payFee = entity.getPayFee();
        this.useYn = entity.getUseYn();
        this.regDm = entity.getRegDm();
        this.updDm = entity.getUpdDm();
    }
}
