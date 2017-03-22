package com.demo.core.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

public class PropertyUtils extends PropertyPlaceholderConfigurer {
	private static Map<String, String> propertyMap;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);

		propertyMap = new HashMap<String, String>();
		
		for (Object key : props.keySet()) {
			String value = props.getProperty(key.toString());
			propertyMap.put(key.toString(), value);
		}
	}

	public static String getConfigValue(String name) throws Exception {
		String value = propertyMap.get(name);

		if (StringUtils.isEmpty(name)) {
			String errMsg = "Property [" + name + "] is not set";
			throw new Exception(errMsg);
		} else
			return value;
	}
}
