package com.sea.user.controter.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User_AsscessToken_Param
{
	/**
	 * 用戶名
	 */
	@NotBlank(message = "用户名不能为空！")
	@Length(min = 5, max = 25, message = "用户名必须大于5位，小于25位！")
	private String userName;

	/**
	 * 密碼
	 */
	@NotEmpty(message = "密码不能为空！")
	@Length(min = 5, max = 25, message = "密码必须大于5位，小于25位！")
	private String password;

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
	
	
}
