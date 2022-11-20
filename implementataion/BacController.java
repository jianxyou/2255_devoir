

import java.util.Scanner;

public class BacController {

    private Resident logged_resident;

    public BacController(){

    }


    public void enregistrer_un_bac(){
        System.out.println("Quel type de bac");
        System.out.println("1. Compostage");
        System.out.println("2. Recyclage");
        System.out.println("3. Ordures");

        Scanner scan = new Scanner(System.in);
        String type_de_bac = scan.next();
        int type = Integer.parseInt(type_de_bac);

        System.out.println("Donnez votre CodeQr s'il vous plait");
        System.out.println("!!! note, vous pouez entrer n'import quoi");
        String codeQR = scan.next();

        Bac bacc = new Bac(type,codeQR);
        logged_resident.ajout_un_bac(bacc);
        logged_resident.print_info_des_bac();
    }


    public void set_resident(Compte account){
        this.logged_resident = (Resident) account;
    }

    public void supprimer_un_bac(){

        logged_resident.print_info_des_bac();
        if (logged_resident.bacs_est_vide()){
            return ;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("choisir le numero du bac que vous voulez supprimer");
        int numero = Integer.parseInt(scan.next());
        logged_resident.remove_bac(numero-1);

        System.out.println("Voici les bacs que vous avez maintenant");
        logged_resident.print_info_des_bac();

    }



    public void afficher_etats_des_bacs(){
        logged_resident.print_etats_des_bacs();
    }

    public void print_les_bac(){

    }
}