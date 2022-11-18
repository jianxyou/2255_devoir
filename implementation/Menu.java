import java.util.Scanner;

public class Menu{


    public void dissplay_login_page(){

    }

    public Boolean display_premier_page(){


        Scanner scan  = new Scanner(System.in);
        System.out.println("Bienvenue a bineco" );
        System.out.println("Do u have a count ou not, entrer  o / n ");

        String haha = scan.next();
        if (haha == "o"){
            return false;
        }

        else if (haha == "n"){
            return true;
        }

        else return false;
    }

    public void display_main_page(){

    }


    public void display_create_account_page(){
    }


    public void display_login_page(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("plz enter ur account_number：" );
        System.out.println("vous devez entrer 333 parce que c'est un test" );

        String userName = scanner.next();
        System.out.println("plz enter ur password：");
        System.out.println("vous devez entrer 888 parce que c'est un test" );
        String password = scanner.next();

    }


    public void login_succeed(){
        System.out.println("hahaha, login succeed");
    }

    public void login_failed(){
        System.out.println("555555, login failed");
    }

    public void display_resident_options(){

        System.out.println("1, Enregistre un bac" );
        System.out.println("2, supprimer un bac" );
        System.out.println("3, afficher etats des bacs" );
        System.out.println("4, consulter les metriques" );
        System.out.println("5, trouvez un consommateur" );
        System.out.println("6, signaler une probleme：" );
        System.out.println("7, voir les activites maintenus" );
        System.out.println("8, voir l'etats de traitements" );
        System.out.println("9, exit");

    }





}