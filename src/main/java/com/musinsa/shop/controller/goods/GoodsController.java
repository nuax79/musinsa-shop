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


    /**
     * 상품 등록
     * @return
     */
    @PostMapping
    public Integer save(@RequestBody final GoodsRequestDto params){
        return goodsService.save(params);
    }

    /**
     * 상품 List 조회
     * @return
     */
    @GetMapping
    public List<GoodsResponseDto> findAll(){
        return goodsService.findAll();
    }

    /**
     * 상품 수정
     * @param goodsNo Integer
     * @param params GoodsRequestDto
     * @return
     */
    @PutMapping("/{goodsNo}")
    public Integer update(@PathVariable final Integer goodsNo, @RequestBody final GoodsRequestDto params){
        return goodsService.update(goodsNo, params);
    }

    /**
     * 상품 단건 조회
     * @param goodsNo Integer
     * @return
     */
    @GetMapping("/{goodsNo}")
    public GoodsResponseDto findById(@PathVariable final Integer goodsNo){
        return goodsService.findById(goodsNo);
    }

    /**
     * 상품 삭제
     * @param goodsNo Integer
     * @return
     */
    @DeleteMapping("/{goodsNo}")
    public GoodsResponseDto delete(@PathVariable final Integer goodsNo){
        return goodsService.delete(goodsNo);
    }
}
