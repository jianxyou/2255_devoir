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


    public AccountController(){
        this.accounts = new ArrayList<Compte>();
        this.residents = new ArrayList<Resident>();
        this.consommateurs = new ArrayList<Consommateur>();

    }

    public Boolean verify_password(String account ,String password){

        //找到相应的账户，并看对应的密码；
        for (Compte acc : accounts){
            if (acc.getAccount() == account){

                logged_account = acc;

                if (acc.getPassword() == password){
                    return true;
                }
                else return false;
            }
        }

        return true;
    }

    public void create_new_consommateur(String account,String password){
        Consommateur consommateur = new Consommateur(account,password);
        consommateurs.add(consommateur);
    }


    public void create_new_resident(String account,String password){
        Resident resident = new Resident(account,password);
        residents.add(resident);
    }


    public Boolean est_consommateur(String account){

        //找到相应的账户，并看对应的密码；
        return true;

    }

    public void enregistrer_un_bac(){
        System.out.println("Quel type de bac");
        System.out.println("1,haha");
        System.out.println("2 lala");
        System.out.println("3 wtf");

        Scanner scan = new Scanner(System.in);
        String type_de_bac = scan.next();

        System.out.println("Donnez votre CodeQr s'il vous plait");
        System.out.println("!!! note, plz enter \"haha\" parce que c'est pour testDonnez votre CodeQr s'il vous plait");
        String codeQR = scan.next();

        Bac bacc = new Bac(type_de_bac,codeQR);
        Resident resident = (Resident) logged_account;
        resident.ajout_un_bac(bacc);

        System.out.println("reussi");
    }


    public void supprimer_un_bac(){

    }




}