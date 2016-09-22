package cn.itcast.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.test.dao.TestDao;
import cn.itcast.test.entity.Person;
import cn.itcast.test.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		testDao.save(person);
	}

	@Override
	public void findById(Serializable id) {
		// TODO Auto-generated method stub
		testDao.findById(id);
	}

}
