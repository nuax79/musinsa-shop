package com.musinsa.shop.controller.goods;

import com.musinsa.shop.domain.Goods;
import com.musinsa.shop.domain.GoodsRequestDto;
import com.musinsa.shop.domain.GoodsResponseDto;
import com.musinsa.shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping("")
    public Integer save(@RequestBody final GoodsRequestDto params){
        return goodsService.save(params);
    }

    @GetMapping("")
    public List<GoodsResponseDto> findAll(){
        return goodsService.findAll();
    }

    @PutMapping("/{goodsNo}")
    public Integer save(@PathVariable final Integer goodsNo, @RequestBody final GoodsRequestDto params){
        return goodsService.update(goodsNo, params);
    }

    @GetMapping("/{goodsNo}")
    public Goods findById(@PathVariable final Integer goodsNo){
        return goodsService.findById(goodsNo);
    }

    @DeleteMapping("/{goodsNo}")
    public void delete(@PathVariable final Integer goodsNo){
        goodsService.delete(goodsNo);
    }
}
