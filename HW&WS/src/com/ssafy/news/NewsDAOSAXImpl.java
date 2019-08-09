package com.ssafy.news;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	List<News> news;
	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return news;
	}
	
	private void connectNews(String url) {
		try {
			SAXParserFactory fac = SAXParserFactory.newInstance();
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(url, handler);
//			return handler.getNews(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class SAXHandler extends DefaultHandler{
		News n;
		String data;
		
		public SAXHandler() {
			news = new LinkedList<News>();
			n = new News();
		}
		public List<News> getNews(){
			return news;
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("item")) {
				n = new News();
				news.add(n);
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			data = new String(ch, start, length);
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("title")) {
				n.setTitle(data);
			}else if(qName.equals("description")) {
				n.setDesc(data);
			}else if(qName.equals("link")) {
				n.setLink(data);
			}
		}
		
	}
}
