import facade.Facade;
import facade.Login;
import facade.UserInfoItem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        String credentialsFilePath1 = "src/main/resources/username-pwd.txt";
        String credentialsFilePath2 = "src/main/resources/meat-produce-menu.txt";
        HashMap userCredentials = new HashMap<String, String>();
        userCredentials = readFile(userCredentials, credentialsFilePath1);
        HashMap menuItems = new HashMap<String, String>();
        menuItems = readFile(menuItems, credentialsFilePath1);

        String username;
        String password;
        String input;
        String userType;
        UserInfoItem userinfoitem = new UserInfoItem();
        System.out.println("Username :  ");
        username = sc.next();
        System.out.println("Password :  ");
        password = sc.next();

        if(!facade.login(username, password,userCredentials)){
//            System.out.println("Login failed \nPlease check username and password \nEnter new to register else exit");
//            input = sc.next();
//            if(input.equals("new")) {
//                System.out.println("Enter name of the user");
//                username = sc.next();
//                System.out.println("Enter the password that you want to set");
//                password = sc.next();
//                System.out.println("Are you a buyer or seller");
//                userType = sc.next();
//                userinfoitem.setName(username);
//                userinfoitem.setPassword(password);
//                userinfoitem.setType(userType);
//                facade.createUser(userinfoitem);
//                System.out.println("Successfully created user");
//            }
//            else
//                System.exit(0);
        }
        else {
            System.out.println("Login successful");
        }
    }

    public static HashMap readFile(HashMap map, String filepath) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        for (java.lang.Object key : map.keySet())
        {
            System.out.println(key + ":" + map.get(key));
        }
        reader.close();
        return map;
    }
}
