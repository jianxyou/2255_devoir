

import java.util.ArrayList;

public class Resident extends Compte{


    private int nombre_de_bac_enregistre;
    private ArrayList<Bac> bacs;

    public Resident(String account_numer, String password){
        super(account_numer,password);
        this.nombre_de_bac_enregistre = 0;
        this.bacs = new ArrayList<Bac>();
    }


    public ArrayList<Bac> get_bacs() {
        return bacs;
    }

    public void ajout_un_bac(Bac bac){
        bacs.add(bac);
    }

    public void remove_bac(int numero){
        bacs.remove(numero);
    }


    public void print_bacs(){

        if (bacs.size() == 0){
            System.out.println("il semble que vous avez pas de bac :(");
        }
        for (int i = 0; i < bacs.size(); i++){
            System.out.println(String.valueOf(i));
        }
    }



}