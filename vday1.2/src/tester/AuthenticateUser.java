package tester;

import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class AuthenticateUser {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter email and password"); 
			User user = userDao.authenticateUser(sc.next(), sc.next());
			if(user==null)
				System.out.println("invalid login..!!!");
			else {
				System.out.println("login Successful");
				System.out.println("user Details"+ user);
			}
			userDao.cleanUp();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	}


