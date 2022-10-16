package facade;

import java.util.HashMap;

public class Login {

    public boolean validateUser(String username, String password, HashMap userCredentials) {

        if(userCredentials.containsKey(username)) {
            if(userCredentials.get(username).equals(password))
                return true;
            return false;
        }
        return false;
    }
}
