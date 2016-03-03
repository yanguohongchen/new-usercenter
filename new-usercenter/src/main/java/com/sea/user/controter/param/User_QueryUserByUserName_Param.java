package com.sea.user.controter.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User_QueryUserByUserName_Param
{

	/**
	 * 用戶名
	 */
	@NotBlank(message = "用户名不能为空！")
	@Length(min = 5, max = 25, message = "用户名必须大于5位，小于25位！")
	private String userName;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

}
