package com.bizi.tools.xml;

import com.thoughtworks.xstream.XStream;

public class XMLUtil {

	public static String beanToXML(Object object){
		XStream xStream = new XStream();
//		xStream.processAnnotations(List.class);
		xStream.autodetectAnnotations(true);
		return xStream.toXML(object);
	}
	
	public static <T> T xmlToBean(Class<T> clazz,String xml){
		XStream xStream = new XStream();
		xStream.processAnnotations(clazz);
		xStream.autodetectAnnotations(true);
		return (T)xStream.fromXML(xml);
	}
}
