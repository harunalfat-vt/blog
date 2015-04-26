package blog.ui.model;

import java.util.Calendar;
import java.util.Map;

import org.springframework.ui.ModelMap;

import blog.data.enumeration.EnumSocialMedia;

public class CommonUi extends ModelMap {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String year;

	private void saveCurrentDate(){
		this.setYear(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		addAttribute("year", year);
	}
	
	private void saveSocialMediaUrl(){
		for(EnumSocialMedia socialMedia : EnumSocialMedia.values()){
			addAttribute(socialMedia.toString(),socialMedia.url);
		}
	}
	
	public CommonUi(){
		saveCurrentDate();
		saveSocialMediaUrl();
	}
	
	public CommonUi(Map<String,?> map){
		addAllAttributes(map);
		saveCurrentDate();
		saveSocialMediaUrl();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
