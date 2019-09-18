package com.ssafy.bms;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	public int compare(Book o1, Book o2) {
		String orderBy;
		return o1.getIsbn().compareTo(o2.getIsbn());
	}


}
