package com.hyzg.mapper;

import com.hyzg.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther:
 * @Date:
 * @Description:
 */
public interface UserMapper extends Mapper<User> {

     @Select("SELECT id,name,password,role_id,perms from tb_admin WHERE `name` = #{name}")
     User findByName(String name);
     @Select("SELECT id,name,password,perms FROM tb_admin WHERE id = #{id} ")
     User findById(Integer id);
}
