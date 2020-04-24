package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    // validity check of username and password
    private boolean invalid(String username, String password) {
        
        //Check username (length)
        if (username.length() > 2) {
            
            //Check characters
            for (int i = 0; i < username.length(); i++ ) {
                if (username.charAt(i) < 'a' || username.charAt(i) > 'z') {
                    return true;
                }
            }
            
            //Check if name is already taken
            for (User user : userDao.listAll()) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        
        //Check password (length)
        if (password.length() > 7) {
            
            //Check that password contains special characters (or numbers)
            for (int i = 0; i < password.length(); i++) {
                if ( (password.charAt(i) >= ' ' && password.charAt(i) <= '@') ||
                     (password.charAt(i) >= '[' && password.charAt(i) <= '`') ||
                     (password.charAt(i) >= '{' && password.charAt(i) <= '~') ) 
                {
                    return false;
                }
            }
            
        } else {
            return true;
        }
        
        return true;
        
    }
}
