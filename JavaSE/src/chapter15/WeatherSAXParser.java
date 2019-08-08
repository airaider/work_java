package chapter15;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAXParser {
	public static class WeatherHandler extends DefaultHandler{
		private Weather weather;
		private List<Weather> weathers;
		private String data;
		private String city;
		
		public WeatherHandler() {
			weathers = new LinkedList<Weather>();
		}
		public List<Weather> getWeather(){
			return weathers;
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("data")) {
				weather = new Weather(city);
				weathers.add(weather);
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			data = new String(ch, start, length);
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("city")) {
				this.city=data;
			}
			else if(qName.equals("tmEf")) {
				weather.setDate(data);
			}else if(qName.equals("wf")) {
				if(weather!=null) {
					weather.setDesc(data);
				}
			}else if(qName.equals("tmn")) {
				weather.setTmn(data);
			}else if(qName.equals("tmx")) {
				weather.setTmx(data);
			}else if(qName.equals("reliability")) {
				weather.setReliability(data);
			}
		}
		
	}
	public static List<Weather> getWeathers(String url){
		try {
			SAXParserFactory fac = SAXParserFactory.newInstance();
			SAXParser parser = fac.newSAXParser();
			WeatherHandler handler = new WeatherHandler();
			parser.parse(url, handler);
			return handler.getWeather(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

