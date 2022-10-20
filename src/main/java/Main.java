import facade.Facade;
import facade.Product;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        Product product;
        int choice;
        String userType;
        String input;

        if (!facade.login()) {
            System.out.println("Login failed \nType \"new\" for new user \nType \"exit\" to exit the application");
            input = sc.next();
            if(input.equals("new")) {
                facade.createUser();
            }
            else
                System.exit(0);
        }
        System.out.println("Login Successful");

        userType = facade.getUserType();
        while (true) {
            System.out.println("Enter 0 to Add Trade, 1 to View Trade ");
            choice = sc.nextInt();
            switch (choice) {

                case 0:
                    facade.addTrading();
                    break;
                case 1:
                    facade.viewTrading();
                    break;
                case -1:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option");
            }
        }

    }

}

