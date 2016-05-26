package com.uu.web.service;

import java.util.List;

import com.uu.web.entity.Permission;
import com.uu.web.entity.Role;
import com.uu.web.entity.User;

public interface IUserService
{
	public User login(String username, String password);
	public List<Role> getRole(String username);
	public List<Permission> getPermissionByUser(String username);
	public List<Permission> getPermissionByRole(String roleID);
}
