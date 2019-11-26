package com.hyzg.shiro;

import com.hyzg.domain.User;
import com.hyzg.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *自定义Realm
 */
public class UserRealm  extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject= SecurityUtils.getSubject();
        // System.out.println(Arrays.toString((char[]) subject.getPrincipal()));
        User user= (User) subject.getPrincipal();
        User dbUser =userService.findById(user.getId());

        info.addStringPermission(dbUser.getPerms());
        return info;
    }
    /**
     * 执行认证逻辑
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //假设数据库的用户名和密码

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) token1;
        User user = userService.findByName(token.getUsername());
        if (user == null) {
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }

        //2.判断密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}

