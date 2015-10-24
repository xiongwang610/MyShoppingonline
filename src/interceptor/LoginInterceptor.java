package interceptor;

import java.awt.event.InvocationEvent;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	
	public String intercept(ActionInvocation arg0) throws Exception {
		
		Map session = arg0.getInvocationContext().getSession();
		String userName = (String) session.get("userName");
		
		if(userName.equals(null)) return "login" ;
		else return arg0.invoke();
		
	}

}
