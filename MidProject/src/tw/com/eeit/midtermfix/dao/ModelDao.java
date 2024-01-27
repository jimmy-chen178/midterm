package tw.com.eeit.midtermfix.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.eeit.midtermfix.connection.IOConnectionMemberBean;

public class ModelDao implements IModelDao {

	@Override
	public void add(ModelMemberBean m) throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		String sqlstr = "Insert into Jan109(yM, region, landAmount, landArea,  buildingAmount,  buildingArea) Values(?,?,?,?,?, ?)";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setString(1, m.getYM());
		state.setString(2, m.getRegion());
		state.setString(3, m.getLandAmount());
		state.setString(4, m.getLandArea());
		state.setString(5, m.getBuildingAmount());
		state.setString(6, m.getBuildingArea());
		state.executeUpdate();
		state.close();
	}

	@Override
	public void update(ModelMemberBean m) throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		String sqlstr = "Update Jan109 set YM=? ,region=?,landAmount=?, landArea=?,buildingAmount=?,  buildingArea=? Where Jan109Id=? ";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setString(1, String.valueOf("10901"));
		state.setString(2, String.valueOf("蛋黃區"));
		state.setString(3, String.valueOf("1"));
		state.setString(4, String.valueOf("2"));
		state.setString(5, String.valueOf("3"));
		state.setString(6, String.valueOf("4"));
		state.setInt(7, 8);
		state.execute();
		state.close();
	}

	@Override
	public void deleteByRegion(ModelMemberBean m) throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		String sqlstr = "Delete from Jan109 where Jan109Id=? and region=?";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setInt(1, m.getJan109Id());
		state.setString(2, m.getRegion());
		state.executeUpdate();
		state.close();
	}

	@Override
	public ModelMemberBean findById(int Jan109Id) throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		final String sqlstr = "Select * from Jan109 where Jan109Id=? ";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		state.setInt(1, Jan109Id);
		ResultSet rs = state.executeQuery();
		if (rs.next()) {
			ModelMemberBean member = new ModelMemberBean();
			member.setJan109Id(rs.getInt("Jan109Id"));
			member.setYM(rs.getString("YM"));
			member.setRegion(rs.getString("Region"));
			member.setLandAmount(rs.getString("LandAmount"));
			member.setLandArea(rs.getString("LandArea"));
			member.setBuildingAmount(rs.getString("BuildingAmount"));
			member.setBuildingArea(rs.getString("BuildingArea"));
			return member;
		}
		rs.close();
		state.close();
		return null;

	}

	@Override
	public List<ModelMemberBean> findAll() throws SQLException {
		IOConnectionMemberBean connMB = new IOConnectionMemberBean();
		final String sqlstr = "Select * from Jan109 where Jan109Id=? ";
		PreparedStatement state = connMB.getConn().prepareStatement(sqlstr);
		ResultSet rs = state.executeQuery(sqlstr);
		List<ModelMemberBean> memberList = new ArrayList<ModelMemberBean>();
		while (rs.next()) {
			ModelMemberBean member = new ModelMemberBean();
			member.setJan109Id(rs.getInt("Jan109Id"));
			member.setYM(rs.getString("YM"));
			member.setRegion(rs.getString("Region"));
			member.setLandAmount(rs.getString("LandAmount"));
			member.setLandArea(rs.getString("LandArea"));
			member.setBuildingAmount(rs.getString("BuildingAmount"));
			member.setBuildingArea(rs.getString("BuildingArea"));
			memberList.add(member);
		}
		rs.close();
		state.close();
		return memberList;

	}

}
