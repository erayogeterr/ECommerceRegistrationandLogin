package GoogleAuth;

import entities.concretes.User;

public class GoogleAuthManager {
	
	public void register (User user) {
		System.out.println("User added with google : " + user.getFirstName() + " " + user.getLastName().toUpperCase());
	}
	
	public void login(User user) {
		System.out.println("The entry was via google : " + user.getEmail());
	}

}
