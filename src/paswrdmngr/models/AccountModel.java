package paswrdmngr.models;

import java.util.List;

public class AccountModel {

    private List<Account> accounts;



    public void saveAccounts() {
        FileHandler.saveToFile(accounts);
    }

    public void addAccount(String website, String username, String password) {
        accounts.add(new Account(website, username, password));
        saveAccounts(); // Save after adding
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void removeAccount(String website, String username, String password) {
        accounts.remove(new Account(website, username, password));
        saveAccounts(); // Save after removing
    }

    public void getAccount(String website, String username, String password) {
        accounts.get(accounts.indexOf(new Account(website, username, password)));
    }
    
}
