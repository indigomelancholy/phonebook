import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Dictionary<String, Contact> phonebook = new Hashtable<>();
    Scanner scan = new Scanner(System.in);

    while(true){
        System.out.println("Menu:");
        System.out.println("1. Read the Phonebook");
        System.out.println("2. Add new entry");
        System.out.println("3. Update an entry");
        System.out.println("4. Remove an entry");
        System.out.println("5. Exit");

        System.out.println("What would you like to do?");
        int choice = scan.nextInt();

        switch(choice){
            case 1:
                viewCont(phonebook);
                break;

            case 2:
                addCont(scan, phonebook);
                break;

            case 3:
                updateCont(scan, phonebook);
                break;

            case 4:
                deleteCont(scan, phonebook);
                break;

            case 5:
                System.out.println("Closing the phonebook...");
                return;

            default:
                System.out.println("Invalid choice!");

        }
    }

    }

    public static void viewCont(Dictionary<String, Contact> phonebook){
        if(phonebook.isEmpty()){
            System.out.println("No entries.");
        }else {
            System.out.println("You have " + phonebook.size() + " contacts:");

            for (Enumeration<String> keys = phonebook.keys(); keys.hasMoreElements(); ) {
                System.out.println(phonebook.get(keys.nextElement()));
            }
        }
    }

    private static void addCont(Scanner scan, Dictionary<String, Contact> phonebook){
       scan.nextLine();
        System.out.println("Add the contact name: ");
        String name = scan.nextLine();

        System.out.println("Add the contact number: ");
        String num = scan.nextLine();

        if(phonebook.get(name) != null){
            System.out.println("Contact " + name + " is in the phonebook. " + "Enter another contact or update the preexisting contact.");
        }else{
            phonebook.put(name, new Contact(name, num));

            System.out.println("Contact " + name + " added.");
        }
    }

    private static void updateCont(Scanner scan, Dictionary<String, Contact> phonebook){
        System.out.println("Which contact would you like to update?");

        String name = scan.nextLine();
        Contact contact = phonebook.get(name);

        if(contact != null){
            System.out.println("Enter a new number: ");

            contact.setNum(scan.nextLine());

            System.out.println("The contact was updated!");
            System.out.println("New number: " + contact.getName() + " " + contact.getNum());
        }else{
            System.out.println("The contact you asked for was not found in the phonebook!");
        }
    }

    private static void deleteCont(Scanner scan, Dictionary<String, Contact> phonebook){
        System.out.println("What contact would you like to delete?");
        String name = scan.nextLine();

        if(phonebook.remove(name) != null){
            System.out.println("The contact was deleted!");
        }else{
            System.out.println("The contact you asked for was not found in the phonebook!");
        }
    }
    
}