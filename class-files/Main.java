import facade.Facade;
import facade.Login;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        String username;
        String password;
        System.out.println("Username :  ");
        username = sc.next();
        System.out.println("Password :  ");
        password = sc.next();
        Login login = new Login();
        facade.login(username, password);
    }
}
