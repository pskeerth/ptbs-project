import facade.Facade;
import facade.Login;
import facade.UserInfoItem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/ptbs";
        String uname = "root";
        String pass = "poori1998)";
        String query = "select name from ptbs.userdetails where pwd ='poot'";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, uname, pass);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        Facade facade = new Facade();
        String username;
        String password;
        String input;
        String userType;
        UserInfoItem userinfoitem = new UserInfoItem();
        System.out.println("Username :  ");
        username = sc.next();
        System.out.println("Password :  ");
        password = sc.next();
        Login login = new Login();

        if(!facade.login(username, password)){
            System.out.println("Login failed \nPlease check username and password \nEnter new to register else exit");
            input = sc.next();
            if(input.equals("new")) {
                System.out.println("Enter name of the user");
                username = sc.next();
                System.out.println("Enter the password that you want to set");
                password = sc.next();
                System.out.println("Are you a buyer or seller");
                userType = sc.next();
                userinfoitem.setName(username);
                userinfoitem.setPassword(password);
                userinfoitem.setType(userType);
                facade.createUser(userinfoitem);
                System.out.println("Successfully created user");
            }
            else
                System.exit(0);
        } else {
            System.out.println("Login successful");
        }
    }
}
