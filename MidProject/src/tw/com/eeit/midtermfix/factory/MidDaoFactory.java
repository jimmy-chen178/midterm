package tw.com.eeit.midtermfix.factory;

import tw.com.eeit.midtermfix.connection.IOConnectionDao;
import tw.com.eeit.midtermfix.dao.ImageDao;
import tw.com.eeit.midtermfix.dao.ModelDao;
import tw.com.eeit.midtermfix.total.IMidDao;

public class MidDaoFactory {

	public static final int IOCD = 1;
	public static final int MD = 2;
	public static final int IMD = 3;

	public static IMidDao createfactoryDao(int whichFactory) {
		switch (whichFactory) {
		case IOCD:
			return new IOConnectionDao();
		case MD:
			return new ModelDao();
		case IMD:
			return new ImageDao();
		default:
			return null;
		}

	}

}
