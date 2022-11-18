import java.util.Scanner;

public class BacController {

    private Resident logged_resident;

    public BacController(){

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
        logged_resident.ajout_un_bac(bacc);

        System.out.println("reussi");
    }


    public void set_resident(Compte account){
        this.logged_resident = (Resident) account;
    }

    public void supprimer_un_bac(){
        System.out.println("Voici tous les bacs que vous avez");
        logged_resident.print_bacs();


        System.out.println("===================================================================");
        Scanner scan = new Scanner(System.in);
        System.out.println("choisir le numero du bac que vous voulez supprimer");
        int numero = Integer.parseInt(scan.next());
        logged_resident.remove_bac(numero);

        System.out.println("===================================================================");
        System.out.println("Voici les bacs que vous avez maintenant");


    }



    public void print_les_bac(){

    }
}