package blog.data.enumeration;


public enum EnumSocialMedia {
	
	twitter("http://twitter.com/harunalfat"),
	facebook("http://facebook.com/asharun"),
	google("http://plus.google.com/+AlfatHarun"),
	instagram("http://instagram.com/harunalfat/"),
	linkedin("http://id.linkedin.com/in/harunalfat"),
	bitbucket("http://bitbucket.org/harunalfat");
	
	public String url;
	
	private EnumSocialMedia(String url){
		this.url = url;
	}
	
}
