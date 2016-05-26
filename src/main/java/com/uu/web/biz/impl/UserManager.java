package com.uu.web.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.uu.web.biz.IUserManager;
import com.uu.web.entity.Permission;
import com.uu.web.entity.Role;
import com.uu.web.entity.RolePermission;
import com.uu.web.entity.User;
import com.uu.web.entity.UserRole;

@Component
public class UserManager extends BaseManager implements IUserManager
{
	@Override
	public User getUser(String username)
	{
		return (User) getSession().get(User.class, username);
	}

	@Override
	public List<Role> getRole(String username)
	{
		Session session = getSession();
		List<String> roleList = new ArrayList<String>();
		List<UserRole> userRoleList = session.createCriteria(UserRole.class).add(Restrictions.eq("username", username)).list();
		for (UserRole userRole : userRoleList)
		{
			roleList.add(userRole.getRoleID());
		}

		return session.createCriteria(Role.class).add(Restrictions.in("tag", roleList)).list();
	}

	@Override
	public List<Permission> getPermissionByUser(String username)
	{
		Session session = getSession();
		List<String> roleList = new ArrayList<String>();
		List<UserRole> userRoleList = session.createCriteria(UserRole.class).add(Restrictions.eq("username", username)).list();
		for (UserRole userRole : userRoleList)
		{
			roleList.add(userRole.getRoleID());
		}

		List<String> permissionList = new ArrayList<String>();
		List<RolePermission> rolePermissionList = session.createCriteria(RolePermission.class).add(Restrictions.in("roleID", roleList)).list();
		for (RolePermission rolePermission : rolePermissionList)
		{
			permissionList.add(rolePermission.getPermissionID());
		}

		return session.createCriteria(Permission.class).add(Restrictions.in("tag", permissionList)).list();
	}

	@Override
	public List<Permission> getPermissionByRole(String roleTag)
	{
		return getSession().createCriteria(Permission.class).add(Restrictions.eq("tag", roleTag)).list();
	}
}
