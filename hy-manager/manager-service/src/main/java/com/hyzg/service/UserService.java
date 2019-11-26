package com.hyzg.service;

import com.hyzg.domain.User;
import com.hyzg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:
 * @Date:
 * @Description:
 */
@Service
public class UserService {

     @Autowired
     private UserMapper userMapper;

     public User findByName(String name){
          User user = userMapper.findByName(name);
          System.out.println("service里面--user:"+user);
          return user;
     }

     public User findById(Integer id){
          User user = userMapper.findById(id);
          System.out.println("user-通过id找user:"+user);
          return user;
     }
}
