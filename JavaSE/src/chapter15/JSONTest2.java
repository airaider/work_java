package chapter15;

import com.google.gson.Gson;

import chapter05.customer;

public class JSONTest2 {

	public static void main(String[] args) {
		String json1 = "{\"name\":\"SSAFY\",\"age\":2,\"address\":\"역삼동\"}";
		
		Gson gson = new Gson();
		customer cust = gson.fromJson(json1, customer.class);
		System.out.println(cust);
		
		String json2 = "[{\"name\":\"SSAFY\",\"age\":2,\"address\":\"역삼동\"},{\"name\":\"hkh\",\"age\":26,\"address\":\"인천\"}]";
		customer[] custs = gson.fromJson(json2, customer[].class);
		for (customer customer : custs) {
			System.out.println(customer);
		}
		
	}

}
