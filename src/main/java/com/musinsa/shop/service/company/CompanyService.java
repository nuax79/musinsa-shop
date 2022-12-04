package com.musinsa.shop.service.company;

import com.musinsa.shop.common.exception.CustomException;
import com.musinsa.shop.common.exception.ErrorCode;
import com.musinsa.shop.domain.company.Company;
import com.musinsa.shop.domain.company.CompanyResponseDto;
import com.musinsa.shop.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;


    /**
     * 업체 LIST 조회
     * @return
     */
    @Transactional(readOnly = true)
    public List<CompanyResponseDto> findAll(){
        List<Company> list = companyRepository.findAll();
        return list.stream().map(CompanyResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 업체 단건 조회
     * @param no
     * @return
     */
    @Transactional(readOnly = true)
    public CompanyResponseDto findById(Long no){
        Company entity = companyRepository.findById(no).orElseThrow(() -> new CustomException(ErrorCode.TARGET_NOT_FOUND));
        return new CompanyResponseDto(entity);
    }
}