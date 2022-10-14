package facade;

public class Login {

    public boolean validateUser(String username, String password) {
        // SELECT * FROM user WHERE username = 'username' AND password = 'password';
        return username.equals("user") && password.equals("pwd");
    }
}
