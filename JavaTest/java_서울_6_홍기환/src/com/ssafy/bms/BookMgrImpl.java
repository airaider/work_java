package com.ssafy.bms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class BookMgrImpl implements IBookMgr {
	private List<Book> bs;
	private String filename = "books.dat";
	private static BookMgrImpl instance = new BookMgrImpl();
	private BookMgrImpl() {
		load();
	}
	public static BookMgrImpl getInstance() {
		return instance;
	}
	@Override
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file =null;
		try {
			file = new File(filename);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				bs = (List) ois.readObject();
			}
			else {
				bs = new LinkedList<Book>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) {try {ois.close();} catch (Exception e) {}
			}
		}

	}
	@Override
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(bs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(oos!=null) {try {oos.close();} catch (Exception e) {}
		}
		}

	}

	public int findIndex(String isbn) {
		if(isbn!=null) {
			for(int i=0,size=bs.size();i<size;i++) {
				if(isbn.equals(bs.get(i).getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}
		
	@Override
	public void add(Book b) throws DuplicateException {
		if(b!=null) {
			String isbn=b.getIsbn();
			int index = findIndex(isbn);
			if(index > -1) {
				throw new DuplicateException();
			}
			else {
				bs.add(b);
			}
		}

	}

	@Override
	public List<Book> search() {
		return bs;
	}

	@Override
	public Book search(String isbn) throws RecordNotFoundException {
		if(isbn!=null) {
			for(int i=0,size=bs.size();i<size;i++) {
				if(isbn.equals(bs.get(i).getIsbn())) {
					return bs.get(i);
				}
			}
		}
		throw new RecordNotFoundException();
	}

	@Override
	public void update(String isbn, int price) throws RecordNotFoundException {
		if(isbn!=null) {
			int index = findIndex(isbn);
			if(index>-1) {
				bs.get(index).setPrice(price);
			}
			else {
				throw new RecordNotFoundException();
			}
		}

	}

	@Override
	public void delete(String isbn) throws RecordNotFoundException {
		if(isbn!=null) {
			int index = findIndex(isbn);
			if(index>-1) {
				bs.remove(index);
			}
			else {
				throw new RecordNotFoundException();
			}
		}

	}

	@Override
	public List<Book> searchTitle(String title) {
		List<Book> result = new LinkedList<Book>();
		if(title!=null) {
			for(int i=0,size=bs.size();i<size;i++) {
				if(bs.get(i).getTitle().contains(title)) {
					result.add(bs.get(i));
				}
			}
		}
		return result;
	}

	@Override
	public List<Book> sortIsbn() {
		Collections.sort(bs, new BookComparator());
		return bs;
	}
	
	@Override
	public String countWord() {
		Map<String, Integer> mp;
		mp = new HashMap<String, Integer>();
		for (Book book : bs) {
			for(String st : book.getTitle().split(" ")) {
				mp.put(st, 0);
			}
		}
		for (Book book : bs) {
			for(String st : book.getTitle().split(" ")) {
				int sum = mp.get(st);
				mp.put(st, sum+1);
			}
		}
		String ss = (String) mp.keySet().toArray()[0];
		return ss;
	}

}
