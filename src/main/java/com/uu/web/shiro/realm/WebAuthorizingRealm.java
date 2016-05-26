package com.uu.web.shiro.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.uu.web.entity.Permission;
import com.uu.web.entity.Role;
import com.uu.web.entity.User;
import com.uu.web.service.IUserService;

public class WebAuthorizingRealm extends AuthorizingRealm
{
	@Autowired
	private IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		String username = (String) principals.getPrimaryPrincipal();
		List<Role> roleList = userService.getRole(username);
		List<Permission> permissionList = userService.getPermissionByUser(username);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		for (Role role : roleList)
		{
			info.addRole(role.getTag());
		}
		
		for (Permission permission : permissionList)
		{
			info.addStringPermission(permission.getTag());
		}
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken args) throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) args;
		String username = token.getUsername();
		String password = new String(token.getPassword());
		User user = userService.login(username, password);
		return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
	}

}
