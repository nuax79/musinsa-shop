package com.musinsa.shop.domain.company;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyRequestDto {

    private String comId;

    private int comType;


    public Company toEntity(){
        return Company.builder()
                .comId(comId)
                .comType(comType)
                .build();
    }
}
