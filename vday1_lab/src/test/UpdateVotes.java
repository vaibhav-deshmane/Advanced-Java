package test;

import java.sql.SQLException;
import java.util.Scanner;

import dao.CandidateDaoImpl;
import dao.CandidateDao;

public class UpdateVotes {
public static void main(String[]args) {
	try(Scanner sc=new Scanner(System.in)){
		CandidateDaoImpl cdi=new CandidateDaoImpl();
		System.out.println("enter datails id");
		System.out.println(cdi.updateVotes(sc.nextInt()));
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
