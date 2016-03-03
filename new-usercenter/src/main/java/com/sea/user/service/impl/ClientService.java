package com.sea.user.service.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sea.framework.RedisClusterUtil;
import com.sea.user.entity.Client;
import com.sea.user.service.IClientService;

@Service
public class ClientService implements IClientService
{

	private ConcurrentHashMap<String, String> clients = new ConcurrentHashMap<String, String>();

	// 直接预定义
	ClientService()
	{
		clients.put("PCCLIENT", "@#$SLINFHNKL@#");
		clients.put("PHONECLIENT", "@#$SDFFSDF@#");
		clients.put("OTHERCLIENT", "@#$WPAF;SFD@#");
	}

	@Autowired
	private RedisClusterUtil redisClusterUtil;

	@Override
	public Client getClient(String clientId)
	{
		String clientSecret = clients.get(clientId);
		Client client = new Client();
		client.setClientId(clientId);
		client.setClientSecret(clientSecret);
		return client;
	}
}
