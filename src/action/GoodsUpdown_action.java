package action;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DbTool.DbOperate;

@SuppressWarnings("serial")
public class GoodsUpdown_action extends ActionSupport{
	
	//判断是否可以存储
	private boolean issave=true;
	
	private String fileFileName;
	private File file;
	private String phoneNumber;
	private String name;
	private String introduction;
	private String price;
	private String type;
	private String qq;
	
	
	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	private String address;
	
	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public String execute() throws Exception {
		
		if(issave){
			save();
			return SUCCESS;
		}else return ERROR;
		
		
	}
	
	
	/**
	 * 将图片存到硬盘上和将goods存到数据库
	 * @throws IOException
	 */
	private String save() throws IOException{
		
		String fileName = null;
		if(file != null){
			fileName=fileFileName.substring(fileFileName.lastIndexOf(".")); 
			
			if(phoneNumber != null){
				fileName = new Date().getTime()+phoneNumber+fileName;
			}else fileName = new Date().getTime()+qq+fileName;
			String image_path=ServletActionContext.getServletContext().getRealPath("Images");
			File image_File = new File(image_path);
			if(!image_File.isDirectory()){
				image_File.mkdir();
			}
			
			FileUtils.copyFile(file, new File(image_File,fileName));
		}
		
		/**DbOperate operate = new DbOperate();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session=request.getSession();
		
		User user=operate.getUserByUserName((String)session.getAttribute("username"));
		Goods goods=new Goods();
		goods.setIntroduction(introduction);
		goods.setName(name);
		goods.setAddress(address);
		if(phoneNumber!=null)	goods.setPhonenumber(phoneNumber);
		if(qq!=null) goods.setQq(qq);
		goods.setPrice(price);
		goods.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
		goods.setUrl(fileName);
		goods.setUser(user);
		operate.save(goods);**/
		return null;
		
	}
	
	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		issave=false;
	}
	
}
