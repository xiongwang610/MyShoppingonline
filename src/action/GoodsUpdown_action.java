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
import Javabean.Goods;

@SuppressWarnings("serial")
public class GoodsUpdown_action extends ActionSupport{
	
	//判断是否可以存储
	private boolean issave=true;
	private String fileContentType;
	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



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
	private void save() throws IOException{
		
		String fileName = null;
		if(file != null){
			fileName=fileFileName.substring(fileFileName.lastIndexOf(".")); 
			if(phoneNumber == null && qq == null){
				this.addActionError("电话号码和qq不能都为空");
				return ; 
			}
			if(phoneNumber != null){
				fileName = new Date().getTime()+phoneNumber+fileName;
			}else fileName = new Date().getTime()+qq+fileName;
			String image_path=ServletActionContext.getServletContext().getRealPath("Images");
			File image_File = new File(image_path);
			if(!image_File.isDirectory()){
				image_File.mkdir();
			}
			
			FileUtils.copyFile(file, new File(image_File,fileName));
			Goods goods = new Goods();
			goods.setName(name);
			goods.setAddress(introduction);
			goods.setPhonenumber(phoneNumber);
			goods.setPrice(price);
			goods.setQq(qq);
			goods.setTime(new SimpleDateFormat("yyyy-MM-dd hh-ss-dd").format(new Date().getTime()));
			goods.setUrl(fileName);
			goods.setType(type);
			goods.setUser(new DbOperate().getUserByUserName("xiongwang"));
			new DbOperate().save(goods);
		}	
		
		
	}
	
	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		issave=false;
	}
	
	
}
