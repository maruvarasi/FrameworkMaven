package com.utilities.pkg;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

public class proputils {
	HashMap<String, String> hsKey = new HashMap<>();

	/*
	 * Properties prop = new Properties(); String filename =
	 * "global.properties"; InputStream input =null;
	 */
	public HashMap<String, String> readProp() {
		ResourceBundle rb = ResourceBundle.getBundle("global");
		Enumeration<String> keys = rb.getKeys();
		// HashMap<String,String> hsKey = new HashMap<>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			//System.out.println(key + ": " + value);
			hsKey.put(key, value);
		}
		return hsKey;
	}

}
