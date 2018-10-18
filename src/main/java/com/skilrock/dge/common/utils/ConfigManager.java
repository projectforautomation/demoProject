package com.skilrock.dge.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.*;

public class ConfigManager {
	
	static Properties properties;
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
	
	public static void loadConfig()
	{
		try {
			File file = new File("Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			ConfigManager.properties = properties;
			
		} catch (Exception e) {
			logger.error("Exception occurred while loading config.properties "+ e.getMessage());
		}
		
	}

	public static String getProperty(String key)
	
	{ try
		{
			return properties.getProperty(key);
		}catch (Exception e) {
			assertThat("property not found in config file with key:"+key+" \n An exception " +
					"occured:"+e.getMessage());
		}
		return null;
	}
	
	public static String setProperty(String key, String value)
	{
		try {
			String previousValue =(String) properties.setProperty(key, value);
			
			return previousValue;
		} catch (Exception e) {
			e.printStackTrace();;
			
			return null;
		}
	}

}
