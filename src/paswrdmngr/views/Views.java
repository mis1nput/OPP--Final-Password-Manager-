package paswrdmngr.views;

public class Views {

    public void show() {
        clearScreen();
        System.out.println("Welcome to Password Manager");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showMenu() {
        System.out.println("1. Add new password");
        System.out.println("2. Show all passwords");
        System.out.println("3. Search password");
        System.out.println("4. Delete password");
        System.out.println("5. Exit");
    }





}
