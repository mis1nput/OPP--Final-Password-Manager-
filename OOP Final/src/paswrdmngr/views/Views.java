package paswrdmngr.views;

import java.util.List;
import java.util.Scanner;
import javax.management.relation.RelationSupportMBean;

public class Views {
    public static final String RED = "\033[0;31m";     // RED
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String RESET = "\033[0m";  // Text Reset

    Scanner scanner = new Scanner(System.in);

    public String show() {
        clearScreen();
        System.out.println(BLUE + "  Password Manager" + RESET);
        System.out.println(CYAN + "  -----------------" + RESET);
        System.out.println("1. Add Account");
        System.out.println("2. Edit Account");
        System.out.println("3. Show Account");
        System.out.println("4. Delete Account");
        System.out.println("5. Exit");
        return scanner.nextLine();
    }

    public void showAccount(String account) {
        System.out.println(account);
        System.out.println(BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + RESET);
    }

    public void showHeader() {
        System.out.println(String.format(CYAN + "%-5s %-25s %-30s %-30s",
            "No. ", "Website", "Username", "Password" + RESET));
        System.out.println(BLUE + "---------------------------------------------------------------------------------------------" + RESET);
    }

    public String getWebsite() {
        System.out.println("Enter website: ");
        return scanner.nextLine();
    }

    public String getUsername() {
        System.out.println("Enter username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("Enter password: ");
        return scanner.nextLine();
    }

    public String passwordOptions(){
        System.out.println("Would You like a Generated Password? Y/N");
            return scanner.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String accountSelection(){
        System.out.println("Enter account number for Edits: ");
        return scanner.nextLine();
    }

    public String accountSelectionMenu() {
        System.out.println(CYAN + "   Edit Options" + RESET);
        System.out.println(BLUE + "------------------" + RESET);
        System.out.println("1. Edit Website");
        System.out.println("2. Edit Username");
        System.out.println("3. Edit Password");
        System.out.println("4. Back");
        return scanner.nextLine();
    }

    public void spacer() {
        System.out.println(" ");
        scanner.nextLine();
    }
    

    public String deleteCheck(){
        System.out.println(RED + "Are You Sure you Wanna delete this?  Y/N" + RESET);
        return scanner.nextLine();
    }

    public void invalidOption(){
        System.out.println(RED + "Please Enter a valid Option" + RESET);
    }

}
