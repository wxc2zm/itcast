package cn.itcast.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.core.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> clazz;
	
	//利用反射得到T的真实类型
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		//获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		//获取第一个类型参数的真实类型
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(findObjectById(id));
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(entity);
	}

	@Override
	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjects() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName());
		
		return query.list();
	}

}
