
import javax.print.DocFlavor;
import java.nio.charset.StandardCharsets;
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
            if (acc.getAccount().equals(account)) {
                this.logged_account = acc;
                if (acc.getPassword().equals(password)) {
                    return true;
                }
                else return false;
            }
        }

        return false;
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



    public Compte get_account(String account_number) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount().equals(account_number)) {
                return accounts.get(i);
            }
        }
        return null;
    }



    public void afficher_consommateurs(){


        System.out.println("============================================================");
        for (int i = 1 ; i <= consommateurs.size(); i++){
            System.out.println( i + ",   consommateurs" + i );
        }

        System.out.println("============================================================");
        System.out.println( "Choisir le consommateur que vous voulez savoir plus" );
        Scanner scan = new Scanner(System.in);

        String number = scan.next();
        int num = Integer.parseInt(number);
        consommateurs.get(num-1).print_details();
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