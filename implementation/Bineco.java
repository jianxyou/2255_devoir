import java.util.ArrayList;

public class Bineco {
    private String address;
    private Compte_manager compte_manager;
    private Metrique_manager metrique_manager;

    public Bineco{
        this.compte_manager = new Compte_manager();
    }


    private void afficher_consommateurs() {

    }

    public void login(String account, String password) {

        Boolean succeed = compte_manager.verify_password(account,password);
        if (succeed) {
            System.out.println("login failed");
        }

        else {
            System.out.println("login succeeded");
        }
    }

    public void enregistre_un_bac(String nom_de_resident, Bac bac) {

    }

    public void supprimier_un_bac(String nom_du_resident, Bac bac) {

        ArrayList<Resident> residents = compte_manager.getResidents();

        for (Resident resident : residents) {
            if (resident.getNom() == nom_du_resident) {
                resident.remove_un_bac(bac);
            }

        }
    }

    public void enregistre_un_bac(String nom_du_resident, Bac bac) {

        ArrayList<Resident> residents = compte_manager.getResidents();

        for (Resident resident : residents) {
            if (resident.getNom() == nom_du_resident) {
                resident.ajout_un_bac(bac);
            }


        }
    }

    public void afficher_etats_des_bacs(String nom_du_resident) {

        ArrayList<Resident> residents = compte_manager.getResidents();

        for (Resident resident : residents) {
            if (resident.getNom() == nom_du_resident) {
                ArrayList<Bac> bacs_de_ce_resident = resident.getBacs();
            }
        }

        for (Bac bac : bacs_de_ce_resident) {
        }
    }

    public void trouver_un_consommateur() {

        System.out.println("voici tous les consommateurs");
        ArrayList<Consommateur> consommateurs = compte_manager.getConsommateurs();

        for (Consommateur consommateur : consommateurs) {
            System.out.println(consommateur.getNom());

        }

    }

    public void consulter_les_metriques() {

        System.out.println("voici tous les metriques");
        ArrayList<Metrique> metriques = compte_manager.getConsommateurs();

        for (Consommateur consommateur : consommateurs) {
            System.out.println(consommateur.getNom());

        }
    }



    public void inscirt_comme_resident (String account_number, String password, String nom){
        compte_manager.cree_un_resident(account_number,password,nom);
    }

    public Consommateur afficher_consommateur(){
        for _ in consommateur
    }


    public void note_un_consommteur(int note, String nom){
        compte_manager.update_consommateur_note(nom,note);

    }

    public void afficher_consommateur(){

        ArrayList<Consommateur> consommateurs = compte_manager.getConsommateurs();
        for (Consommateur conso : consommateurs){
            System
        }
    }


    public void faire_inscription()
    }


    public void login_succeed(){

    }


    public void login_failed(){

    }

    public boolean verifier_compte(){

    }






}
