package chapter15;

import com.google.gson.Gson;

import chapter05.customer;

public class JSONTest {

	public static void main(String[] args) {
		customer cust = new customer("SSAFY", 2, "역삼동");
		Gson gson = new Gson();
//		String toJson(Object o) : 인자로 전달된 객체를 JSON데이터로 변경
		String json = gson.toJson(cust);
		System.out.println(json);
		
		customer[] custs = {cust, new customer("hkh", 26, "인천")};
		System.out.println(gson.toJson(custs));
	}

}
