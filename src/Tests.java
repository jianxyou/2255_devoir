import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class Tests {


        @Test
        public void testAssertions(){
        /**
         * first test for metrique
         */
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
        MetriqueControlleur metriqueControlleur = new MetriqueControlleur();
        metriqueControlleur.consulter_les_metriques();
        assertEquals(-51, metriqueControlleur.getScoreEcono());

        /**
         * second test for account
         */
        Bin bin = new Bin("dfa","dfa","few","ew");
        Resident resident= new Resident("dfa","fad","wef",
                "fafa","daf","dfa",bin);

        MunicipInfo municipinfo = new MunicipInfo();
        assertEquals(true,municipinfo.verifyPassword("wef","dfa","dfa"));



        /**
         * third test for activity rating
         */
        ConsumerActivity activity1 = new ConsumerActivity("compost");
        ArrayList<ConsumerActivity> activities= new ArrayList<>();
        activity1.addRating(300.0);
        activity1.getAverageRating();

        assertEquals(300,(int)activity1.getAverageRating());

    }



}
