package com.hyzg.service;//

import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import com.hyzg.mapper.UserMapper;
import com.hyzg.mapper.UserMessagerMapper;
import com.hyzg.pojo.User;
import com.hyzg.utils.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//                       .::::.
//                     .::::::::.
//                    ::::::::::: 
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMessagerMapper userMessagerMapper;

    public List<User> text(){
        return  userMapper.selectAll();
    }

    public User login(String username, String password) {
        User u = new User();
        u.setUsername(username);
        User user = userMapper.selectOne(u);
        String md5HexPassword = CodecUtils.md5Hex(password, user.getSort());
        if (user==null){
            throw new HyzgException(ExceptionEnums.USER_NOT_EXIST);
        }
        if (md5HexPassword.equals(user.getPassword())){
            throw  new HyzgException(ExceptionEnums.PASS_NOT_RIGHT);
        }
        return  user;
    }

    public void register(User user, String code) {

    }
}
