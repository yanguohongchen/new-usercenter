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
import com.sea.user.entity.UserEntityExam;
import com.sea.user.entity.UserStatus;

@Component
public class UserDao extends BaseDao<UserEntity> implements IUserDao
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUserEntity(final UserEntity user)
	{
		// final String sqlStr =
		// "insert into userentity (userName,password,mobilePhone,nickName,userStatus,role) values(?,?,?,?,?,?)";
		// KeyHolder keyHolder = new GeneratedKeyHolder();
		// PreparedStatementCreator psc = new
		// SimplePreparedStatementCreator(sqlStr, new Object[] {
		// user.getUserName(), user.getPassword(),
		// user.getMobilePhone(), user.getNickName(),
		// user.getUserStatus().getInt(), user.getRole().getRoleId() });
		// jdbcTemplate.update(psc, keyHolder);
		// user.setUserId(keyHolder.getKey().longValue());
		long id = this.saveEntity(user);
		user.setUserId(id);
	}

	// public void saveEntity2(final UserEntity user)
	// {
	// final String sqlStr =
	// "insert into userentity (userName,password,mobilePhone,nickName,userStatus,role) values(?,?,?,?,?,?)";
	// KeyHolder keyHolder = new GeneratedKeyHolder();
	// PreparedStatementCreator psc = new PreparedStatementCreator()
	// {
	// @Override
	// public PreparedStatement createPreparedStatement(Connection con) throws
	// SQLException
	// {
	// PreparedStatement ps = con.prepareStatement(sqlStr,
	// Statement.RETURN_GENERATED_KEYS);
	// ps.setObject(1, user.getUserName());
	// ps.setObject(2, user.getPassword());
	// ps.setObject(3, user.getMobilePhone());
	// ps.setObject(4, user.getNickName());
	// ps.setObject(5, user.getUserStatus().getInt());
	// ps.setObject(6, user.getRole().getRoleId());
	// return ps;
	// }
	//
	// };
	// jdbcTemplate.update(psc, keyHolder);
	// user.setUserId(keyHolder.getKey().longValue());
	// }

	@Override
	public UserEntity getUserEntityByUserId(long userId)
	{
		// String sqlStr =
		// "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userId=?";
		//
		// UserEntity userEntity = jdbcTemplate.queryForObject(sqlStr, new
		// RowMapper<UserEntity>()
		// {
		// @Override
		// public UserEntity mapRow(ResultSet rs, int rowNum) throws
		// SQLException
		// {
		// UserEntity user = new UserEntity();
		// user.setUserId(rs.getLong("userId"));
		// user.setUserName(rs.getString("userName"));
		// user.setNickName(rs.getString("nickName"));
		// user.setUserStatus(UserStatus.getStatus(rs.getInt("userStatus")));
		// user.setRole(Role.getRole(rs.getInt("role")));
		// user.setMobilePhone(rs.getString("mobilePhone"));
		// return user;
		// }
		// }, new Object[] { userId });

		return this.getEntityById("userId", userId);

		// return userEntity;
	}

	public UserEntityExam getUserEntityExamByUserId(long userId)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentityExam where userId=?";

		UserEntityExam userEntity = jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<UserEntityExam>(UserEntityExam.class),
				new Object[] { userId });

		return userEntity;
	}

	public List<UserEntity> getUserEntityList(long userName)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userName=?";

		List<UserEntity> userEntityList = jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class),
				new Object[] { userName });

		return userEntityList;
	}
	
	
	public void updatePasswd(){
		
	}

	@Override
	public UserEntity getUserEntityByUserNameAndPasswd(String userName, String passwd)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,role,userStatus from userentity where userName=? and passwd = ?";

		UserEntity userEntityList = jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), new Object[] {
				userName, passwd });

		return userEntityList;
	}

	public List<UserEntity> getUserEntityS(long userId)
	{
		String sqlStr = "select userId,userName,mobilePhone,nickName,userStatus from userentity where userStatus=?";

		List<UserEntity> userEntitys = jdbcTemplate.query(sqlStr, new RowMapper<UserEntity>()
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

		return userEntitys;
	}

	public void updateUser(UserEntity user)
	{
		// String sql =
		// "update user set userName=?,mobilePhone=?,nickName=?,userStatus=? where userId=?";
		// jdbcTemplate.update(sql,
		// new Object[] { user.getUserName(), user.getMobilePhone(),
		// user.getNickName(), user.getUserStatus(), user.getUserId() });
		// flushEntityToRedis(user.getUserId());
		this.updateEntityById("userId", user);

	}

}
