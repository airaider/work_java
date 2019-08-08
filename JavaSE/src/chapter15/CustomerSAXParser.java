package chapter15;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import chapter05.customer;

public class CustomerSAXParser {
	public static List<customer> parse(String url){
		try {
			SAXParserFactory fac = SAXParserFactory.newInstance();
			SAXParser parser = fac.newSAXParser();
			CustomerHandler handler = new CustomerHandler();
			parser.parse(url, handler);
			return handler.getCustomers(); 
		} catch (Exception e) {
			return null;
		}
	}
}
