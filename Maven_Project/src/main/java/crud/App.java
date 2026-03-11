package crud;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("jdbc crud operations");
            System.out.println("1. Insert Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("enter product id");
                    int product_id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("enter product name");
                    String product_name = sc.nextLine();

                    System.out.println("enter product category");
                    String category = sc.nextLine();

                    System.out.println("enter price");
                    double price = sc.nextDouble();

                    System.out.println("enter quantity");
                    int quantity = sc.nextInt();

                    System.out.println("enter rating");
                    float rating = sc.nextFloat();
                    sc.nextLine();

                    System.out.println("enter manufacture");
                    String manufacturer = sc.nextLine();

                    Operations.addProduct(product_id,product_name,category,price,quantity,rating,manufacturer);
                    break;

                case 2:
                    Operations.display();
                    break;

                case 3:
                    Operations.updateEmployee();
                    break;

                case 4:
                    Operations.deleteEmployee();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }
    }
}
