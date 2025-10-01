package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();
		
		userPosDao.salvar(userPosJava);
	}
}
