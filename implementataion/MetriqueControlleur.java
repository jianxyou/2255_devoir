
import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.util.*;


/**
 * Cette classe controle la logique et les formules pour les metriques.
*/
public class MetriqueControlleur implements Serializable {

    //Pr: Poids du recyclage
    //Pc: Poids du compostage
    //Po: Poids des ordures

    //Cr: Cout du recyclage
    //Cc: Cout du compostage
    //Co: Cout des ordures

    //PNUI ideal usage
    //CIM: Cout idéal max des activités

    //Nr Niveau de remplissage du bac de recyclage
    //Nc Niveau de remplissage du bac de compostage
    //No Niveau de remplissage du bac des ordures

    //Er =Usage des déchets recyclables
    //Ec= Usage des déchets compostables


    //participation au composte :
    //prend en parapemtre un tableau de niveau de remplissage de trois categorie de composte et
    //un tableau de dimension 3 contenant l'usage des trois categorie de composte
    //private ArrayList<Besoin> besoins;

    private int scoreEcono;
    private int scoreEcolo;
    private int pnn;
    public void ParticipC(ArrayList<Double> tNc,ArrayList<Double> Ec){
        double Uc=calculeUc(tNc,Ec);
        System.out.println("niveau de participation au composte="+Uc);
    }
    //calcule Uc retourne le niveau de participation au composte
    //prend en parametre le tableau d'usage des trois categorie de composte et le tableau
    //de niveau de remplissage de trois categorie de composte
    public double calculeUc(ArrayList<Double> tNc,ArrayList<Double> Ec) {
        double Ec1=Ec.get(0);
        double Ec2=Ec.get(1);
        double Ec3=Ec.get(2);
        double Nc1=tNc.get(0);
        double Nc2=tNc.get(1);
        double Nc3=tNc.get(2);
        double Uc = (Nc1 * Ec1 + Nc2 * Ec2 + Nc3 * Ec3)/ Collections.max(Ec);
        return Uc;
    }

    public int getScoreEcono(){
        return this.scoreEcono;
    }






    //participation au recyclage:
    //prend en parapemtre un tableau de niveau de remplissage de trois categorie de recyclage et
    //un tableau de dimension 3 contenant l'usage des trois categorie de recyclage
    public void ParticipR(ArrayList<Double> tNr,ArrayList<Double> Er){
        double Ur =calculeUr( tNr, Er);
        System.out.println("niveau de participation au recyclage="+Ur);
    }
    //calcule Uc retourne le niveau de participation au recyclage
    //prend en parametre le tableau d'usage des trois categorie de recyclage et le tableau
    //de niveau de remplissage de trois categorie de recyclage
    public double calculeUr(ArrayList<Double> tNr,ArrayList<Double> Er) {
        double Er1=Er.get(0);
        double Er2=Er.get(1);
        double Er3=Er.get(2);
        double Nr1=tNr.get(0);
        double Nr2=tNr.get(1);
        double Nr3=tNr.get(2);
        double Ur = (Nr1 * Er1 + Nr2 * Er2 + Nr3 * Er3)/ Collections.max(Er);
        return Ur;
    }


    //calcule le score Ecolo :
    //prend en parametre les poids ( recyclage composte et ordure) calcule Ur et calcule Uc
    //et le niveau de remplisasge des differents bacs
    public void scoreEcolo(double Ur, double Uc,double Nr, double Nc, double No,
                           double Pr,double Pc,double Po,double PNUI){
        double PNr = Nr * Pr;
        double PNc = Nc * Pc;
        double PNo = No * Po;

        double PNU = Math.log((PNr * Ur + PNc * Uc + 1) / (PNo + 1));
        double score =PNU/PNUI;
        System.out.println("score ecolo="+score);

        int sco = (int) score;
        this.scoreEcolo = sco;
    }

    public int getScoreEcolo(){
        return this.scoreEcolo;
    }


    public int getPnn(){
        return this.pnn;
    }
    //calcule de score Econo:
    // prend en parametre les couts le niveau de remplissages et le cout ideal
    public void scoreEcono(double Cr,double Cc, double Co,double Nc,double No,double Nr,double CIM ){

        double CN = (Nr * Cr + Nc * Cc + No * Co - CIM) / CIM;
        double score = 1 - Math.max (0, CN);
        int scoree = (int) score;
        System.out.println("score econo="+score);
        this.scoreEcono =scoree ;
    }

    //calculer la proportion de remplissage prend en parametre niveau de remplissage
    public void PosNegative(double PNr,double PNc,double PNo) {
        double PN= (PNr + PNc) / (PNo + 1)  ;
        System.out.println("proportion de de remplissage "
                + "du compostage et du recyclage par rapport au ordure=  "+PN);

        int pnn = (int) PN;
        this.pnn = pnn;
    }
    //niveau d'erreur de recyclage prend en parametre niveau de remplissage de
    //recyclage et tableau de remplissage des categorie de recyclage
    public void erreurR(double Nr,ArrayList<Double> tNr) {
        double Nr1=tNr.get(0);
        double Nr2=tNr.get(1);
        double Nr3=tNr.get(2);
        double erreur=Nr-(Nr1+Nr2+Nr3)+1/Nr+1;
        System.out.println("niveau de erreur de recyclage="+erreur);

    }
    //niveau d'erreur de composte prend en parametre niveau de remplissage de
    //composte et tableau de remplissage des categorie de composte
    public void erreurC(double Nc,ArrayList<Double> tNc) {
        double Nc1=tNc.get(0);
        double Nc2=tNc.get(1);
        double Nc3=tNc.get(2);

        double erreur=Nc-(Nc1+Nc2+Nc3)+1/Nc+1;
        System.out.println("niveau de erreur de composte="+erreur);

    }



