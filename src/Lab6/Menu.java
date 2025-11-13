package Lab6;

import Lab5.CaeserCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CaeserCipher caeser = new CaeserCipher();
    private static boolean encrypt;

    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }

    public static void menu() throws FileNotFoundException {
        int choice;
        do {
            System.out.println("""
                
                ---------------------------------------------------
                MENU:
                ---------------------------------------------------
                1. Encrypt
                2. Decrypt
                3. Brute force decrypting
                0. Exit
                """);
            System.out.print("Enter your choice: ");
            choice = handleUserChoice(1, new int[]{1, 2, 3, 0});

            if (choice != -1 && choice != 0) {
                if (choice == 1 || choice == 2) {
                    encrypt = choice == 1;
                    input_type_menu();
                }
                if (choice == 3) {
                    brute_force();
                }
            }
        } while (choice != 0);

        System.out.println("""
                
                ---------------------------------------------------
                BYE!
                ---------------------------------------------------
                """);
    }

    private static void input_type_menu() throws FileNotFoundException {

        int choice;
        do {
            System.out.println("""
                    
                    ---------------------------------------------------
                    INPUT TYPE:
                    ---------------------------------------------------
                    1. Text
                    2. File
                    0. Exit
                    """);
            System.out.print("Enter your choice: ");
            choice = handleUserChoice(1, new int[]{1, 2, 0});

            int key;
            do {
                System.out.print("\nEnter key [1-26]: ");
                key = handleUserChoice(2, new int[]{});
            } while (key == -1);

            if (choice == 1) {
                text_menu(key);
                break;
            } else if (choice == 2) {
                file_menu(key);
                break;
            }
        } while (choice != 0);
    }

    private static void text_menu(int key) {
        System.out.print("\nEnter your text: ");
        String text = scanner.nextLine();

        System.out.println("\n---------------------------------------------------\n");
        crypt(text, key);
    }

    private static void file_menu(int key) throws FileNotFoundException {
        System.out.print("\nEnter file name: ");
        String file_name =  scanner.nextLine();

        File file = new File(file_name);
        Scanner file_input = new Scanner(file);

        try {
            System.out.println("\n---------------------------------------------------\n");
            while (file_input.hasNext()) {
                String line = file_input.nextLine();
                crypt(line, key);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void crypt(String text, int key) {
        if (encrypt) {
            System.out.println(caeser.encrypt(text, key, true));
        } else {
            System.out.println(caeser.decrypt(text, key, true));
        }
    }

    private static void brute_force() {
        System.out.print("\nEnter your cipher text: ");
        String text = scanner.nextLine();

        System.out.println("\n---------------------------------------------------\n");
        for (int i = 1; i < 27; i++) {
            System.out.println(i + ": " + caeser.decrypt(text, i,  true));
        }
    }

    private static int handleUserChoice(int type, int[] list) {

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (type == 1) {
                for (int ch : list) {
                    if (choice == ch) {
                        return choice;
                    }
                }
            } else if (type == 2) {
                return choice;
            }
        }

        System.out.println("Invalid input.");
        return -1;
    }
}
