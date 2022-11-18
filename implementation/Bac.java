

// 搞清楚bac有什么，可以有什么方法
//


public class Bac {

    private Double niveau_de_remplissage;
    private String type_de_bac;
    private String codeQR;



    public Bac(String type_de_bac, String codeQR){
        this.type_de_bac = type_de_bac;
        this.codeQR = codeQR;
    }

    public Double getNiveau_de_remplissage() {
        return niveau_de_remplissage;
    }

    public String getType_de_bac(){
        return this.type_de_bac;
    }
}