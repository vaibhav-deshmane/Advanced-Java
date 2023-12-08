package dao;

import java.sql.Connection;
import static utils.DBUtils.openConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Candidates;

public class CandidateDaoImpl {
private Connection cn;
private PreparedStatement pst1;
private PreparedStatement pst2;
private PreparedStatement pst3;
List<Candidates>list=new ArrayList<>();

public CandidateDaoImpl()throws SQLException{
	cn=openConnection();
	pst1=cn.prepareStatement("select * from candidates");
	pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
	pst3=cn.prepareStatement("select * from candidates order by votes desc limit 2");
}


public List<Candidates>getAllCandidate()throws SQLException{
	try (ResultSet rs=pst1.executeQuery())
			{
		while(rs.next()) {
			list.add(new Candidates(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
	}
	return list;
}

public String updateVotes(int id) throws SQLException{
	pst2.setInt(1, id);
	int rowCount=pst2.executeUpdate();
	if(rowCount==1)
		return "votes are updated";
	return "votes are not updated";
	
}

public List<Candidates> getMax2Voters() throws SQLException{
	try(ResultSet rs=pst3.executeQuery()){
		while(rs.next()) {
			list.add(new Candidates(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
	}
	return list;
}
public void cleanup() throws SQLException{
	if(pst1!=null) {
		pst1.close();
		
	}
	cn.close();
}



}
