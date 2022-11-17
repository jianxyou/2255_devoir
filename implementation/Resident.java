

import java.util.ArrayList;

public class Resident extends Compte{

    private ArrayList<Bac> bacs;
    private int nombre_de_bac_enregistre;


    public Resident(String account_numer, Strin password){
        super(account_numer,password)
        this.nombre_de_bac_enregistre = 0;
        this.bacs = new ArrayList<Bac>();
    }


    public ArrayList<Bac> get_bacs() {
        return bacs;
    }

    public void ajout_un_bac(Bac bac){
        bacs.add(bac);
    }
}