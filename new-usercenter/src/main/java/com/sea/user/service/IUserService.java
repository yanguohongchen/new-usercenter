package com.sea.user.service;

import com.sea.exception.BusinessException;
import com.sea.user.entity.UserEntity;

/**
 * 用戶服务
 * 
 * @author sea
 *
 */
public interface IUserService
{

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @return sessionId
	 * @throws BusinessException
	 */
	public void login(String userName, String password) throws BusinessException;

	/**
	 * 注册
	 * 
	 * @param user
	 */
	public void register(UserEntity user);

	/**
	 * 重置密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void resetPassword(long userId, String password);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @param newPassword
	 * @throws BusinessException 
	 */
	public void updatePassword(long userId, String password, String newPassword) throws BusinessException;

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserEntity getUserById(long userId);

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public UserEntity getUserByUserName(String userName);
	

	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserEntity(UserEntity user);

}
