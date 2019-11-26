package com.hy.it.service;

import com.hy.it.mapper.GoodsKindMapper;
import com.hy.it.pojo.GoodsKind;
import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsKindService {
    @Autowired
    private GoodsKindMapper goodsKindMapper;
    public Long select(GoodsKind goodsKind) {
        System.out.println(goodsKind);
        Long goodskindid = goodsKindMapper.selectIdBykindname(goodsKind.getName());
        if(goodskindid == null){
            throw new HyzgException(ExceptionEnums.GOODSKIND_NOT_FOUND);
        }
        return goodskindid;
    }
}
