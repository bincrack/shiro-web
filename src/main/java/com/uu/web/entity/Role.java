package com.uu.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAS_Role")
public class Role extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String tag; // 角色标识
	@Column
	private String name; // 角色名称

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}
}
