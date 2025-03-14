package paswrdmngr.controller;

import java.util.ArrayList;
import java.util.Scanner;
import paswrdmngr.models.gnrtr.PasswordGenerator;
import paswrdmngr.views.Views;
import paswrdmngr.models.mngr.Account;
import paswrdmngr.models.mngr.FileHandler;

public class Controller {
    private Views view = new Views();
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private PasswordGenerator pswGentr = new PasswordGenerator();

    public Controller(){
        accounts = FileHandler.loadFromFile();
    }

    public void run(){
        while(true){
            selectionMenu();
        }
    }

    public void selectionMenu(){
        String input = view.show();

        if(null != input)switch (input) {
            case "1":{
                view.clearScreen();
                String website = getDetails("W",view.getWebsite(),0,false);
                view.clearScreen();
                String username = getDetails("U", view.getUsername(),0,false);
                String password = getDetails("P", passwordOptions(),0,false);
                addAccount(website, username, password);
                showAccount();
                view.spacer();
                    break;
                }
            case "2":{
                view.clearScreen();
                showAccount();
                try {
                    String choice1 = view.accountSelection();
                    int choice = Integer.parseInt(choice1);
                    editAccount(choice);
                } catch (Exception e) {
                    view.showAccount("Invalid account number");
                    view.spacer();
                }
                    break;
                }
            case "3":
                showAccount();
                Scanner scanner = new Scanner(System.in);
                System.out.println(" ");
                scanner.nextLine();
                break;
            case "4":
                view.clearScreen();
                showAccount();
                try {
                    String choice1 = view.accountSelection();
                    int choice = Integer.parseInt(choice1);
                    deleteAccount(choice);
                } catch (Exception e) {
                    view.showAccount("Invalid account number");
                    view.spacer();
                }
                break;
            case "5":
                FileHandler.saveToFile(accounts);
                System.exit(0);
                break;
            default:
                break;
        }

    }

    public void addAccount(String website, String username, String password) {

        for (Account account : accounts) {
            if (account.getWebsite().equals(website) && account.getUsername().equals(username)) {
                view.showAccount("Account already exists");
                return;
            }
        }
        Account account = new Account(website, username, password);
        accounts.add(account);
        FileHandler.saveToFile(accounts);
    }

    public String getDetails(String info,String input, int index, boolean isEdit){
        String infoData = "";
        Account account = accounts.get(index);
        while (true) { 
            if (input.isEmpty()){
                view.invalidOption();
                view.spacer();
                view.clearScreen();
                if(isEdit == true){
                    view.showAccount(account.toString());
                }else if (isEdit == false){
                    view.clearScreen();
                }
                if (info.equals("W")){
                    input = view.getWebsite();
                }else if (info.equalsIgnoreCase("U")){
                    input = view.getUsername();
                }else if (info.equalsIgnoreCase("E")){
                    input = passwordOptions();
                }
            } else {
                infoData = input;
                break;
            }
        }
        return infoData;
    }

    public void editAccount(int accountNumber) {
        
        if (accounts.isEmpty()) {
            view.showAccount("No accounts to edit");
            return;
        }
        else if  (accountNumber > accounts.size() ||accountNumber < 1) {
            view.showAccount("Invalid account number");
        }

        Account account = accounts.get(accountNumber - 1);
        view.clearScreen();
        view.showAccount(account.toString());
        String input = view.accountSelectionMenu();
        switch (input) {
            case "1":
                view.clearScreen();
                view.showAccount(account.toString());
                String website = getDetails("W", view.getWebsite(),accountNumber - 1, true);
                account.setWebsite(website);
                FileHandler.saveToFile(accounts);
                showAccount();
                view.spacer();
                break;
            case "2":
                view.clearScreen();
                view.showAccount(account.toString());
                String username = getDetails("U", view.getUsername(),accountNumber -1,true);
                account.setUsername(username);
                FileHandler.saveToFile(accounts);
                showAccount();
                view.spacer();
                break;
            case "3":
                view.clearScreen();
                view.showAccount(account.toString());
                String password = getDetails("P", passwordOptions(),accountNumber - 1,true);
                account.setPassword(password);
                FileHandler.saveToFile(accounts);
                showAccount();
                view.spacer();
                break;
            case "4":
                view.clearScreen();
                break;
            default:
                break;
        }
    }

    public void showAccount(){
        if (accounts.isEmpty()) {
            view.showAccount("No accounts found");
            return;
        }

        view.clearScreen();
        view.showHeader();
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).setIndex(i + 1);
            view.showAccount(accounts.get(i).toString());
        }
    }


    public void deleteAccount(int accountNumber) {
        if (accounts.isEmpty()) {
            view.showAccount("No accounts to edit");
            return;
        }
        else if  (accountNumber > accounts.size() ||accountNumber < 1) {
            view.showAccount("Invalid account number");
        }

        Account account = accounts.get(accountNumber - 1);
        view.clearScreen();
        view.showAccount(account.toString());

        boolean done = false;
        while(!done){
            String check = view.deleteCheck();
            if (check.equalsIgnoreCase("Y")){
                accounts.remove(accountNumber - 1);
                FileHandler.saveToFile(accounts);
                done = true;
            }else if(check.equalsIgnoreCase("N")){
                System.out.println("Aborting...");
                view.spacer();
                done = true;
            }else{
                view.invalidOption();
                view.spacer();
            }
        }

        view.clearScreen();
        showAccount();
        

    }

    public String passwordOptions(){
        String psw = "";
        view.clearScreen();
        while(true){
            String input = view.passwordOptions();
            if (input.equalsIgnoreCase("Y")){
                psw = pswGentr.generator();
            } else if (input.equalsIgnoreCase("N")) {
                view.clearScreen();
                psw = view.getPassword();
                break;
            } else {
                view.invalidOption();
                view.spacer();
            }
            if (!psw.isEmpty()) {
                break;
            }
        }
        return psw;
    }

}
