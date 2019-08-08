package chapter15;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	/**
	 * xml을 parsing하기 시작할 때 한번 호출되는 매서드
	 */
	public void StartDocument() throws SAXException{
		System.out.println("----------startDocument----------");
	}
	/**
	 * start Tag를 parsing할 때마다 호출되는 매서드
	 * @param uri			네임스페이스로 설정된 uri		Parser 종류에 따라 전달되지 않는다
	 * @param localName		태그 이름만					Parser 종류에 따라 전달되지 않는다
	 * @param qName			prefix를 포함한 태그 이름
	 * @param attributes	시작태그에 선언된 속성 정보들
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		System.out.printf("----------%s시작----------\n", qName);
		if(attributes!=null) {
			int len = attributes.getLength();
			if( len > 0) {
				System.out.println("속성 정보");
				for (int i = 0 ; i < len; i++) {
					System.out.println(attributes.getLocalName(i)+":"+attributes.getValue(i));
				}
			}
			
		}
	}
	/**
	 * 태그바디 중 문자데이토를 parsing할 때마다 호출되는 매소드
	 * @param ch		 태그 바디의 모든 문자열 
	 * @param start 	현재 문자열의 시작 위치
	 * @param length 	현재 문자열의 데이터 길이
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch, start, length));
	}
	
	/**
	 * end Tag를 parsing할 때마다 호출되는 매서드
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.printf("----------%s종료----------\n", qName);
	}
	
	/**
	 * xml parsing이 끝나면 호출되는 매서드
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----------end document----------");
	}
	

}
