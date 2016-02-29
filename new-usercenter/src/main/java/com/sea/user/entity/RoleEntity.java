package com.sea.user.entity;

/**
 * @author sea
 */
public class RoleEntity
{

	private long roleId;

	private String roleName;

	private int roleStatus;

	public long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(long roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public int getRoleStatus()
	{
		return roleStatus;
	}

	public void setRoleStatus(int roleStatus)
	{
		this.roleStatus = roleStatus;
	}

}
