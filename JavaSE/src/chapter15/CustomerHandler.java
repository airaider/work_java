package chapter15;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import chapter05.customer;

public class CustomerHandler extends DefaultHandler {
	private customer cust;
	private List<customer> list;
//	태그 바디 내용을 임시로 담을 변수
	private String data;
	public CustomerHandler() {
		list = new ArrayList<customer>(10);
	}
	public List<customer> getCustomers(){
		return list;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("customer")) {
			cust = new customer();
			list.add(cust);
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data = new String(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("name")) {
			cust.setName(data);
		}else if(qName.equals("age")) {
			try {
				cust.setAge(Integer.parseInt(data.trim()));
			} catch (Exception e) {}
		}else if(qName.equals("address")) {
			cust.setAddress(data);
		}
	}
}
