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
import com.sea.user.entity.UserStatus;

@Component
public class UserDao extends BaseDao<UserEntity> implements IUserDao
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUserEntity(final UserEntity user)
	{
		long id = this.saveEntity(user);
		user.setUserId(id);
	}

	@Override
	public UserEntity getUserEntityByUserId(long userId)
	{
		return this.getEntityById("userId", userId);
	}


	public List<UserEntity> getUserEntityList(long userName)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userName=?";

		return jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), new Object[] { userName });
	}

	@Override
	public UserEntity getUserEntityByUserNameAndPasswd(String userName, String passwd)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userName=? and passwd = ?";

		return jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), new Object[] { userName, passwd });
	}

	public List<UserEntity> getUserEntityS(long userId)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,userStatus from userentity where userStatus=?";

		return jdbcTemplate.query(sqlStr, new RowMapper<UserEntity>()
		{
			@Override
			public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserEntity user = new UserEntity();
				user.setUserId(rs.getLong("userId"));
				user.setUserName(rs.getString("userName"));
				user.setNickName(rs.getString("nickName"));
				user.setUserStatus(UserStatus.getStatus(rs.getInt("userStatus")));
				user.setMobilePhone(rs.getString("mobilePhone"));
				return user;
			}
		}, new Object[] { userId });

	}

	public void updateUser(UserEntity user)
	{
		this.updateEntityById("userId", user);
	}

}
