package paswrdmngr.models.mngr;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String RESET = "\033[0m";  // Text Reset
    private String website;
    private String username;    
    private String password;    
    private int index;


    public Account(String website, String username, String password) {
        if (website == null || username == null || password == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.format(PURPLE + "%-5d %-25s %-30s %-30s", index, website, username, password + RESET);
    }
}
