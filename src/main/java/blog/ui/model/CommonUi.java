package blog.ui.model;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import blog.data.enumeration.EnumSocialMedia;
import blog.data.model.PageAttribute;
import blog.data.model.UrlModel;

public class CommonUi extends ModelMap {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String year;
	private PageAttribute pageAttribute;
	private UrlModel url;

	private void saveCurrentDate(){
		this.year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		addAttribute("year", year);
	}
	
	private void saveSocialMediaUrl(){
		for(EnumSocialMedia socialMedia : EnumSocialMedia.values()){
			addAttribute(socialMedia.toString(),socialMedia.url);
		}
	}
	
	public void setPageAttribute(PageAttribute pageAttr){
		this.pageAttribute = pageAttr;
		addAttribute("pageAttr",pageAttribute);
	}
	
	public void setCurrentUrl(HttpServletRequest request){
		this.url = new UrlModel(request);
		addAttribute("url", url);
	}
	
	public CommonUi(){
		saveCurrentDate();
		saveSocialMediaUrl();
	}
	
	public CommonUi(Map<String,?> map){
		this();
		addAllAttributes(map);
	}

	public String getYear() {
		return year;
	}
	
}
