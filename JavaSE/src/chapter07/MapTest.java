package chapter07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import chapter05.Employee;

/**
 * Map : key를 이용해서 value를 관리(저장 추출, 삭제)
 */
public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, Object> map1 = new HashMap<>();
		/** put(key, value) : 데이터 추가 */
		map1.put(1, "hello");
		map1.put(2, new Employee("1", "1", 1));
		map1.put(1, "world");
		System.out.println(map1);
		System.out.println(map1.get(2));
		
		//keySet() : map에 저장된 key값만 추출
		Set<Integer> keys = map1.keySet();
		System.out.println(keys);
		//values() : map에 저장된 value값만 추출
		Collection<Object> values = map1.values();
		System.out.println(values);
	}

}
