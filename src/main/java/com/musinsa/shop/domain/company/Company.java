package com.musinsa.shop.domain.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Company {

    @Id
    private Long no;

    @Column(name = "com_id")
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

    @Builder
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
