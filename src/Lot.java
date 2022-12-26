/**
 * class lot permet de donner acces au lot 
 */
public class Lot {


    private String number;
    private String state;
    private String date_ramassage;
    private String date_livraison;
    /**
     * construteur permt initialiser
     * @param number nombre de lot 
     * @param statut statut de ramassage
     * @param date_ramassage date de ramassage
     * @param date_livraison date de livraison
     */
    public Lot(String number, String statut, String date_ramassage, String date_livraison) {
        this.number = number ;
        this.state = statut;
        this.date_livraison = date_livraison;
        this.date_ramassage = date_ramassage;
    }

    /**
     * 
     * @return nombre de lot
     */
    public String getNumber(){

        return this.number;
    }


}
