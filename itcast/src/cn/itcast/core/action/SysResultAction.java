package cn.itcast.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

public abstract class SysResultAction extends StrutsResultSupport {

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseAction action = (BaseAction) arg1.getAction();
		
		System.out.println("进入了 SysResultAction ...");
	}

}