package chapter15;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParsing3 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
//			xml을 파싱해서 모든 요소를 객체로 생성해서 tree 구조로 리턴
			Document doc = parser.parse("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
			NodeList list = doc.getElementsByTagName("location");
			for( int i=0, len = list.getLength(); i< len ;i++) {
				Node node = list.item(i);
				String city = "";
				for (Node child = node.getFirstChild(); child!=null; child=child.getNextSibling()) {
					if(child.getNodeType() == Node.ELEMENT_NODE) {
						String name = child.getNodeName();
						if(name.equals("city")) {
							city = child.getTextContent();
						}else if(name.equals("data")) {
							System.out.printf("지역:%s ", city);
							for(Node data = child.getFirstChild(); data!=null; data=data.getNextSibling()) {
								if(data.getNodeType() == Node.ELEMENT_NODE) {
									System.out.printf(" %s:%s", data.getNodeName(), data.getTextContent());
								}
							}
							System.out.println();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
