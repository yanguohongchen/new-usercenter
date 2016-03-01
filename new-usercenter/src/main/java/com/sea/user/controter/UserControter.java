package com.sea.user.controter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.framework.MsgResult;

@RestController
public class UserControter
{
	@RequestMapping("api/getUser")
	public MsgResult getUser()
	{
		
//		System.out.println("getUser");
		return new MsgResult();
		
	}

}
