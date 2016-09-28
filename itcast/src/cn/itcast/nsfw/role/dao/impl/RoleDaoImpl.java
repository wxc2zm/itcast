package cn.itcast.nsfw.role.dao.impl;



import org.hibernate.Query;
import org.hibernate.Session;

import cn.itcast.core.dao.impl.BaseDaoImpl;
import cn.itcast.nsfw.role.dao.RoleDao;
import cn.itcast.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	/**
	 * 根据角色ID删除角色对应的权限
	 */
	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("DELETE FROM RolePrivilege where id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
