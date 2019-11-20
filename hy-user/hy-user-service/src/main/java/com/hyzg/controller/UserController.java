package com.hyzg.controller;//

import com.hyzg.pojo.User;
import com.hyzg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> text(){
        return userService.text();
    }

    //完成登录功能，需要通过手机号码验证
    @PostMapping("/login")
    private ResponseEntity<User> login(String username, String  password){
        User user = userService.login(username,password);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //完成注册功能，需要验证码通过才行
    @PostMapping("/register")
    private ResponseEntity<Void> register(User user,@RequestParam("code")String code){
        userService.register(user, code);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
