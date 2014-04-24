package com.example.nusu;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssReader {
	private String url;
	
	public RssReader(String url) {
		this.url = url;
	}
	
	public List<RssObject> items() throws Exception {
		SAXParserFactory f = SAXParserFactory.newInstance();
		SAXParser p = f.newSAXParser();
		
		RssHandle h = new RssHandle();
		p.parse(url, h);
		return h.getListItems();
	}
	
}
