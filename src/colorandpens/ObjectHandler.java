package colorandpens;

import java.util.Scanner;

public class ObjectHandler {

    Scanner scan = new Scanner(System.in);

    // mag store to ng items pero naka size tas nakadepends sa size kung ilan ang pwede
    // capHolder array para macall variables sa kabila then dun ma store
    capHolder[] items = new capHolder[6];

    int itemCount = 0;


    public void createItem() {

        System.out.println("\n--- CREATE ITEM ---");
//        kapag full si array proceed to
        if (itemCount == 6) {
            System.out.println("Storage is full.");
            
            //para di continue sa baba
            return;
        }
//      nag create ng item then lagay sa index same thing sa the rest
        items[itemCount] = new capHolder();

        System.out.print("Enter Item ID: ");
        items[itemCount].itemID = scan.nextInt();

        System.out.print("Enter Item Name: ");
        items[itemCount].itemName = scan.next();

        System.out.print("Enter Item Price: ");
        items[itemCount].itemPrice = scan.nextInt();

        System.out.print("Is the item available? (true/false): ");
        items[itemCount].isAvail = scan.nextBoolean();
        
//      mag add for the next position to
        itemCount++;

        System.out.println("Item created!");
    }

    public void readItem() {

        System.out.println("\n--- ITEM LIST ---");
//      then kapag ang count ay zero proceed here kasi no available naman
        if (itemCount == 0) {
            System.out.println("No items available.");
            // proceed at first again ulet
            return;
        }
//        i get si items by loop so kapag madami item then list all
        for (int i = 0; i < itemCount; i++) {

            System.out.println("Item ID: " + items[i].itemID);
            System.out.println("Item Name: " + items[i].itemName);
            System.out.println("Item Price: ₱" + items[i].itemPrice);
            System.out.println("Available: " + items[i].isAvail);
            System.out.println();
        }
    }


    public void updateItem() {

        System.out.println("\n--- CHECK/UPDATE ITEM ---");

        System.out.print("Enter Item ID: ");
        int id = scan.nextInt();
        
 //     stored item reads here pero if mismatch ang id then proceed sa baba sout na agad
        for (int i = 0; i < itemCount; i++) {
            
            if (items[i].itemID == id) {

                System.out.print("Enter new Item Name: ");
                items[i].itemName = scan.next();

                System.out.print("Enter new Item Price: ₱");
                items[i].itemPrice = scan.nextInt();

                System.out.print("Is the item available? (true/false): ");
                items[i].isAvail = scan.nextBoolean();

                System.out.println("Item updated!");

                return;
            }
        }

        System.out.println("Item ID not found.");
    }

    public void deleteItem() {

        System.out.println("\n--- DELETE ITEM ---");

        System.out.print("Enter Item ID: ");
        int id = scan.nextInt();
//      same thing sa update search here pero delete ang purpose
        for (int i = 0; i < itemCount; i++) {
            // check dito kung match ang id ang kaso ay wrong id ay possible ang item loss if ibang item id ang nailagay pala so dapat kabisado si item id
            // pero if match naman delete parin and proceed sa baba kapag mismatch or wala sa na store
            if (items[i].itemID == id) {

                for (int j = i; j < itemCount - 1; j++) {

                    items[j] = items[j + 1];
                }
                // tas delete nato
                items[itemCount - 1] = null;
                // bawas sa count ng items
                itemCount--;

                System.out.println("Item deleted!");
                
                return;
            }
        }

        System.out.println("Item ID not found.");
    }
}