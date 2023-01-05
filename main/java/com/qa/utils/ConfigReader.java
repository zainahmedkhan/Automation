package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\zain.rehani\\eclipse-workspace\\HybridFrameworkBDD\\src\\test\\resources\\configs\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
}
