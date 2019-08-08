package chapter15;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParsing2 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
//			xml을 파싱해서 모든 요소를 객체로 생성해서 tree 구조로 리턴
			Document doc = parser.parse("res/customerlist.xml");
			NodeList list = doc.getElementsByTagName("customer");
			for( int i=0, len = list.getLength(); i< len ;i++) {
				Node node = list.item(i);
				for (Node child = node.getFirstChild(); child!=null; child=child.getNextSibling()) {
					if(child.getNodeType() == Node.ELEMENT_NODE) {
						System.out.printf("%s:%s\n", child.getNodeName(), child.getTextContent());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
