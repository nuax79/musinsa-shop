package com.musinsa.shop.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Company {

    @Id
    private long no;

    private String comId;

    private int comType;

    private String passwd;

    private String ceo;

    private String comNm;

    private String bizType;

    private String bizNum;

    private BigDecimal payFee;

    private String useYn;

    private LocalDateTime regDm = LocalDateTime.now();;

    private LocalDateTime updDm;

    public Company(String comId, int comType, String passwd, String ceo, String comNm, String bizType, String bizNum, BigDecimal payFee, String useYn) {
        this.comId = comId;
        this.comType = comType;
        this.passwd = passwd;
        this.ceo = ceo;
        this.comNm = comNm;
        this.bizType = bizType;
        this.bizNum = bizNum;
        this.payFee = payFee;
        this.useYn = useYn;
    }
}
