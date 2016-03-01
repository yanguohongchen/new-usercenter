package com.sea.user.controter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.framework.MsgResult;
import com.sea.user.service.IUserService;

@RestController
public class UserControter
{
	@Autowired
	private IUserService UserService;

	@RequestMapping("api/getUser")
	public MsgResult getUser()
	{
		return new MsgResult();
	}

}
