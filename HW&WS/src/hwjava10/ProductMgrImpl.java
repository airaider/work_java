package hwjava10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import wsjava10.IOUtil;

public class ProductMgrImpl implements IProductMgr {
	private static ProductMgrImpl instance = new ProductMgrImpl();
	private ArrayList<Product> products;
	private String filename="product.dat";
	public ProductMgrImpl() {
		open();
	}
	public static ProductMgrImpl getInstance() {
		return instance;
	}
	@Override
	public void add(Product pro) throws DuplicateException {
		System.out.println("제품을 저장합니다.");
		if(pro!=null) {
			String no = pro.getNo();
			int index = findIndex(no);
			if(index>-1) {
				String msg = String.format("이미 존재하는 제품입니다");
				throw new DuplicateException(msg);
			}
			else {
				products.add(pro);
			}
		}

	}

	private int findIndex(String no) {
		if(no!=null) {
			for(int i=0,size=products.size();i<size;i++) {
				if(no.equals(products.get(i).getNo())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public ArrayList search() {
		return products;
	}

	@Override
	public Product search_no(String no) throws CodeNotFound {
		int index = findIndex(no);
		if(index>-1) {
			return products.get(index);
		}
		else {
			String msg = String.format("%s 제품은 존재하지 않습니다", no);
			throw new CodeNotFound(msg);
		}
	}

	@Override
	public ArrayList search_400L() throws ProductNotFound {
		ArrayList<Product> result = new ArrayList<Product>();
		for(int i=0,size=products.size();i<size;i++) {
			if(products.get(i) instanceof Refrigerator) {
				Refrigerator rf = (Refrigerator) products.get(i);
				if(rf.getLiter()>=400) {
					result.add(products.get(i));
				}
			}
		}
		if(result.size()>0) {
			return result;
		}
		else {
			String msg = String.format("400L 이상의 냉장고가 없습니다.");
			throw new ProductNotFound(msg);
		}
		
	}

	@Override
	public ArrayList search_50inch() throws ProductNotFound {
		ArrayList<Product> result = new ArrayList<Product>();
		for(int i=0,size=products.size();i<size;i++) {
			if(products.get(i) instanceof TV) {
				TV rf = (TV) products.get(i);
				if(rf.getInch()>=50) {
					result.add(products.get(i));
				}
			}
		}
		if(result.size()>0) {
			return result;
		}
		else {
			String msg = String.format("50inch 이상의 TV가 없습니다.");
			throw new ProductNotFound(msg);
		}
	}

	@Override
	public void open() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(filename);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				products = (ArrayList)ois.readObject();
			}
			else {
				products = new ArrayList<Product>();
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

	}
	public void save() {
		new Thread() {
            public void run() {
            	FileOutputStream fos = null;
        		ObjectOutputStream oos = null;
        		try {
        			fos = new FileOutputStream(filename);
        			oos = new ObjectOutputStream(fos);
        			oos.writeObject(products);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}finally {
        			if(oos!=null)try {oos.close();}catch(Exception e) {}
        			if(fos!=null)try {fos.close();}catch(Exception e) {}
        		}
            }
        }.start();
		
	}
	
	public ArrayList<Product> tvsearch() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof TV) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}

	public ArrayList<Product> refrigsearch() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof Refrigerator) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}
	@Override
	public void send() {
        new Thread() {
            public void run() {
                // 한번 데이터 전송후 연결이 끊어지므로 데이터를 전송할 때마다 서버에 연결 시도
                Socket s = null;
                ObjectOutputStream oos = null;
                try {
                    s = new Socket("70.12.108.91", 5334);
                    oos = new ObjectOutputStream(s.getOutputStream());
                    ArrayList<Product> result = tvsearch();
                    result.addAll(refrigsearch());
                    
                     
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    IOUtil.close(oos);
                    IOUtil.close(s);
                }
            }
        }.start();
    }

}
