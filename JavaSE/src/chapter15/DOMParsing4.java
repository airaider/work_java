package chapter15;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParsing4 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
//			xml을 파싱해서 모든 요소를 객체로 생성해서 tree 구조로 리턴
			Document doc = parser.parse("res/customerlist.xml");
			
			Element newCust = doc.createElement("customer");	//empty tag로 생성
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode("홍길동"));
			Element address = doc.createElement("address");
			address.appendChild(doc.createTextNode("율도국"));
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode("17"));
			
			newCust.appendChild(name);
			newCust.appendChild(age);
			newCust.appendChild(address);
			
			Element root = doc.getDocumentElement();
			root.appendChild(newCust);
			
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
