

import java.util.ArrayList;
public class Compte_manager {
    private ArrayList<Resident> residents;
    private ArrayList<Consommateur> consommateurs;
    private ArrayList<Compte> besoins;


    public Compte_manager() {
        this.comptes = new ArrayList<Compte>();
    }


    public update_consommateur_note(String nom, int note){
        for (Consommateur consommateur:consommateurs ){
            if (consommateur.getNom() == nom){
                consommateur.update_note(note);
            }
        }
    }

a

    public cree_un_resident(String account_number, String password){
        residents.add(new Resident(account_number,password));
    }

    public cree_un_consommateur(String account_number, String password){
        consommateurs.add(new Consommateur(account_number,password));
    }

    public ArrayList<Consommateur> getConsommateurs() {
        return consommateurs;
    }

    public ArrayList<Resident> getResidents() {
        return residents;
    }


}