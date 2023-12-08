package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class DeleteVoterDetails {
public static void main(String []args) {
	try( Scanner sc= new Scanner (System.in)){
		UserDaoImpl userDao=new UserDaoImpl();
		System.out.println("enter email");
		System.out.println(userDao.deleteVoterDetails(sc.next()));
		userDao.cleanUp();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
