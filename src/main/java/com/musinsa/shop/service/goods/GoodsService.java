package com.musinsa.shop.service.goods;

import com.musinsa.shop.domain.goods.Goods;
import com.musinsa.shop.domain.goods.GoodsRequestDto;
import com.musinsa.shop.domain.goods.GoodsResponseDto;
import com.musinsa.shop.common.exception.CustomException;
import com.musinsa.shop.common.exception.ErrorCode;
import com.musinsa.shop.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;

    /**
    * 상품 등록
    * @param params GoodsRequestDto
    */
    @Transactional
    public Integer save(final GoodsRequestDto params){

        goodsRepository.findById(params.getGoodsNo())
                .ifPresent(data -> {
                    throw new CustomException(ErrorCode.CONFLICT_GOODS);
                });

        Goods entity = goodsRepository.save(params.toEntity());

        return entity.getGoodsNo();
    }

    /**
     * 상품 LIST 조회
     * @return
     */
    @Transactional(readOnly = true)
    public List<GoodsResponseDto> findAll(){
        List<Goods> list = goodsRepository.findAllWithCompanyUsingFetchJoin();
        return list.stream().map(GoodsResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 상품 수정
     * @param goodsNo Integer
     * @param params GoodsRequestDto
     * @return
     */
    @Transactional
    public Integer update(final Integer goodsNo, final GoodsRequestDto params){
        Goods entity = goodsRepository.findById(goodsNo).orElseThrow(() -> new CustomException(ErrorCode.TARGET_NOT_FOUND));
        entity.update(params.getGoodsNm(), params.getDescription(), params.getComId());
        return goodsNo;
    }

    /**
     * 상품 단건 조회
     * @param goodsNo Integer
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsResponseDto findById(final Integer goodsNo){
        Goods entity = goodsRepository.findById(goodsNo).orElseThrow(() -> new CustomException(ErrorCode.TARGET_NOT_FOUND));
        return new GoodsResponseDto(entity);
    }

    /**
     * 상품 삭제
     * @param goodsNo Integer
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsResponseDto delete(final Integer goodsNo) {
        Goods entity = goodsRepository.findById(goodsNo).orElseThrow(() -> new CustomException(ErrorCode.TARGET_NOT_FOUND));
        goodsRepository.delete(entity);
        return new GoodsResponseDto(entity);
    }
}