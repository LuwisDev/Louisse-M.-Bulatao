package colorandpens;

import java.util.Scanner;

public class ColorAndPens {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ObjectHandler hand = new ObjectHandler();

        while (true) {
            System.out.println("\n--- WISWISWIS ---");
            System.out.println("\n--- COLOR AND PEN ---");
            System.out.println("1. Input Item");
            System.out.println("2. Check Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            if (choice == 1) {
                hand.createItem();
            }
            else if (choice == 2) {
                hand.readItem();
            }
            else if (choice == 3) {
                hand.updateItem();
            }
            else if (choice == 4) {
                hand.deleteItem();
            }
            else if (choice == 5) {
                System.out.println("Thank you!");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}