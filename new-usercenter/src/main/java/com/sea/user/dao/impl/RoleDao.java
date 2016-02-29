package com.sea.user.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.sea.dao.impl.BaseDao;
import com.sea.user.dao.IRoleDao;
import com.sea.user.entity.RoleEntity;
import com.sea.user.entity.UserEntity;

@Component
public class RoleDao extends BaseDao<RoleEntity> implements IRoleDao
{
	@Override
	public List<RoleEntity> getUserRole(long userId)
	{

		String sqlStr = "select roleId,roleName,roleStatus from role inner join user_role on role.id = user_role.userId  where role.id=? and role.roleStatus = 0";
		List<RoleEntity> roleList = jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<RoleEntity>(RoleEntity.class), new Object[] { userId });
		return roleList;
	}

	public List<UserEntity> getUserEntityList(long userName)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userName=?";

		List<UserEntity> userEntityList = jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class),
				new Object[] { userName });
		return userEntityList;
	}
}
