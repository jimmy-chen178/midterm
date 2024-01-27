package tw.com.eeit.midtermfix.dao;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.eeit.midtermfix.connection.IOConnectionMemberBean;

public class ImageDao implements IImageDao {
	@Override
	public void imageStoreProcess(String gen) throws SQLException, FileNotFoundException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		FileInputStream fis1 = new FileInputStream(gen.trim());
		String sqlstr = "insert into Gallery(imageName, imageFile) values(?,?)";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setString(1, "images01");
		state.setBinaryStream(2, fis1);
		state.executeUpdate();
		state.close();
		System.out.println("File Stored");
	}

	@Override
	public void imageOutPutProcess(String gen) throws SQLException, IOException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		String sqlstr = "Select *from Gallery Where galleryId=? ";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setInt(1, 1);
		ResultSet rs = state.executeQuery();
		if (rs.next()) {
			Blob blob = rs.getBlob(3);
			System.out.println("blob.length():" + (int) blob.length());
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(gen.trim()));
			bos1.write(blob.getBytes(1, (int) blob.length()));
			bos1.flush();
			bos1.close();
			rs.close();
			state.close();
		}
	}

}
