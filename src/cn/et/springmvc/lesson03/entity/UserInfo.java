package cn.et.springmvc.lesson03.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class UserInfo {
	/**
	 * NotNull 属性名！=null
	 * NotEmpty 属性名！=null && !属性名.equals("");
	 */
	@NotEmpty(message="用户名不能为空")
	private String userName;
	@NotEmpty(message="密码不能为空")
	private String password;
	@NotEmpty(message="确认密码不能为空")
	private String repassword;
	//xx@xx.com  .+@.+/..+
	/*@Pattern(regexp=".+@.+\\..+",message="邮箱格式不正确")*/
	@Email(message="邮箱格式不正确")
	private String email;
	@Range(min=1,max=150,message="年龄必须在1-150之间")
	private String age;
	@Size(min=11,max=11,message="必须是11位数字")
	private String phone;
	
	//出生日期
	/*@Pattern(regexp="([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))",message="日期有误")	*/
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="出生日期有误")
	
	private Date birthday;
	
	
	//个人网址  http://www.baidu.com  http://ip:端口/
	//^http[s]?:\\/\\/[w]{3}\\.\\w+\\.\\w+
	/*@Pattern(regexp="^http[s]?:\\/\\/[w]{3}\\.\\w+\\.\\w+",message="个人网址格式错误")*/
	@URL(message="个人网址格式错误")
	private String web;
	
	
	
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBornDate(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	
}

