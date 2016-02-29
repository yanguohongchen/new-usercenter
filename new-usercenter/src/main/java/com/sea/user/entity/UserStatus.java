package com.sea.user.entity;

/**
 * 
 * @author sea
 *
 */
public enum UserStatus
{
	/**
	 * 被删除的
	 */
	DELETED(0),
	/**
	 * 正常
	 */
	NORMAL(1);

	private int status;

	UserStatus(int status)
	{
		this.status = status;
	}

	public int getInt()
	{
		return this.status;
	}

	public static UserStatus getStatus(int status)
	{
		switch (status)
		{
		case 0:

			return UserStatus.DELETED;
		case 1:
			return UserStatus.NORMAL;
		default:
			return null;
		}

	}

	@Override
	public String toString()
	{
		return String.valueOf(this.status);
	}

}
