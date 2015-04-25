package blog.mongo.initiator;

import java.net.UnknownHostException;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public final class MongoOperationsInitiator{

	private static String host;
	private static String port;
	private static String username;
	private static String password;
	private static String appName;
	
	public MongoOperationsInitiator(String host, String port, String username, String password, String appName){
		MongoOperationsInitiator.host = System.getenv("OPENSHIFT_MONGODB_DB_HOST") != null ? System.getenv("OPENSHIFT_MONGODB_DB_HOST") : host;
		MongoOperationsInitiator.port = System.getenv("OPENSHIFT_MONGODB_DB_PORT") != null ? System.getenv("OPENSHIFT_MONGODB_DB_HOST") : port;
		MongoOperationsInitiator.username = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME") != null ? System.getenv("OPENSHIFT_MONGODB_DB_HOST") : username;
		MongoOperationsInitiator.password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD") != null ? System.getenv("OPENSHIFT_MONGODB_DB_HOST") : password;
		MongoOperationsInitiator.appName = System.getenv("OPENSHIFT_APP_NAME") != null ? System.getenv("OPENSHIFT_MONGODB_DB_HOST") : appName;
	}

	public static MongoTemplate initMongoOperations() {
		try {
			Mongo mongo = new MongoClient(host, Integer.decode(port));
			UserCredentials userCredentials = new UserCredentials(username, password);
			MongoTemplate template = new MongoTemplate(mongo, appName, userCredentials);
			return template;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getHost() {
		return host;
	}

	public static String getAppName() {
		return appName;
	}

	public static String getPort() {
		return port;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}	
	
}
