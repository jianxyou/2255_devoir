


import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class bineco {


    private Compte logged_compte;

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        //ArrayList<Resident> residents = new ArrayList<Resident>();
        //ArrayList<Consommateur> consommateurs = new ArrayList<Consommateur>(10);
        AccountController account_controller = new AccountController();
        BacController bac_controller = new BacController();

        Menu menu = new Menu();


        Boolean avoir_un_compte = menu.display_premier_page();

        if (!avoir_un_compte){
            menu.display_create_account_page();
            System.out.println(" what's your account number you want to create");
            String account = scan.next();
            System.out.println(" what's your password");
            String password = scan.next();
            account_controller.create_new_resident(account,password);

            System.out.println("Bravo");
            System.out.println("===================================================================");

        }


        System.out.println(" enter your account number");
        String account = scan.next();
        System.out.println(" enter your account number");
        String password = scan.next();


        Boolean success = account_controller.verify_password(account,password);
        if (success){
            menu.login_succeed();
        }

        else menu.login_failed();


        Compte current_account = account_controller.get_account(account);
        bac_controller.set_resident(current_account);



        if (success){
            menu.login_succeed();
        }


        System.out.println("===========================================");
        if (account_controller.est_consommateur("333")){
            System.out.println("vous etes un resident, qu'est ce que vous voulez faire today");
        }





        while(true){

            System.out.println("===========================================");
            menu.display_resident_options();

            System.out.println("===========================================");
            System.out.println("entrez votre option");
            String option_choisi = scan.next();


            Boolean exit = false;
            switch (option_choisi) {
                case "1":
                    bac_controller.enregistrer_un_bac();
                    break;
                case "2":
                    bac_controller.supprimer_un_bac();
                    break;
                case "9":
                    exit = true;
            }


            if (exit){
                break;
            }

        }


        //account_controller.verify_password()




// faire linscription
        //account_controller.create_resident(888,999);
        //System.out.println(account_controller.get_residents());



        //valider le compte
        //Boolean login = account_controller.verify_password(366,888);
        //menu.print_msg(login);


        //enregistrer un bac

        //bac_controller.enregistre_un_bac(resident,Bac bac)


        //trouver un consommateur
        //account_controlleur.affiche_consommateur;


        // voir les activites maintenues
        //activity.controller.affiche_les_activities;


        //supprime un bac




    }

}
