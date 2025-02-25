package paswrdmngr.models;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String website;
    private String username;    
    private String password;

    public Account(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }
}
