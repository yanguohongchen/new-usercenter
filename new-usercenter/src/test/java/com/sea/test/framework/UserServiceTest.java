package com.sea.test.framework;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sea.framework.Role;
import com.sea.user.dao.IUserDao;
import com.sea.user.entity.UserEntity;
import com.sea.user.entity.UserStatus;
import com.sea.user.service.IUserService;

public class UserServiceTest extends BaseTest
{

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserDao userDao;

	@Test
	public void saveUserTest()
	{
		UserEntity user = new UserEntity();
		user.setUserName("zhangsan7");
		user.setRoles(Role.ADMIN + "," + Role.CONSUMER);
		user.setUserStatus(UserStatus.NORMAL.getInt());
		user.setPassword("1111111");
		userService.register(user);
		System.out.println(user.getId());
	}

	@Test
	public void getUserEntity()
	{
		UserEntity user = userService.getUserById(4);
		System.out.println(user.getUserName());
	}

}
