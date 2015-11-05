package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DbTool.DbOperate;
import Javabean.Goods;


public class GoodsUpload_action extends ActionSupport {
	
	private String key;
	private String first;
	private String max;
	private String user_id;
	
	
	
	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String page() throws Exception {
		if(first == null || max == null){
			
			HttpServletRequest request = ServletActionContext.getRequest();
			first = (String) request.getAttribute("first");
			max = (String) request.getAttribute("max");
		}
		
		List<Goods> list = new ArrayList<Goods>();
		DbOperate operate = new DbOperate();
		list = operate.getGoodsByPage(new Integer(first), new Integer(max));
		Map<String,Object> map = ActionContext.getContext().getSession();
		 map.put("list", list);;
		return SUCCESS;
	}
	
	
	
	public String ByKey(){
		
		List<Goods> list = new ArrayList<Goods>();
		DbOperate operate = new DbOperate();
		list = operate.getGoodsByUncertain(key, new Integer(first), new Integer(max));
		Map<String ,Object> map = ActionContext.getContext().getParameters();
		map.put("list", list);
		
		return SUCCESS;
		
	}
	
	public String ByUser(){
		
		List<Goods> list = new ArrayList<Goods>();
		DbOperate operate = new DbOperate();
		list = operate.getGoodsByUser(user_id);
		Map<String ,Object> map = ActionContext.getContext().getParameters();
		map.put("list", list);
		
		return SUCCESS;
		
	}
	
}
