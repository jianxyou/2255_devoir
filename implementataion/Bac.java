

// 搞清楚bac有什么，可以有什么方法
//


import javax.swing.*;

public class Bac {

    private Double niveau_de_remplissage;
    private String type;
    private String usage;
    private String codeQR;
    private String composition;


    public Bac (int type_de_bac, String codeQR){

        this.codeQR = codeQR;
        if (type_de_bac == 1){
            this.composition = "grass, twigs, manure";
            this.type = "composte";
            this.niveau_de_remplissage = 0.3;
        }


        else if (type_de_bac == 2){
            this.composition = "paper, cardboard, bricks, certain plastics";
            this.type = "recycle";
            this.niveau_de_remplissage = 0.5;
        }


        else if (type_de_bac == 3){
            this.composition = "wtf,haha,wozhendefule";
            this.type = "ordures";
            this.niveau_de_remplissage = 0.6;
        }
    }

    public Double getNiveau_de_remplissage() {
        return niveau_de_remplissage;
    }


    public void print_etats(){


        System.out.println("composition:  " + this.composition);
        System.out.println("niveau de remplissage: " + this.niveau_de_remplissage);
    }



    public void print_info(){
        System.out.println("type :  " + this.type + ",  codeQR :  " + this.codeQR + "    ");
    }

}