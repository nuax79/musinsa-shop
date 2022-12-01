package com.musinsa.shop.service.company;

import com.musinsa.shop.common.exception.CustomException;
import com.musinsa.shop.common.exception.ErrorCode;
import com.musinsa.shop.domain.company.Company;
import com.musinsa.shop.domain.company.CompanyResponseDto;
import com.musinsa.shop.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<CompanyResponseDto> findAll(){
        List<Company> list = companyRepository.findAll();
        return list.stream().map(CompanyResponseDto::new).collect(Collectors.toList());
    }

    public CompanyResponseDto findById(Long no){
        Company entity = companyRepository.findById(no).orElseThrow(() -> new CustomException(ErrorCode.GOODS_NOT_FOUND));
        return new CompanyResponseDto(entity);
    }
}