import facade.Facade;
import facade.Login;
import facade.UserInfoItem;

import java.lang.Object;
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
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        String credentialsFilePath1 = "src/main/resources/username-pwd.txt";
        String menuFilePath = "src/main/resources/meat-produce-menu.txt";
        String sellerLoginsFilePath = "src/main/resources/seller.txt";
        HashMap userCredentials = new HashMap<String, String>();
        HashMap typeOfUser = new HashMap<String, String>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(credentialsFilePath1));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                userCredentials.put(key, value);
                typeOfUser.put(key, 0);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        reader.close();
        reader = new BufferedReader(new FileReader(sellerLoginsFilePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                userCredentials.put(key, value);
                typeOfUser.put(key, 1);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        Map<String, ArrayList<String>> menuItems = new HashMap<>();
        reader = new BufferedReader(new FileReader(menuFilePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                if(menuItems.containsKey(key)) {
                    ArrayList<String> items = menuItems.get(key);
                    items.add(value);
                    menuItems.put(key, items);
                }
                else {
                    menuItems.put(key, new ArrayList<>(Arrays.asList(value)));
                }
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        System.out.println(menuItems);

        String username;
        String password;
        String input;
        int choice;
        String userType;
        UserInfoItem userinfoitem = new UserInfoItem();
        System.out.println("Username :  ");
        username = sc.next();
        System.out.println("Password :  ");
        password = sc.next();

        if (!facade.login(username, password, userCredentials, typeOfUser)) {
            System.out.println("Login failed \nPlease check username and password");
            System.exit(0);
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
            while (true) {
                System.out.println("Enter 0 to Add Trade, 1 to ");
                choice = sc.nextInt();
                switch (choice) {

                    case 0:
                        facade.addTrading(menuItems);
                        break;
                    case 1:
                        facade.viewTrading(menuItems);
                        break;
                    default:
                        System.exit(0);
                }
            }

        }


    }

