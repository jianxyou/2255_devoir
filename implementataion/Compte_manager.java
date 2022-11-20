

import java.util.ArrayList;
public class Compte_manager {
    private ArrayList<Resident> residents;
    private ArrayList<Consommateur> consommateurs;
    private ArrayList<String> besoins;

    public Compte_manager() {
        this.residents = new ArrayList<Resident>();
        this.consommateurs = new ArrayList<Consommateur>();
        this.besoins = new ArrayList<String>();
    }



    public update_consommateur_note(String nom, int note){
        for (Consommateur consommateur:consommateurs ){
            if (consommateur.getNom() == nom) {
                consommateur.update_note(note);
            }
        }
    }

    public Boolean verify_password (String account_number, String password){
        for (Resident resident : residents){
            if (resident.getAccount_number() == account_number){
                return true;
            }
            else return false;
        }
    }


    public void cree_un_resident(String account_number, String password){
        residents.add(new Resident(account_number,password));
    }

    public void cree_un_consommateur(String account_number, String password){
        consommateurs.add(new Consommateur(account_number,password));
    }

    public void ajout_un_besoin(String besoin){
        besoins.add(besoin);
    }





    public ArrayList<Consommateur> getConsommateurs() {
        return consommateurs;
    }

    public ArrayList<Resident> getResidents() {
        return residents;
    }

    public ArrayList<String> getBesoins() {
        return besoins;
    }
}