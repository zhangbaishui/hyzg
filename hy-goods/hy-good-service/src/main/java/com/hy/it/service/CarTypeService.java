package com.hy.it.service;

import com.hy.it.mapper.CarTypeMapper;
import com.hy.it.pojo.Cartype;
import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarTypeService {
    @Autowired
    private CarTypeMapper carTypeMapper;
    public Long select(Cartype cartype) {
        System.out.println("===="+cartype);
        Long cartype1 = carTypeMapper.selectIdByCartype(cartype.getCar_type());
        System.out.println("--------------------------"+cartype1);
        if(cartype1 == null){
            throw new HyzgException(ExceptionEnums.CARTYPE_NOT_FOUND);
        }
        return cartype1;
    }
}
