package com.musinsa.shop.controller.goods;

import com.musinsa.shop.domain.goods.Goods;
import com.musinsa.shop.domain.goods.GoodsRequestDto;
import com.musinsa.shop.domain.goods.GoodsResponseDto;
import com.musinsa.shop.service.goods.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${server.api.version}/goods")
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
    public Integer update(@PathVariable final Integer goodsNo, @RequestBody final GoodsRequestDto params){
        return goodsService.update(goodsNo, params);
    }

    @GetMapping("/{goodsNo}")
    public Goods findById(@PathVariable final Integer goodsNo){
        return goodsService.findById(goodsNo);
    }

    @DeleteMapping("/{goodsNo}")
    public GoodsResponseDto delete(@PathVariable final Integer goodsNo){
        return goodsService.delete(goodsNo);
    }
}
