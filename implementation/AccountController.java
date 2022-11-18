
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.prefs.BackingStoreException;

public class AccountController {

    private Compte logged_account;


    private ArrayList<Compte> accounts;
    private ArrayList<Resident> residents;
    private ArrayList<Consommateur> consommateurs;


    public AccountController() {
        this.accounts = new ArrayList<Compte>();
        this.residents = new ArrayList<Resident>();
        this.consommateurs = new ArrayList<Consommateur>();

    }

    public Boolean verify_password(String account, String password) {

        //找到相应的账户，并看对应的密码；
        for (Compte acc : accounts) {
            if (acc.getAccount() == account) {
                System.out.println("tamade");
                this.logged_account = acc;

                if (acc.getPassword() == password) {
                    return true;
                } else return false;
            }
        }

        return true;
    }

    public void create_new_consommateur(String account, String password) {
        Consommateur consommateur = new Consommateur(account, password);
        consommateurs.add(consommateur);
        accounts.add(consommateur);
    }


    public void create_new_resident(String account, String password) {
        Resident resident = new Resident(account, password);
        residents.add(resident);
        accounts.add(resident);

    }


    public Boolean est_consommateur(String account) {

        //找到相应的账户，并看对应的密码；
        return true;

    }


    public Compte get_account(String account_number) {
        for (Compte acc : accounts) {
            if (acc.getAccount() == account_number) {
                return acc;
            }
        }
        return null;
    }

    public int account_exist(String account_number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount() == account_number) {
                return i;
            }
        }

        return -1;


    }
}