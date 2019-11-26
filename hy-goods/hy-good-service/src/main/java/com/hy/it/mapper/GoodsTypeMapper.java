package com.hy.it.mapper;

import com.hy.it.pojo.GoodsType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsTypeMapper extends Mapper<GoodsType> {
    @Select("select id from tb_goods_type where name = #{name}")
    Long selectIdBytype(String name);
}
