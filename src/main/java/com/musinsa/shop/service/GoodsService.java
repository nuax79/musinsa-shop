package com.musinsa.shop.service;

import com.musinsa.shop.domain.Goods;
import com.musinsa.shop.domain.GoodsRequestDto;
import com.musinsa.shop.domain.GoodsResponseDto;
import com.musinsa.shop.common.exception.CustomException;
import com.musinsa.shop.common.exception.ErrorCode;
import com.musinsa.shop.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;

    @Transactional
    public Integer save(final GoodsRequestDto params){

        goodsRepository.findById(params.getGoodsNo())
                .ifPresent(data -> {
                    throw new CustomException(ErrorCode.CONFLICT_GOODS);
                });

        Goods entity = goodsRepository.save(params.toEntity());

        return entity.getGoodsNo();
    }

    public List<GoodsResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "goodsNo");
        List<Goods> list = goodsRepository.findAll(sort);
        return list.stream().map(GoodsResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Integer update(final Integer goodsNo, final GoodsRequestDto params){
        Goods entity = goodsRepository.findById(goodsNo).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));

        //TODO comId 존재하는 코드인지 조회 해야함
        entity.update(params.getGoodsNo(), params.getGoodsNm(), params.getDescription(), params.getComId());
        return goodsNo;
    }

    public Goods findById(final Integer goodsNo){
        Goods entity = goodsRepository.findById(goodsNo).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        return entity;
    }

    public void delete(final Integer goodsNo) {
        Goods entity = goodsRepository.findById(goodsNo)
                .orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));

        goodsRepository.delete(entity);
    }


}
