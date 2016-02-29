package com.sea.user.dao;

import com.sea.dao.impl.IBaseDao;
import com.sea.user.entity.UserEntity;
import com.sea.user.entity.UserEntityExam;

public interface IUserDao extends IBaseDao<UserEntity>
{

	void saveUserEntity(UserEntity user);
	

	UserEntity getUserEntityByUserId(long userId);


	UserEntityExam getUserEntityExamByUserId(long userId);


	/**
	 * 根据用户名和密码获取用户信息
	 * @param userName
	 * @param passwd
	 * @return
	 */
	UserEntity getUserEntityByUserNameAndPasswd(String userName, String passwd);


	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(UserEntity user);
}
