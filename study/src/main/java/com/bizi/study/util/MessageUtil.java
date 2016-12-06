package com.bizi.study.util;

import com.bizi.study.dto.weixin.WeiXinREQ;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc
 * aithor guofangbi
 * date:2015/4/15
 */
public class MessageUtil {

	public static Map<String,String> xmlToMap(String message){
		Map<String,String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		try {
			System.out.println(message);
			Document doc = reader.read(new ByteArrayInputStream(message.getBytes("UTF-8")));
			Element root = doc.getRootElement();

			List<Element> list = root.elements();
			for (Element element : list) {
				map.put(element.getName(),element.getText());
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static String messageToXml(WeiXinREQ resultMessage){
		XStream xstream = new XStream();
		xstream.alias("xml",resultMessage.getClass());
		return xstream.toXML(resultMessage);
	}

}
