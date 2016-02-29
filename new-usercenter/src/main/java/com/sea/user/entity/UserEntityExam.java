package com.sea.user.entity;


/**
 * 
 * @author sea
 *
 */
public class UserEntityExam
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
	private int userStatus;

	/**
	 * 用戶角色
	 */
	private int role;

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

	public int getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(int userStatus)
	{
		this.userStatus = userStatus;
	}

	public int getRole()
	{
		return role;
	}

	public void setRole(int role)
	{
		this.role = role;
	}

}
