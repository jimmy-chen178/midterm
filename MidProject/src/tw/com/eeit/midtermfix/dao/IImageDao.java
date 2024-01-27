package tw.com.eeit.midtermfix.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import tw.com.eeit.midtermfix.total.IMidDao;

public interface IImageDao extends IMidDao{
	public void imageOutPutProcess(String gen) throws SQLException, IOException;
	public void imageStoreProcess(String gen) throws SQLException, FileNotFoundException ;
}
