import java.util.ArrayList;
import java.util.Scanner;

public class Menu{


    public void dissplay_login_page(){

    }


    public void display_bineco(){

        System.out.println("||=====    ====    ||      ||     ========     ==========     ==========                                     ");
        System.out.println("||    ||    ||     ||    ||||     ||           ||           ||          ||                    ");
        System.out.println("||====      ||     ||   || ||     ||           ||           ||          ||                        ");
        System.out.println("||=====     ||     ||  ||  ||     ========     ||           ||          ||                              ");
        System.out.println("||    ||    ||     ||||    ||     ||           ||           ||          ||                     ");
        System.out.println("||====     ====    ||      ||     ========     ==========     ==========                                       ");

    }
    public Boolean display_premier_page(){


        Scanner scan  = new Scanner(System.in);

        System.out.println("Do you have a account ou not, entrer  o / n ");
        String oui_ou_non = scan.next();

        if (oui_ou_non.equals("o")){

            return true;
        }
        else if (oui_ou_non.equals("n")){
            return false;
        }


        return false;
    }

    public ArrayList<String> display_create_account_page(){

        ArrayList<String> acc = new ArrayList<String>();

        Scanner scan = new Scanner(System.in);
        System.out.println(" what's your account number you want to create");
        String account = scan.next();
        System.out.println(" what's the password you waant to create");
        String password = scan.next();

        System.out.println("your username is  \"" +  account + "\"  and your password is   \"" + password +"\"");
        System.out.println("!!!Note, vous etes automatiquement inscrit comme un resident pour ce jalon");
        System.out.println("===================================================================");

        acc.add(account);
        acc.add(password);

        return acc;
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
        System.out.println("OHOHOHOHOHOH!!  login succeed !!");
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
        System.out.println("7, parametrise les metriques" );
        System.out.println("8, voir l'etats de traitements" );
        System.out.println("9, exit");

    }





}