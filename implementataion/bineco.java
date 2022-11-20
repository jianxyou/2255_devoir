

import java.awt.*;
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
        MetriqueControlleur metrique_controller = new MetriqueControlleur();
       // ActivityController activityController = new ActivityController();


        Menu menu = new Menu();
        menu.display_bineco();
        System.out.println("===============================================================================");


        Boolean avoir_un_compte = menu.display_premier_page();

        for (int i = 1; i<=10 ; i++){
            account_controller.create_new_consommateur("kkkkkkkkkkkkkk","kkkkkkkkkkkkkkk");
        }

        if (!avoir_un_compte){
            ArrayList<String> acc = menu.display_create_account_page();
            account_controller.create_new_resident(acc.get(0),acc.get(1));
        }


        while (true) {

            System.out.println(" enter your account number");
            String account_number = scan.next();
            System.out.println(" enter your password");
            String password = scan.next();

            Boolean success = account_controller.verify_password(account_number, password);
            if (success) {
                Compte current_account = account_controller.get_account(account_number);
                bac_controller.set_resident(current_account);
                menu.login_succeed();
                break;
            }
            else {
                menu.login_failed();
                if (account_controller.get_account(account_number) == null) {
                    System.out.println(" Sorry, this account is not existed");
                    System.out.println(" Do you wanna create a account ?  enter  o / n");
                    String oui_ou_non = scan.next();
                    if (oui_ou_non.equals("o")) {
                        ArrayList<String> acc = menu.display_create_account_page();
                    } else {
                        System.out.println(" a la prochaine");
                        return;
                    }
                }

                else{
                    System.out.println("password is not correct");
                    continue;
                }
            }
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

                case "3":
                    bac_controller.afficher_etats_des_bacs();
                    break;

                case "4":
                    metrique_controller.consulter_les_metriques();
                    break;


                case "5":
                    account_controller.afficher_consommateurs();
                    break;

                case "6":
                    System.out.println("Veuillez décrivez quel est votre problème ci-dessous");
                    scan.next();
                    System.out.println("On a bien recu votre demande :)");
                    break;

                case "7":
                    metrique_controller.parametrise_metrique();
                    break;
                case "8":
                    System.out.println("votre déchtes est en route de récupération  :)");
                    break;

                case "9":
                    exit =true;
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
