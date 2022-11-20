import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MunicipInfoService
 */
public class MunicipInfoService {

    public boolean validateConsommateur(String code) {
        // Appel MunicipInfo: get-consommateur(code)
        Consomateur consomateur = getConsommateur(code);

        return consomateur.code == code;
    }

    public boolean validateBac(String codeqr, String adresse) {
        // Appel MunicipInfo: get-consommateur(code)
        Bac bac = getBac(codeqr);

        return bac.codeqr == codeqr;
    }


    private List<Consomateur> listConsommateur() {
        var consommateurList = new ArrayList<Consomateur>();

        return consommateurList;
    }

    /**
     * Cette fonction simule l'appel à get-consommateur(code)
     * @param code
     * @return {@link Consomateur}
     */
    private Consomateur getConsommateur(String code) {
        var consomateur = new Consomateur();

        consomateur.code = "232";
        consomateur.nom = "replastic";
        consomateur.adresse = "";
        consomateur.email = "info@replastic.com";
        consomateur.telephone = "";
        consomateur.details = "Nous transformons tout vos plastiques et verres jetées en bouteille prêt à être utilisé pour conserveau votre eau et vos brevages favoris";
        consomateur.type_dechets = new String[] { "plastique", "verre" };
        consomateur.capacite = "100 tonnes";

        return consomateur;
    }

    /**
     * Cette fonction simule l'appel à get-bac(codeqr)
     * @param codeqr
     * @return {@link Bac}
     */
    private Bac getBac(String codeqr) {
        var bac = new Bac();

        bac.codeqr = "232Xd";
        bac.adresse = "2020 du finfin";
        bac.dateEmission = new Date();

        return bac;
    }

    /**
     * Cette fonction simule l'appel à list-lot()
     * @return
     */
    private List<Lot> listLot() {
        var lotList = new ArrayList<Lot>();

        return lotList;
    }

    /**
     * Cette fonction simule l'appel à get-lot(numero)
     * @param numero
     * @return
     */
    private Lot getLot(String numero) {
        var lot = new Lot();

        return lot;
    }

    /**
     * Cette fonction simule l'appel à post-message()
     * @return
     */
    private boolean postMessage() {
        return true;
    }

    private class Consomateur {
        String code;
        String nom;
        String adresse;
        String email;
        String telephone;
        String details;
        String[] type_dechets;
        String capacite;
    }

    private class Bac {
        String codeqr;
        String adresse;
        Date dateEmission;
    }

    private class Lot {
        String numero;
        String type;
        String parent;
        Lot[] sous_lots;
        Date dateRamassage;
        Date dateLivraison;
        String statut;
        int qte_total;
        int qte_traite;
        float taux_rejet;
        float cout;
        Consomateur[] consomateurs;
        String activites;
    }
}