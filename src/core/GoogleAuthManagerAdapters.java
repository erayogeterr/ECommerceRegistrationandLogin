package core;

import GoogleAuth.GoogleAuthManager;
import entities.concretes.User;

public class GoogleAuthManagerAdapters implements AuthService {
	
	private final GoogleAuthManager googleAuthManager;
	

	public GoogleAuthManagerAdapters(GoogleAuthManager googleAuthManager) {
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
	}

}
