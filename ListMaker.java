import java.util.Scanner;
import java.util.ArrayList;

public class ListMaker {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        boolean quit = false;

        while (!quit) {

            displayList(list);
            displayMenu();

            String choice = SafeInput.getRegExString(console, "Choose", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem(list, console);
                    break;

                case "D":
                    deleteItem(list, console);
                    break;

                case "I":
                    insertItem(list, console);
                    break;

                case "P":
                    printList(list);
                    break;

                case "Q":
                    if (SafeInput.getYNConfirm(console, "Are you sure you want to quit?")) {
                        quit = true;
                    }

                    break;
            }


        }

        System.out.println("Thank you!");

        console.close();

    }

    private static void displayMenu() {
        System.out.println("A - Add an Item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void displayNumberedList(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ", " + list.get(i));
        }
    }


    private static void displayList(ArrayList<String> list) {

        System.out.println("============List===========");

        if (list.isEmpty()) {
            System.out.println("There is nothing here!");
            System.out.println("Would you like to put something in?");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ", " + list.get(i));
            }
        }

    }

    private static void addItem(ArrayList<String> list, Scanner console) {
        String item = SafeInput.getNonZeroLenString(console, "Enter an item to add: ");

        list.add(item);

        System.out.println("Item successfully added!");

    }

    private static void deleteItem(ArrayList<String> list, Scanner console) {

        if (list.isEmpty()) {
            System.out.println("The list is empty, nothing to delete!");
        } else {
            displayNumberedList(list);

            int itemNumber = SafeInput.getRangedInt(console, "Enter the number of the item to delete: ", 1, list.size());

            list.remove(itemNumber - 1);

            System.out.println("Item was deleted!");

        }
    }

    private static void insertItem(ArrayList<String> list, Scanner console) {


        int location = SafeInput.getRangedInt(console, "Where would uou like to insert the item?", 1, list.size() + 1);


        String item = SafeInput.getNonZeroLenString(console, "What Item do you want to insert?: ");


        list.add(location - 1, item);

        IO.println("Item inserted!");

    }

    private static void printList(ArrayList<String> list) {

        if (list.isEmpty()) {
            System.out.println("Your list is empty");
        } else {
            displayNumberedList(list);
        }
    }
}