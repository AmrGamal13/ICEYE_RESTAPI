package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> envAndFile(String env) {

		//String environment = System.getProperty("env");

		try {
			if (env.equalsIgnoreCase("dev")) {

				FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/Env/Dev.properties");
				propMain.load(fisDev);
				fileandenv.put("baseUrl", propMain.getProperty("baseUrl"));
				fileandenv.put("portNo", propMain.getProperty("portNo"));
				fileandenv.put("userName", propMain.getProperty("userName"));
				fileandenv.put("passWord", propMain.getProperty("passWord"));

			} else if (env.equalsIgnoreCase("qa")) {
				FileInputStream fisQA = new FileInputStream(System.getProperty("user.dir") + "/Env/Qa.properties");
				propMain.load(fisQA);
				fileandenv.put("baseUrl", propMain.getProperty("baseUrl"));
				fileandenv.put("portNo", propMain.getProperty("portNo"));
				fileandenv.put("userName", propMain.getProperty("userName"));
				fileandenv.put("passWord", propMain.getProperty("passWord"));
			} else if (env.equalsIgnoreCase("stage")) {
				FileInputStream fisStaging = new FileInputStream(System.getProperty("user.dir") + "/Env/Stage.properties");
				propMain.load(fisStaging);
				fileandenv.put("baseUrl", propMain.getProperty("baseUrl"));
				fileandenv.put("portNo", propMain.getProperty("portNo"));
				fileandenv.put("userName", propMain.getProperty("userName"));
				fileandenv.put("passWord", propMain.getProperty("passWord"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return fileandenv;

	}
	
	
	public static Map<String, String> getConfigReader(){
		if(fileandenv == null) {
			fileandenv = envAndFile(null);
		}
		
		
		return fileandenv;
		
	}

}