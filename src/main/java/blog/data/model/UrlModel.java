package blog.data.model;

import javax.servlet.http.HttpServletRequest;

public class UrlModel {

	private static String scheme;
	private static String host;
	private static int port;
	private static String path;
	
	public UrlModel(HttpServletRequest request){
		UrlModel.scheme = request.getScheme();
		UrlModel.host = request.getServerName();
		UrlModel.port = request.getServerPort();
		UrlModel.path = request.getContextPath();
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
		return scheme+"://"+host+":"+Integer.toString(port)+path;
	}
	public String getSiteOnly(){
		return scheme+"://"+host+":"+Integer.toString(port);
	}
	
}
