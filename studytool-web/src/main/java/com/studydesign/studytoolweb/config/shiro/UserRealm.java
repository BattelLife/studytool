package com.studydesign.studytoolweb.config.shiro;

/*import com.yulintu.business.entities.entity.SysRole;
import com.yulintu.business.entities.entity.SysUser;
import com.yulintu.business.service.SysUserService;
import com.yulintu.forestage.service.UserService;*/
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
/*    @Autowired
    private SysUserService sysUserService;// = new SysUserServiceImpl();
    @Autowired
    private UserService userService;// = new UserServiceImpl();*/

    /**
     * 提供用户信息返回角色信息，权限暂时没用到
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 根据用户名查询当前用户拥有的角色
        //List<SysRole> roles = userService.findRoles(userId);
        Set<String> roleNames = new HashSet<String>();
        /*for (SysRole role : roles) {
            roleNames.add(role.getName());
        }*/
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String id = (String) token.getPrincipal();
        //SysUser user = sysUserService.get(id);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(id,id,id);
        return authenticationInfo;
    }
}