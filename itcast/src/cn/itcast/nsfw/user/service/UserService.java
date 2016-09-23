package cn.itcast.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.itcast.nsfw.user.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(Serializable id);
	
	public User findObjectById(Serializable id);
	
	public List<User> findObjects();
	
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);
	
	public void importExcel(File userExcel, String userExcelFileName);
	
	public List<User> findUserByAccountAndId(String id, String account);
}