    public void consulter_les_metriques() {


        System.out.println("===========================================");
        System.out.println("voici tous les metriques");
        double Pr = 23.0;
        double Pc = 46.0;
        double Po = 53;

        double Cr = 2.0;
        double Cc = 54;
        double Co = 23;

        double PNUI = 100;
        double CIM = 100;

        double Nr = 70;
        double Nc = 80;
        double No = 40;

        ArrayList<Double> Er = new ArrayList<Double>(Arrays.asList(33.0, 44.0, 3.0));
        ArrayList<Double> Ec = new ArrayList<Double>(Arrays.asList(34.0, 55.0, 12.0));
        ArrayList<Double> tNc = new ArrayList<Double>(Arrays.asList(55.0, 20.0, 1.0));
        ArrayList<Double> tNr = new ArrayList<Double>(Arrays.asList(8.0, 7.0, 43.0));


        ParticipC(tNc, Ec);
        ParticipR(tNr, Er);
        PosNegative(Nr, Nc, No);
        scoreEcolo(Co, CIM, Nr, Nc, No, Pr, Pc, Po, PNUI);
        scoreEcono(Cr, Cc, Co, Nc, No, Nr, CIM);
        erreurC(Nc, tNc);
        erreurR(Nr, tNr);
    }


    public void parametrise_metrique(){

        double Pr = 23.0;
        double Pc = 46.0;
        double Po = 53;

        double Cr = 2.0;
        double Cc = 54;
        double Co = 23;

        double PNUI = 100;
        double CIM = 100;

        double Nr = 70;
        double Nc = 80;
        double No = 40;


        ArrayList<Double> Er = new ArrayList<Double>(Arrays.asList(33.0, 44.0, 3.0));
        ArrayList<Double> Ec = new ArrayList<Double>(Arrays.asList(34.0, 55.0, 12.0));
        ArrayList<Double> tNc = new ArrayList<Double>(Arrays.asList(55.0, 20.0, 1.0));
        ArrayList<Double> tNr = new ArrayList<Double>(Arrays.asList(8.0, 7.0, 43.0));


        System.out.println("Choisir le metrique que vous voulez contribuer");

        System.out.println("1, niveau de participation au composte");
        System.out.println("2, participation au recyclage");
        System.out.println("3, score Ecolo");
        System.out.println("4, scoreEcono");
        System.out.println("5, niveau d'erreur de recyclage");
        System.out.println("6, niveau d'erreur de composte ");


        Scanner scan = new Scanner(System.in);
        String option = scan.next();

        ParticipC(tNc, Ec);
        ParticipR(tNr, Er);
        PosNegative(Nr, Nc, No);
        scoreEcolo(Co, CIM, Nr, Nc, No, Pr, Pc, Po, PNUI);
        scoreEcono(Cr, Cc, Co, Nc, No, Nr, CIM);
        erreurC(Nc, tNc);
        erreurR(Nr, tNr);



        System.out.println("===========================================");
        switch(option){
            case "1":
                System.out.print("avant integre vos donnees    ");
                ParticipC(tNc, Ec);

                Ec = new ArrayList<Double>(Arrays.asList(30.0, 52.0, 13.0));
                System.out.print("avoir integre vos donnees     ");
                ParticipC(tNc, Ec);

            case "2":
                System.out.print("avant integre vos donnees    ");
                ParticipR(tNr, Er);


                Er = new ArrayList<Double>(Arrays.asList(23.0, 14.0, 3.0));
                System.out.print("avoir integre vos donnees     ");
                ParticipC(tNc, Ec);




            case "3":

                System.out.print("avant integre vos donnees    ");
                scoreEcolo(Co, CIM, Nr, Nc, No, Pr, Pc, Po, PNUI);

                Nc = 40;
                No = 300;
                System.out.print("avoir integre vos donnees     ");
                scoreEcolo(Co, CIM, Nr, Nc, No, Pr, Pc, Po, PNUI);
                break;

            case "4":


                System.out.print("avant integre vos donnees    ");
                scoreEcono(Cr, Cc, Co, Nc, No, Nr, CIM);

                Cc = 30;
                Cr = 30;
                System.out.print("avoir integre vos donnees     ");
                scoreEcono(Cr, Cc, Co, Nc, No, Nr, CIM);
                break;


            case "5":
                System.out.print("avant integre vos donnees    ");
                erreurC(Nc, tNc);


                tNc = new ArrayList<Double>(Arrays.asList(90.0, 350.0, 1.0));
                System.out.print("avoir integre vos donnees     ");
                erreurC(Nc, tNc);
                break;


            case "6":
                System.out.print("avant integre vos donnees    ");
                erreurR(Nr, tNr);


                tNr = new ArrayList<Double>(Arrays.asList(9.0, 4.0, 30.0));
                System.out.print("avoir integre vos donnees     ");
                erreurR(Nr, tNr);






        }
    }
}



