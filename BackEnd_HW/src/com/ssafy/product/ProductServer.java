package com.ssafy.product;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
class UserService extends Thread {
    private Socket socket;
    public UserService(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            String fileName = String.format("Product%s.txt", socket.getInetAddress().toString().substring(1));
            // 네트워크로부터 데이터 전송받을 스트림
            ois = new ObjectInputStream(socket.getInputStream());
            fos = new FileOutputStream(fileName);
            // 파일에 출력할 스트림
            oos = new ObjectOutputStream(fos);
            // 네트워크로부터 입력받은 데이터를 바로 출력
            Object tmp = ois.readObject();
            oos.writeObject(tmp); // 파일에 출력
            ArrayList<Product> tmps = (ArrayList<Product>) tmp;
            for (Product product : tmps) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(oos);
            IOUtil.close(fos);
            IOUtil.close(ois);
            IOUtil.close(socket);
        }
    }
}
public class ProductServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5334);
            System.out.println("ProductServer start.....");
            while (true) {
                Socket s = ss.accept();
                String fileName = s.getInetAddress().toString().substring(1) + "Obeject.txt";
                System.out.println("클라이언트" + s.getInetAddress() + "접속");
                new UserService(s).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(ss);
        }
    }
}