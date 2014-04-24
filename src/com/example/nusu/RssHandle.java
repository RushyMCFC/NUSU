package com.example.nusu;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandle extends DefaultHandler{
	
	private List<RssObject> listItems;
	private RssObject currentObj;
	private boolean parseTitle;
	private boolean parseLink;
	
	public RssHandle() {
		listItems = new ArrayList<RssObject>();
	}
	
	public List<RssObject> getListItems() {
		return listItems;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("item".equals(qName))
			currentObj = new RssObject();
		else if("title".equals(qName))
			parseTitle = true;
		else if("link".equals(qName))
			parseLink = true;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if("item".equals(qName)) {
			listItems.add(currentObj);
			currentObj = null;
		}
		else if("title".equals(qName))
			parseTitle = false;
		else if("link".equals(qName))
			parseLink = false;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		if(parseTitle) {
			if(currentObj != null)
				currentObj.setTitle(new String(ch,start,length));
		}
		else if(parseLink) {
			if(currentObj != null) {
				currentObj.setLink(new String(ch,start,length));
				parseLink = false;
			}	
		}
	}
	
	
	
}
