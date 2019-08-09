package com.ssafy.news;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO{
	List<News> news = new LinkedList<News>();
	
	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return news;
	}
	
	private void connectNews(String url) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
			Document doc = parser.parse(url);
			NodeList list = doc.getElementsByTagName("item");
			for( int i=0, len = list.getLength(); i< len ;i++) {
				News n = new News();
				Node node = list.item(i);
				for (Node child = node.getFirstChild(); child!=null; child=child.getNextSibling()) {
					if(child.getNodeType() == Node.ELEMENT_NODE) {
						String name = child.getNodeName();
						if(name.equals("title")) {
							n.setTitle(child.getTextContent());
						}else if(name.equals("description")) {
							n.setDesc(child.getTextContent());
						}else if(name.equals("link")) {
							n.setLink(child.getTextContent());
						}
					}
					
				}
				news.add(n);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
