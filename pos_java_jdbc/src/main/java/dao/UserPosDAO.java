package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	private Connection connection;
	
	public UserPosDAO(){
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userPosJava) {
		try {
			String sql = "INSERT INTO userposjava (id, nome, email) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			for(int i=51; i<=100; i++) {
				ps.setInt(1, i);
				ps.setString(2, "nome"+i+1);
				ps.setString(3, "email"+i+"@email");
				ps.addBatch();
			}
			
			ps.executeBatch();
			connection.commit();
		}catch (Exception e){
			try {
				connection.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
