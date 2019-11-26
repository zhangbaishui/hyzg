package com.hy.it.mapper;


import com.hy.it.pojo.GoodsKind;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsKindMapper extends Mapper<GoodsKind> {
    @Select("select id from tb_goods_kind where kind = #{name}")
    Long selectIdBykindname(String name);
}
