package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class ConfigProperties.
 */
public class ConfigProperties {
	/**
	 * This Method sets current working directory to static variable PROJECT_DIR
	 */
	public static String PROJECT_DIR;
	private static String configFilePath = "config.properties";

	static {
		PROJECT_DIR = System.getProperty("user.dir") + "\\";
	}

	/**
	 * This Method takes as input the Config file path and Key and returns the
	 * respective value.
	 * 
	 * @param filename
	 * @param key
	 * @return Value for the given Key and file
	 */
	public static String getKeyValue(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(PROJECT_DIR + configFilePath));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
