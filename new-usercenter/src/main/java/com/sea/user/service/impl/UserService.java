package com.sea.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sea.exception.BusinessException;
import com.sea.user.dao.IUserDao;
import com.sea.user.entity.UserEntity;
import com.sea.user.service.IUserService;

@Service
public class UserService implements IUserService
{
	@Autowired
	private IUserDao userDao;

	public void login(String userName, String password) throws BusinessException
	{
		UserEntity user = userDao.getUserEntityByUserNameAndPasswd(userName, password);
		if (user == null)
		{
			throw new BusinessException("用户名或者密码不存在！");
		}
	}

	public void register(UserEntity user)
	{
		userDao.saveUserEntity(user);
	}

	public void resetPassword(long userId, String password)
	{
		UserEntity user = userDao.getUserEntityByUserId(userId);
		user.setPassword(password);
		userDao.updateUser(user);
	}

	public void updatePassword(long userId, String password, String newPassword) throws BusinessException
	{
		UserEntity user = userDao.getUserEntityByUserId(userId);
		if (!user.getPassword().equals(password))
		{
			throw new BusinessException("密码不对!");
		}
		user.setPassword(newPassword);
		userDao.updateUser(user);
	}

	public UserEntity getUserById(long userId)
	{
		return userDao.getUserEntityByUserId(userId);
	}

	public UserEntity getUserByUserName(String userName)
	{
		return userDao.getUserEntity(userName);
	}

	@Override
	public void updateUserEntity(UserEntity user)
	{
		userDao.updateUser(user);
	}

}
