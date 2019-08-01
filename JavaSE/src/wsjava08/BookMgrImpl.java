package wsjava08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {
	private List<Book> books;
	private String filename = "book.dat";
	public BookMgrImpl() {
		open();
	}
	
	
	@Override
	public void add(Book bk) {
		System.out.println("책을 저장합니다.");
		if(bk!=null) {
			String isbn = bk.getIsbn();
			int index = findIndex(isbn);
			if(index > -1) {
				System.out.println("이미 존재하는 책입니다.");
			}
			else {
				books.add(bk);
			}
		}
	}

	private int findIndex(String isbn) {
		if(isbn != null) {
			for (int i = 0, size=books.size(); i < size; i++) {
				if(isbn.equals(books.get(i).getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}


	@Override
	public List search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		System.out.println("책을 판매합니다.");
		if(isbn!=null) {
			int index = findIndex(isbn);
			if(index>-1) {
				int quant = books.get(index).getQuantity();
				if(quant>0) {
					books.get(index).setQuantity(quant-1);
				}
				else {
					String msg = String.format("수량이 0입니다.");
					throw new QuantityException(msg);
				}
			}
			else {
				String msg = String.format("%s번 책은 존재하지 않습니다.", isbn);
				throw new ISBNNotFoundException(msg);
			}
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		System.out.println("책을 구매합니다.");
		if(isbn!=null) {
			int index = findIndex(isbn);
			if(index>-1) {
				int quant = books.get(index).getQuantity();
				books.get(index).setQuantity(quant+quantity);
			}
			else {
				String msg = String.format("%s번 책은 존재하지 않습니다.", isbn);
				throw new ISBNNotFoundException(msg);
			}
		}

	}

	@Override
	public int getTotalAmount() {
		int sum=0;
		for(int i=0, size=books.size();i<size;i++) {
			sum+=books.get(i).getPrice()*books.get(i).getQuantity();
		}
		return sum;
	}

	@Override
	public void open() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(filename);
			if(file.exists() && file.canRead()) {
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				books=(List) ois.readObject();
			}else {
				books = new LinkedList<Book>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ois!=null)try {ois.close();}catch(Exception e) {}
			if(fis!=null)try {fis.close();}catch(Exception e) {}
		}
	}

	@Override
	public void close() {
		save();
		System.exit(0);
	}
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(oos!=null)try {oos.close();}catch(Exception e) {}
			if(fos!=null)try {fos.close();}catch(Exception e) {}
		}
				
	}

}
