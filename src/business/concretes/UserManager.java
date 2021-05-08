package business.concretes;

import business.abstracts.UserService;
import core.AuthService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private AuthService authService;

	public UserManager( AuthService authService) {
		this.authService = authService;
	}
	 public UserManager(UserDao userDao) {
		this.userDao = userDao;
	 }

	@Override
	public void register(User user) {
		
		if(user.getPassword().length() < 6) {
			System.out.println("Your password must be at least 6 characters long.");
		}
		
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        
        if(!matcher.matches()) {
        	System.out.println("E-mail address must be in e-mail format. (example@example.com");
        	return;
        }
        
        if (userDao.getByMail(user.getEmail()) != null){
            System.out.println("This user already exists.");
            return;
        }
        
        if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
        	System.out.println("First and Last name must be longer than 2 characters");
        	return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 and then enter to verify the Sent Email");
        int choice = scanner.nextInt();
        if (choice != 1) {
        	System.out.println("Validation failed.");
        	return;
        }
        
        userDao.register(user);
		
	}

	@Override
	public void login(User user) {
		
		if(user.getEmail() == null || user.getPassword() == null) {
			System.out.println("The Email and password fiel must be filled in.");
			return;
		}
		
		if ( userDao != null ) {
			userDao.login(user);
		}
		
		if ( authService != null ) {
			authService.login(user);
		}
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User getByMail(String mail) {
		
		return userDao.getByMail(mail);
	}
	
	

}
