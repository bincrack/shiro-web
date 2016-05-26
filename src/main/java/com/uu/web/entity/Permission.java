package com.uu.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAS_Permission")
public class Permission extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String tag;	// 权限标识
	@Column
	private String name; // 权限名称

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
