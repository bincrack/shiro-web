package com.uu.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAS_RolePermission")
public class RolePermission extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String roleID; // 角色标识
	@Column
	private String permissionID; // 权限标识

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getRoleID()
	{
		return roleID;
	}

	public void setRoleID(String roleID)
	{
		this.roleID = roleID;
	}

	public String getPermissionID()
	{
		return permissionID;
	}

	public void setPermissionID(String permissionID)
	{
		this.permissionID = permissionID;
	}

}
