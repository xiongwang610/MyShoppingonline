package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DbTool.DbOperate;
import Javabean.Goods;

public class Details_Action extends ActionSupport {
	
	private String id;
	
	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * 获取单个goods具体信息
	 * @return
	 * @throws Exception
	 */
	public String getGoods() throws Exception {
		
		DbOperate operate = new DbOperate();
		Goods goods = operate.getGoodsById(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goods", goods);
		return SUCCESS;
	}
	
	
	/**
	 * 获取该user所有商品
	 * @return
	 */
	public String getUser(){
		
		DbOperate operate = new DbOperate();
		List<Goods> list = operate.getGoodsByUser(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", list);
		System.out.println(list);
		return SUCCESS;
	}
}
