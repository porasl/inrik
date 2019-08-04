package com.inrik.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class  PropertiesUtil {
	static String inrik_properties = "/Users/hamid/tomcat/webapps/inrik.properties";

	public static Properties readProperies() {
		Properties prop = new Properties();
		try{
			InputStream in = 
					new FileInputStream(inrik_properties);
				prop.load(in);
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    return prop;
	}
	
	public static String getServerLogAddress() {
		return readProperies().getProperty("serverLog");
	}
	
	public static String getImageTempdir() {
		return readProperies().getProperty("imageTempdir");
	}
	
}
