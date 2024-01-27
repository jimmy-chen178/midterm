package tw.com.eeit.midtermfix.connection;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IOConnectionDao implements IIOConnectionDao {
	@Override
	public void createConn(String U) throws Exception {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connMB.setConn(DriverManager.getConnection(U.trim()));
		System.out.println("Connection Status:" + !connMB.getConn().isClosed());
	}

	@Override
	public void closeConn() throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		if (connMB.getConn() != null) {
			connMB.getConn();
		}
		System.out.println("Connection Closed");
	}

	@Override
	public void batchDownload(IOConnectionMemberBean M) throws IOException {
		List<String> downloadList = new ArrayList<>();
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		downloadList.add((M.getUrl()).trim());
		for (String downloadUrl : downloadList) {
			URL url = new URL(downloadUrl);
			URLConnection conn = url.openConnection();
			InputStream inputStream = conn.getInputStream();
			connMB.setFileName(downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1));
			FileOutputStream outputStream = new FileOutputStream(
					(M.getGeneration()).trim() + "\\" + connMB.getFileName());
			byte[] buffer = new byte[inputStream.available()];
			int length;
			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);

			}
			inputStream.close();
			outputStream.close();

		}
	}

	@Override
	public void Cts(String Url) throws Exception {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		int count = 0;
		FileReader fr = new FileReader(Url.trim());
		BufferedReader brdFile = new BufferedReader(fr);
		String strLine = null;
		while ((strLine = brdFile.readLine()) != null) {

			if (count >= 1) { // count == 0 means the first line

				String[] array = strLine.split(",");
				// System.out.println(strLine);//在console確認輸出
				for (int i = 0; i < array.length; i++) {
					// System.out.println(array[i]);
				}
				String qryInsert = "insert into Jan109 (YM,Region,LandAmount,LandArea,BuildingAmount,BuildingArea)values(?,?,?,?,?,?)";

				PreparedStatement pstmt = connMB.getConn().prepareStatement(qryInsert);

				pstmt.setInt(1, Integer.parseInt(array[0].trim()));
				pstmt.setString(2, (array[1].trim()));
				pstmt.setInt(3, Integer.parseInt(array[2].trim()));
				pstmt.setFloat(4, Float.parseFloat(array[3].trim()));
				pstmt.setInt(5, Integer.parseInt(array[4].trim()));
				pstmt.setFloat(6, Float.parseFloat(array[5].trim()));

				pstmt.executeUpdate();
			}
			count++;
		}
		;

		brdFile.close();
		closeConn();
	}

	@Override
	public void outputTable() throws SQLException, IOException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		String sqlstr = "Select *from Gallery Where galleryId=? ";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setInt(1, 1);
		ResultSet rs = state.executeQuery();
		if (rs.next()) {
			Blob blob = rs.getBlob(3);
			System.out.println("blob.length():" + (int) blob.length());
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/Temp/image02.jpg"));
			bos1.write(blob.getBytes(1, (int) blob.length()));
			bos1.flush();
			bos1.close();
			rs.close();
			state.close();
		}
	}

}
