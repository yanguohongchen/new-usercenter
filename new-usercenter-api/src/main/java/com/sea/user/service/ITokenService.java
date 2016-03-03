package com.sea.user.service;

public interface ITokenService
{
	String createToken(String username);

	String getToken(String username);
}
