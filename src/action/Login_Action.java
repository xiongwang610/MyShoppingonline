package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import DbTool.DbOperate;
import Javabean.User;

public class Login_Action extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	
	private static final String NULL = "用户名或密码不能为空" ;
	private static final String USER_ERROR = "用户名不存在";
	private static final String PWD_ERROR = "密码错误";
	private String userName;
	private String password;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public String login(){
		
		if(userName.equals("") || password.equals("")) {
			
			addFieldError("", NULL);
			return ERROR;
			
		}
		else{
			
			User user ;
			DbOperate operate = new DbOperate();
			user = operate.getUserByUserName(userName);
			
			if(user != null){
				
				if(user.getPassword() == password){
					
					HttpSession session = request.getSession();
					session.setAttribute("userName", userName);
					return SUCCESS;
					
				}else {
					
					addFieldError("", PWD_ERROR);
					return ERROR;
				}
				
			}else {
				
				addFieldError("", USER_ERROR);
				return ERROR;
				
			}
		}
		
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		
		response = arg0;
		response.setCharacterEncoding("GBK");

	}

	public void setServletRequest(HttpServletRequest arg0) {
		
		request = arg0;

	}

}
