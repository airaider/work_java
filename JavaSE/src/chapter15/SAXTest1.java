package chapter15;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXTest1 {
	public static void main(String[] args) {
		
		/**
		 * SAXParserFactory.newInstance(factoryClassName, classLoader)
		 * - 기본으로 제공하는 Parser가 아닌 다른 파서를 사용할 때
		 * factoryClassName : 패키지명을 포함하는 하서의 클래스 이름
		 * classLoader : 파서를 로딩할 클래스로더
		 */
//		ClassLoader loader = new SAXTest1().getClass().getClassLoader();
		
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			//parse(String xmlURL, handler)	:	xml을 읽어 지정한 Handler로 paring
			parser.parse("res/customerlist.xml", new SAXHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
