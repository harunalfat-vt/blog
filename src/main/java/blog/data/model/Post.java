package blog.data.model;

import java.util.Date;

public class Post {

	private String id;
	private String title;
	private String subTitle;
	private String content;
	private Date dtcreated;
	private Date dtupdated;
	private String user;
	private String dateStr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public Date getDtcreated() {
		return dtcreated;
	}
	public void setDtcreated(Date dtcreated) {
		this.dtcreated = dtcreated;
	}
	public Date getDtupdated() {
		return dtupdated;
	}
	public void setDtupdated(Date dtupdated) {
		this.dtupdated = dtupdated;
	}
	
}
