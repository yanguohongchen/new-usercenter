package com.sea.user.entity;

import com.sea.framework.Role;

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
	private long userId;

	/**
	 * 用戶名
	 */
	private String userName;

	/**
	 * 密碼
	 */
	private String password;

	/**
	 * 手机号码
	 */
	private String mobilePhone;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 用户状态
	 */
	private UserStatus userStatus;

	/**
	 * 用戶角色
	 */
	private Role role;

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
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

	public String getMobilePhone()
	{
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public UserStatus getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus)
	{
		this.userStatus = userStatus;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

}
