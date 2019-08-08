package chapter15;

import java.util.Iterator;
import java.util.List;

import chapter05.customer;

public class CustomerTest {
	public static void main(String[] args) {
		List<customer> cuts = CustomerSAXParser.parse("res/customerlist.xml");
		for (customer customer : cuts) {
			System.out.println(customer);
		}
	}
}
