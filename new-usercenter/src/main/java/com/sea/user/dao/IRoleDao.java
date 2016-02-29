package com.sea.user.dao;

import java.util.List;

import com.sea.dao.impl.IBaseDao;
import com.sea.user.entity.RoleEntity;

public interface IRoleDao extends IBaseDao<RoleEntity>
{

	List<RoleEntity> getUserRole(long userId);

}
