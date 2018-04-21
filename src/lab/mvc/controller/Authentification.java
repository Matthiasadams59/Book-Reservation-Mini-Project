package lab.mvc.controller;

import java.util.HashMap;

import lab.mvc.model.User;

public class Authentification {
	
	HashMap<String, String> users = new HashMap();
	
	public Authentification() {
		users.put("Adams", "ISEP2019");
		users.put("Matthias", "ISEP2019");
		users.put("Franck", "ISEP2019");
	}
	
	public boolean authenticate(String userId, String password) {
		
		if (password == null || password.trim().equals("")) {
			return false;
		}
		if (users.containsKey(userId) && users.get(userId).equals(password) ) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public User getUserDetails(String userId) {
		User user = new User();
		user.setPassword(users.get(userId));
		user.setUserId(userId);
		return user;
	}

}
