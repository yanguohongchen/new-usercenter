package com.sea.user.dao;

import com.sea.dao.impl.IBaseDao;
import com.sea.user.entity.UserEntity;

public interface IUserDao extends IBaseDao<UserEntity>
{

	void saveUserEntity(UserEntity user);

	UserEntity getUserEntityByUserId(long userId);

	/**
	 * 根据用户名和密码获取用户信息
	 * 
	 * @param userName
	 * @param passwd
	 * @return
	 */
	UserEntity getUserEntityByUserNameAndPasswd(String userName, String passwd);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	void updateUser(UserEntity user);

	/**
	 * 通过用户名获取用户实例
	 * @param userName
	 * @return
	 */
	UserEntity getUserEntity(String userName);
}
