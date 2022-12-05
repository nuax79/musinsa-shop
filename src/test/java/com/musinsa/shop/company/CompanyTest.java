package com.musinsa.shop.company;


import com.musinsa.shop.domain.company.Company;
import com.musinsa.shop.repository.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CompanyTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @Order(1)
    @DisplayName("Company List")
    void getCompanyList(){

        List<Company> companyList = companyRepository.findAll();
        assertNotNull(companyList);
    }

    @Test
    @Order(2)
    @DisplayName("Company Detail")
    void getCompanyDetail(){

        long companyNo = 1;

        Company company = companyRepository.findById(companyNo).get();
        assertNotNull(company);
    }

}
