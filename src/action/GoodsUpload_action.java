package action;

import java.io.File;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Java.Goods;


public class GoodsUpload_action extends ActionSupport {
	
	private Goods goods;
	private File file;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public String execute() throws Exception {
		
		
		return null;
	}
	
}
