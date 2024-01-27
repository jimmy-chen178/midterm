package tw.com.eeit.midtermfix.connection;

import java.io.IOException;
import java.sql.SQLException;

import tw.com.eeit.midtermfix.total.IMidDao;

public interface IIOConnectionDao extends IMidDao{
	public void createConn(String Url) throws Exception;
	public void closeConn() throws SQLException;
	public void batchDownload(IOConnectionMemberBean M) throws IOException;
	public void Cts(String Url) throws Exception;
	public void outputTable() throws SQLException, IOException;

}
