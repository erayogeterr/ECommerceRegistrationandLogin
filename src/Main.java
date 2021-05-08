import java.util.ArrayList;
import java.util.Scanner;

import GoogleAuth.GoogleAuthManager;
import business.concretes.UserManager;
import dataAccess.concretes.InMemoryUserDao;
import core.GoogleAuthManagerAdapters;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(" 1 - Login");
		System.out.println(" 2 - Register");
		Scanner scanner = new Scanner(System.in);
		System.out.println("What action do you want to take :");
		int generalChoice = scanner.nextInt();
		
		if(generalChoice == 1 ) {
			System.out.println("1 - Login with Google ");
			System.out.println("2 - Login by Email and Password");
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Select the input method :");
			int choice1 = scanner1.nextInt();
			if( choice1 == 1 ) {
			//	User user1 = new User();
			//	user1.setEmail("asd@gmail.com");
				User user2 = new User();
				user2.setEmail("erayogeterr@gmail.com");
				user2.setPassword("123456789");
			UserManager userManager = new UserManager(new GoogleAuthManagerAdapters(new GoogleAuthManager()));
		//	userManager.login(user1);
			userManager.login(user2);
			} else if (choice1 == 2 ) {
			// User user = new User();
            //    user.setEmail("erayogeterr@gmail.com");
                User user2 = new User();
                user2.setEmail("erayogeterr@gmail.com");
                user2.setPassword("123456789");
                
                ArrayList<User> users = new ArrayList<>();
                UserManager userManager = new UserManager(new InMemoryUserDao(users));
              //  userManager.login(user);
                userManager.login(user2);
			}
		}
		else if ( generalChoice == 2 ) {
		
		 ArrayList<User> users = new ArrayList<>();
         UserManager userManager = new UserManager(new InMemoryUserDao(users));
        User user = new User(1, "Eray", "Ögeter", "erayogeterr@gmail.com", "123456789");
       User user2 = new User(1, "Er", "Ay", "erayogeterr@gmail.com", "1478528");
        userManager.register(user);
         userManager.register(user2);
		}
	}

}
