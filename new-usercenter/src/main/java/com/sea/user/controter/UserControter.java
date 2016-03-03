package com.sea.user.controter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.apidoc.Description;
import com.sea.exception.BusinessException;
import com.sea.framework.MsgResult;
import com.sea.user.controter.param.User_Login_Param;
import com.sea.user.controter.param.User_QueryUserByUserName_Param;
import com.sea.user.controter.param.User_Register_Param;
import com.sea.user.entity.UserEntity;
import com.sea.user.service.IUserService;

@RestController
public class UserControter
{
	@Autowired
	private IUserService userService;

	@Description("注册用户")
	@RequestMapping("/register")
	public MsgResult register(@Valid User_Register_Param userParam)
	{
		UserEntity user = new UserEntity();
		user.setUserName(userParam.getUserName());
		user.setPassword(userParam.getPassword());
		userService.register(user);
		return new MsgResult();
	}

	@Description("通过用户名获取用户信息")
	@RequestMapping("queryUserByUserName")
	public MsgResult queryUserByUserName(@Valid User_QueryUserByUserName_Param param)
	{
		UserEntity user = userService.getUserByUserName(param.getUserName());
		return new MsgResult(user);
	}

	@Description("登录")
	@RequestMapping("login")
//	@FireAuthority(loginStatus=LoginStatus.LOGIN,role=Role.ADMIN)
	public MsgResult login(@Valid User_Login_Param param) throws BusinessException
	{
		userService.login(param.getUserName(), param.getPassword());
		return new MsgResult();
	}

}
