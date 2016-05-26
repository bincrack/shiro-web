package com.uu.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uu.web.biz.IUserManager;
import com.uu.web.entity.Permission;
import com.uu.web.entity.Role;
import com.uu.web.entity.User;
import com.uu.web.service.IUserService;

@Component
public class UserService implements IUserService
{
	@Autowired
	private IUserManager userManager;
	
	@Override
	public User login(String username, String password)
	{
		User user = userManager.getUser(username);
		if (user == null)
			throw new RuntimeException("�û�������");
		
		if (!user.getPassword().equals(password))
			throw new RuntimeException("���벻ƥ��");
		
		return user;
	}

	@Override
	public List<Role> getRole(String username)
	{
		return userManager.getRole(username);
	}

	@Override
	public List<Permission> getPermissionByUser(String username)
	{
		return userManager.getPermissionByUser(username);
	}

	@Override
	public List<Permission> getPermissionByRole(String roleTag)
	{
		return userManager.getPermissionByRole(roleTag);
	}

}
