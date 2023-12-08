package test;

import java.sql.SQLException;
import java.util.List;

import dao.CandidateDaoImpl;
import pojo.Candidates;

public class Tester {
public static void main(String[]args) {
	try {
		CandidateDaoImpl cdi=new CandidateDaoImpl();
		List<Candidates>candidate=cdi.getAllCandidate();
		candidate.forEach(p->System.out.println(p));
		System.out.println("top 2 voters");
		System.out.println(cdi.getMax2Voters());
		
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
