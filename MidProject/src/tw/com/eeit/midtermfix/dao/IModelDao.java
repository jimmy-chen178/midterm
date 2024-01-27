package tw.com.eeit.midtermfix.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.eeit.midtermfix.total.IMidDao;

public interface IModelDao extends IMidDao{

	public void add(ModelMemberBean m) throws SQLException;

	public void update(ModelMemberBean m) throws SQLException;

	public void deleteByRegion(ModelMemberBean m) throws SQLException;

	public ModelMemberBean findById(int Jan109Id) throws SQLException;
	
	public List<ModelMemberBean> findAll() throws SQLException ;
}
