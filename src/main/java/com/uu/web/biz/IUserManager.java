package com.uu.web.biz;

import java.util.List;

import com.uu.web.entity.Permission;
import com.uu.web.entity.Role;
import com.uu.web.entity.User;

public interface IUserManager
{
	public User getUser(String username);
	public List<Role> getRole(String username);
	public List<Permission> getPermissionByUser(String username);
	public List<Permission> getPermissionByRole(String roleTag);
}
