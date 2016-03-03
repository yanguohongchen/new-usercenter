package com.sea.user.controter;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sea.exception.BusinessException;
import com.sea.framework.MsgResult;
import com.sea.framework.TokenUtil;
import com.sea.user.controter.param.User_AsscessToken_Param;
import com.sea.user.service.ITokenService;
import com.sea.user.service.IUserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController
{

	@Autowired
	private ITokenService tokenService;

	@Autowired
	private IUserService userService;

	@RequestMapping("/asscessToken")
	@ResponseBody
	public MsgResult asscessToken(HttpServletRequest request,@Valid User_AsscessToken_Param param) throws BusinessException
	{
		TokenUtil.clientValidator(request);
		userService.login(param.getUserName(), param.getPassword());
		String token = tokenService.createToken(param.getUserName());
		return new MsgResult(token);
	}

}
