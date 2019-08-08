package chapter15;

import java.util.List;


public class WeatherTest {
	public static void main(String[] args) {
		List<Weather> today = WeatherSAXParser.getWeathers("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
		for (Weather weather : today) {
			System.out.println(weather);
		}
	}
}
