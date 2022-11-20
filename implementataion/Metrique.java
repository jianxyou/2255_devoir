

public class Metrique {


    private Double valeur;
    private String introduction;

    public Metrique(String introduction){
        this.valeur = 0.0;
        this.introduction = introduction;
    }

    public void Valeur(Double valeur){
        this.valeur = valeur;
    }


}