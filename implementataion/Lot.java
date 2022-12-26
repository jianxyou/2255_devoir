
/**
 * Cette classe represente un lot de dechets municipal.
*/
public class Lot {


    private String number;
    private String state;
    private String date_ramassage;
    private String date_livraison;

    public Lot(String number, String statut, String date_ramassage, String date_livraison) {
        this.number = number ;
        this.state = statut;
        this.date_livraison = date_livraison;
        this.date_ramassage = date_ramassage;
    }

    
    public String getNumber(){

        return this.number;
    }


}
