package chapter15;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParsing {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
//			xml을 파싱해서 모든 요소를 객체로 생성해서 tree 구조로 리턴
			Document doc = parser.parse("res/customerlist.xml");
//			root tag를 추출
			Element root = doc.getDocumentElement();
			for (Node node = root.getFirstChild();node != null;node = node.getNextSibling()) {
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					for (Node child = node.getFirstChild(); child!=null; child=child.getNextSibling()) {
						if(child.getNodeType() == Node.ELEMENT_NODE) {
							System.out.printf("%s:%s\n", child.getNodeName(), child.getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
