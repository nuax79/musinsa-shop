package com.musinsa.shop.controller.company;

import com.musinsa.shop.domain.company.CompanyResponseDto;
import com.musinsa.shop.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/${server.api.version}/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    /**
     * 업체 LIST 조회
     * @return
     */
    @GetMapping("")
    public List<CompanyResponseDto> findAll(){
        return companyService.findAll();
    }

    /**
     * 업체 단건 조회
     * @param no
     * @return
     */
    @GetMapping("/{no}")
    public CompanyResponseDto findById(@PathVariable Long no){
        return companyService.findById(no);
    }


}
