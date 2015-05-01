package blog.data.model;

import javax.servlet.http.HttpServletRequest;

public class UrlModel {

	private String scheme;
	private String host;
	private int port;
	private String path;
	private String full;
	
	public UrlModel(HttpServletRequest request){
		this.scheme = request.getScheme();
		this.host = request.getServerName();
		this.port = request.getServerPort();
		this.path = request.getContextPath();
		this.full = scheme+"://"+host+":"+Integer.toString(port)+path;
	}
	
	public String getScheme() {
		return scheme;
	}
	public String getHost() {
		return host;
	}
	public int getPort() {
		return port;
	}
	public String getPath() {
		return path;
	}
	public String getFull() {
		return full;
	}
	
}
