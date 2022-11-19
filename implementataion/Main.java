import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void main(String []args) {
        Metrique m= new Metrique();
        double Pr=23.0;
        double Pc=46.0;
        double Po=53;

        double Cr=2.0;
        double Cc= 54;
        double Co= 23;

        double PNUI =100;
        double CIM=100;

        double Nr =70;
        double Nc =80;
        double No =40;

        ArrayList<Double> Er =new ArrayList<Double>(Arrays.asList(33.0,44.0,3.0));
        ArrayList<Double> Ec =new ArrayList<Double>(Arrays.asList(34.0,55.0,12.0));
        ArrayList<Double> tNc =new ArrayList<Double>(Arrays.asList(55.0,20.0,1.0));
        ArrayList<Double> tNr =new ArrayList<Double>(Arrays.asList(8.0,7.0,43.0));


        m.ParticipC(tNc, Ec);
        m.ParticipR(tNr, Er);
        m.PosNegative(Nr, Nc, No);
        m.scoreEcolo(Co, CIM, Nr, Nc, No, Pr, Pc, Po, PNUI);
        m.scoreEcono(Cr, Cc, Co, Nc, No, Nr, CIM);
        m.erreurC(Nc, tNc);
        m.erreurR(Nr, tNr);

    }
}
