

public class Consommateur extends Compte{

    private int note_final;
    private int nombre_de_note;
    private String code;
    private String nom;
    private String email;
    private String telephone;
    private String type_dechets;
    private String address;

    public Consommateur(String account, String password){
        super(account,password);
        this.note_final = 0;
        this.nombre_de_note = 0;
        this.code = "8683468";
        this.nom = "Garbage eater company";
        this.email = "garbageEater@umontreal.ca";
        this.telephone = "4389269683";
        this.type_dechets = "ordures, recyclage";
        this.address = "8888 rue de la cotes dei neiges";

    }

    public int get_note_final(){
        return this.note_final;
    }

    public void update_note(int note){
        this.nombre_de_note += 1;
        this.note_final = (this.note_final + note) / this.nombre_de_note;
    }


    public void print_details(){
        System.out.println("============================================================");
        System.out.println("voici les details de ce consommateur");
        System.out.println("nom:  " + this.nom);
        System.out.println("email:  " + this.email);
        System.out.println("telephone:  " + this.telephone);
        System.out.println("code:  " + this.code);
        System.out.println("type_dechets:  " + this.type_dechets);
    }

}