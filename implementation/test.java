


import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        //ArrayList<Resident> residents = new ArrayList<Resident>();
        //ArrayList<Consommateur> consommateurs = new ArrayList<Consommateur>(10);
        AccountController account_controller = new AccountController();
        BacController bac_controller = new BacController();


        Menu menu = new Menu();

        menu.display_login_page();

        Boolean success = account_controller.verify_password("333","888");

        if (success){
            menu.login_succeed();
        }



        System.out.println("===========================================");
        if (account_controller.est_consommateur("333")){
            System.out.println("vous etes un resident, qu'est ce que vous voulez faire today");
            menu.display_resident_options();
        }


        Scanner scan= new Scanner(System.in);
        System.out.println("===========================================");
        System.out.println("entrez votre option");
        String option_choisi = scan.next();

        switch (option_choisi){
            case "1":
                account_controller.enregistrer_un_bac();
                break;
            case "2":
                //account_controller.supprimer_un_bac();
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
