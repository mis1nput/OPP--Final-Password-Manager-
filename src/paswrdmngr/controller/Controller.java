package paswrdmngr.controller;

import java.util.List;
import paswrdmngr.models.AccountModel;
import paswrdmngr.views.Views;

public class Controller {
    private Views view = new Views();
    private List<AccountModel> accounts;

    public void run(){
        view.show();
    }
}
