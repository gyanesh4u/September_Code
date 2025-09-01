package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public static Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("config.properties");
			prop.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
		return prop;
	}

	public static String getProperty(String key) {
		if (prop == null) {
			initProperties();
		}
		return prop.getProperty(key);
	}

}
