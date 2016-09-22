package cn.itcast.nsfw.user.service;

import java.io.Serializable;
import java.util.List;

import cn.itcast.nsfw.user.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(Serializable id);
	
	public User findObjectById(Serializable id);
	
	public List<User> findObjects();
}
