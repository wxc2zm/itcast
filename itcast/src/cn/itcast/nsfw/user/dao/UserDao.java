package cn.itcast.nsfw.user.dao;

import java.util.List;

import cn.itcast.core.dao.BaseDao;
import cn.itcast.nsfw.user.entity.User;

public interface UserDao extends BaseDao<User> {
	//校验账户唯一
	public List<User> findUserByAccountAndId(String id, String account);
}
