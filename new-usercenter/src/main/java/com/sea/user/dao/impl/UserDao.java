package com.sea.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sea.dao.impl.BaseDao;
import com.sea.user.dao.IUserDao;
import com.sea.user.entity.UserEntity;

@Component
public class UserDao extends BaseDao<UserEntity> implements IUserDao
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUserEntity(final UserEntity user)
	{
		long id = this.saveEntity(user);
		user.setId(id);
	}

	@Override
	public UserEntity getUserEntityByUserId(long userId)
	{
		return this.getEntityById("id", userId);
	}

	@Override
	public UserEntity getUserEntity(String userName)
	{
		String sqlStr = "select id,user_name,roles,user_status from user_entity where user_name=?";

		return jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), new Object[] { userName });
	}

	@Override
	public UserEntity getUserEntityByUserNameAndPasswd(String userName, String passwd)
	{
		String sqlStr = "select id,user_name,roles,user_status from user_entity where user_name=? and password = ?";

		return jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), new Object[] { userName, passwd });
	}

	public List<UserEntity> getUserEntityS(long userId)
	{
		String sqlStr = "select id,user_name,user_status from user_entity where user_status=?";

		return jdbcTemplate.query(sqlStr, new RowMapper<UserEntity>()
		{
			@Override
			public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserEntity user = new UserEntity();
				user.setId(rs.getLong("id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserStatus(rs.getInt("user_status"));
				return user;
			}
		}, new Object[] { userId });

	}

	public void updateUser(UserEntity user)
	{
		this.updateEntityById("id", user);
	}

}
