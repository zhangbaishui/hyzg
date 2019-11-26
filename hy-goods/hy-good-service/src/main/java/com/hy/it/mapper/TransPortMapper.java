package com.hy.it.mapper;

import com.hy.it.pojo.TransPort;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TransPortMapper extends Mapper<TransPort> {
    @Select("select id from tb_transport where name = #{name}")
    Long selectIdByname(String name);
}
