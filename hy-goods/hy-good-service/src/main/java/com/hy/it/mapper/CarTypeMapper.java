package com.hy.it.mapper;


import com.hy.it.pojo.Cartype;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface CarTypeMapper extends Mapper<Cartype> {

    @Select("select ct_id from tb_cartype where car_type = #{car_type}")
    Long selectIdByCartype(String car_type);
}
