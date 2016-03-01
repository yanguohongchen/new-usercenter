package com.sea.user.entity;


/**
 * 
 * @author sea
 *
 */
public class UserEntity
{
	/**
	 * 用戶id
	 */
	private long id;

	/**
	 * 用戶名
	 */
	private String userName;

	/**
	 * 密碼
	 */
	private String password;

	/**
	 * 用户状态
	 */
	private int userStatus;

	/**
	 * 用戶角色
	 */
	private String roles;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(int userStatus)
	{
		this.userStatus = userStatus;
	}

	public String getRoles()
	{
		return roles;
	}

	public void setRoles(String roles)
	{
		this.roles = roles;
	}

	
}
