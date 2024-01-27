package tw.com.eeit.midtermfix.mainarea;

import java.util.Scanner;

import tw.com.eeit.midtermfix.connection.IOConnectionDao;
import tw.com.eeit.midtermfix.total.IMidDao;

public class usefortest {

	public static void main(String[] args) throws Exception {
//		jdbc:sqlserver://localhost:1433;databaseName=Midterm;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true 
//			 
		IMidDao iMidDao = new  IOConnectionDao();

//		ImageDao imageDao = new ImageDao();
		Scanner scanner = new Scanner(System.in);
		String scan = scanner.next();
		IOConnectionDao connection=(IOConnectionDao)iMidDao;
		connection.createConn(scan);
		
		
		
		
		
		scanner.close();
		connection.closeConn();
	}

}
