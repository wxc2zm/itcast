package cn.itcast.nsfw.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import cn.itcast.core.dao.impl.BaseDaoImpl;
import cn.itcast.nsfw.user.dao.UserDao;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		String hql = "FROM User WHERE account = ?";
		if (StringUtils.isNotBlank(id)) {
			hql += "AND id != ?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);
		if (StringUtils.isNotBlank(id)) {
			query.setParameter(1, id);
		}
		return query.list();
	}

	@Override
	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	@Override
	public void deleteUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoleByUserId(String id) {
		Query query = getSession().createQuery("FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByAccountAndPass(String account, String password) {
		Query query = getSession().createQuery("FROM User WHERE account=? AND password=? AND state=?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		query.setParameter(2, User.USER_STATE_VALID); //有效用户才能登录系统
		return query.list();
	}

}
