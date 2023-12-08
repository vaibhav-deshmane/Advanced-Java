package dao;
import java.sql.*;

import pojos.User;

import static utils.DBUtils.openConnection;
import static utils.DBUtils.closeConnection;
public class UserDaoImpl {
	private Connection cn;
	private PreparedStatement pst1,pst2;
	public UserDaoImpl() throws SQLException {
		cn = openConnection();
		pst1=cn.prepareStatement("select * from users where email=? and password=?");
		pst2=cn.prepareStatement("delete from users where email=?");
	}
	public User authenticateUser(String email,String password) throws SQLException{
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())
				return new User(rst.getInt(1),rst.getString(2),rst.getString(3),email,password,
						rst.getDate(6),rst.getBoolean(7),rst.getString(8));
		}
		return null;
	}
	public String deleteVoterDetails(String email)throws SQLException{
		pst2.setString(1,email);
		int rowCount=pst2.executeUpdate();
		if(rowCount == 1)
			return "voter details deleted";
		
		return "deletion failed";
		
	}
	
	public void cleanUp() throws SQLException{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		closeConnection();
		System.out.println("user dao cleaned up....");
	}
}
