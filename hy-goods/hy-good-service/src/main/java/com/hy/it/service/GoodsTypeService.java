package com.hy.it.service;

import com.hy.it.mapper.GoodsTypeMapper;
import com.hy.it.pojo.GoodsType;
import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    public Long select(GoodsType goodsType) {
        System.out.println("==================="+goodsType);
        Long typeid = goodsTypeMapper.selectIdBytype(goodsType.getName());
        if (typeid == null){
            throw new HyzgException(ExceptionEnums.GOODSTYPE_NOT_FOUND);
        }
        return typeid;
    }
}
