package action;

import com.opensymphony.xwork2.ActionSupport;

import DbTool.DbOperate;
import Java.User;

@SuppressWarnings("serial")
public class Register_Action extends ActionSupport {
	
	
	private static final String NULL = "用户名或密码不能为空" ;
	private static final String USERERROR = "用户已存在" ;
	private String userName ;
	private String password ;
	
	
	public String register(){
		
		if(userName.equals("") || password.equals("")){
			
			System.out.println(userName+password);
			this.addFieldError("", NULL);
			return ERROR;
		}
		else{
			System.out.println(userName+password);
			DbOperate operate = new DbOperate();
			User user = operate.getUserByUserName(userName);
			
			if(user == null){
				
				user = new User();
				user.setUsername(userName);
				user.setPassword(password);
				operate.save(user);
				
				return SUCCESS;
			}else{
				
				addFieldError("", USERERROR);
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
	
 
}
