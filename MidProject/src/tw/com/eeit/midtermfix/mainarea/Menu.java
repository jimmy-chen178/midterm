package tw.com.eeit.midtermfix.mainarea;

import java.util.Scanner;
import tw.com.eeit.midtermfix.connection.IOConnectionDao;
import tw.com.eeit.midtermfix.connection.IOConnectionMemberBean;
import tw.com.eeit.midtermfix.dao.ImageDao;
import tw.com.eeit.midtermfix.dao.ImageMemberBean;
import tw.com.eeit.midtermfix.dao.ModelDao;
import tw.com.eeit.midtermfix.dao.ModelMemberBean;
import tw.com.eeit.midtermfix.factory.MidDaoFactory;


public class Menu {
	public static void main(String[] args) throws Exception {
		IOConnectionDao mConnDao = (IOConnectionDao) MidDaoFactory.createfactoryDao(MidDaoFactory.IOCD);
		ModelDao mDao=(ModelDao) MidDaoFactory.createfactoryDao(MidDaoFactory.MD);
		ImageDao mIMDao=(ImageDao) MidDaoFactory.createfactoryDao(MidDaoFactory.IMD);
				System.out.println("功能清單\n(一)從網路下載資料並建立檔案\n(二)選擇檔案寫進MSSQL\n(三)讀取MSSQL資料並建立檔案\n"
				+ "(四)從檔案存入圖片MSSQL\n(五)從MSSQL讀取圖片並建立檔案\n請選擇功能:");
		Scanner scanner = new Scanner(System.in);
		String strmenu = scanner.next();
		int menu = Integer.parseInt(strmenu.trim());
		switch (menu) {
		case 1:
			System.out.println("輸入完整下載連結:");// 功能一.從網路下載資料並建立檔案
			String webUrl = scanner.next();
			/*https://data.tainan.gov.tw/dataset/279d5fa9-1f9c-4e69-b8e8-83c332771398/resource/675b97a1-c7b1-45d9-ac15-34d66949b4c5/download/10901.csv
			 * 使用這個連結
			 */
			System.out.println("輸入檔案位置:");
			String generation1 = scanner.next();
			// "C:\Eeit178ClassUpdate\csv"
			// 使用這個連結
			IOConnectionMemberBean batch = new IOConnectionMemberBean(webUrl, generation1);
			mConnDao.batchDownload(batch);
			break;
		case 2:
			System.out.println("輸入檔案");// 功能二.選擇檔案寫進MSSQL
			String generation2 = scanner.next();
			// "C:\Eeit178ClassUpdate\csv\10901.csv"
			System.out.println("輸入連結的資料庫");
			String connecSql2 = scanner.next();
			/*jdbc:sqlserver://localhost:1433;databaseName=Midterm;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true 
			  使用這個連結*/
			IOConnectionMemberBean cts = new IOConnectionMemberBean();
			cts.setUrl(connecSql2);
			cts.setGeneration(generation2);
			mConnDao.createConn(cts.getUrl());
			mConnDao.Cts(cts.getGeneration());
			break;
		case 3:
			System.out.println("輸入連結的資料庫");// 功能三.讀取MSSQL資料並編輯
			String connecSql3 = scanner.next();
			/*jdbc:sqlserver://localhost:1433;databaseName=Midterm;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true 
			  使用這個連結*/
			IOConnectionMemberBean stc = new IOConnectionMemberBean();
			stc.setUrl(connecSql3);
			mConnDao.createConn(stc.getUrl());
			System.out.println("CRUD清單:\n(一)新增\n(二)修改\n"
					+ "(三)刪除\n(四)查詢ID資訊\n請選擇功能:");
			String strCrud = scanner.next();
			int crud = Integer.parseInt(strCrud.trim());
			switch (crud) {
			case 1 :
				ModelMemberBean m1 = new ModelMemberBean("10901","蛋黃區","29","244.34","9","1255");
				mDao.add(m1);
				break;
	
			case 2 :
				ModelMemberBean m2 = new ModelMemberBean();
				mDao.update(m2);
				break;
				
			case 3 :
				ModelMemberBean m3 = new ModelMemberBean(38, "蛋黃區");
				mDao.deleteByRegion(m3);
				break;
			case 4 :
				ModelMemberBean member = mDao.findById(4); //找ID=3
				System.out.println(member);
				break;
//			case 5 :
//				
//				List<ModelMemberBean> memberList =new ModelMemberBeanfindAll();
//				System.out.println(memberList);
			}

			break;
		case 4:
			System.out.println("輸入連結的資料庫");// 功能四.從檔案存入圖片MSSQL
			String connecSql4 = scanner.next();
			/*jdbc:sqlserver://localhost:1433;databaseName=Midterm;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true 
			  使用這個連結*/
			System.out.println("輸入檔案位置");
			String generation4 = scanner.next();
			// "C:\Eeit178ClassUpdate\Image\image01.jpg"
			IOConnectionMemberBean conn4 = new IOConnectionMemberBean();
			conn4.setUrl(connecSql4);
			mConnDao.createConn(conn4.getUrl());
			ImageMemberBean jpgin = new ImageMemberBean();
			jpgin.setUrl(generation4);
			mIMDao.imageStoreProcess(jpgin.getUrl());
			break;
		case 5:
			System.out.println("輸入檔案");// 功能五.從MSSQL讀取圖片並建立檔案
			String generation5 = scanner.next();
			// "C:\Eeit178ClassUpdate\Image\image02.jpg"
			System.out.println("輸入資料庫");
			String connecSql5 = scanner.next();
			/*jdbc:sqlserver://localhost:1433;databaseName=Midterm;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true 
			  使用這個連結*/
			IOConnectionMemberBean conn5 = new IOConnectionMemberBean();
			conn5.setUrl(connecSql5);
			mConnDao.createConn(conn5.getUrl());
			ImageMemberBean jpgout = new ImageMemberBean();
			jpgout.setUrl(generation5);
			mIMDao.imageOutPutProcess(jpgout.getUrl());

			break;
		}

		scanner.close();
		mConnDao.closeConn();
	}

	}

