package net.yondervision.loghandle2.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerAdapterFactory
{
	public static Logger getLoggerAdapter(Class<?> clazz)
	{
		return LoggerFactory.getLogger(clazz);
	}
}
