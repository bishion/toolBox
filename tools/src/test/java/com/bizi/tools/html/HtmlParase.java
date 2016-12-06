package com.bizi.tools.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by fangbi.guo on 2015/10/26.
 */
public class HtmlParase {
	public static void paraseHtml(){
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p class='bizi test'>Parsed HTML into a doc.</p><p>Parsed HTML into a element.</p></body></html>";
		Document document = Jsoup.parse(html);
		Element element = document.body();
		System.out.println(element.getElementsByTag("p").html());
		System.out.println(element.getElementsByTag("p").attr("class"));
		Elements elements = element.getElementsByTag("p");
		elements.stream().filter(element1 -> element1.hasAttr("class") && element1.attr("class").contains("bizi")).forEach(element1 -> System.out.println(element1.html()));
		System.out.println(element.select("p.bizi").html());
	}

	public static void main(String[] args) {
		HtmlParase.paraseHtml();
	}
}
