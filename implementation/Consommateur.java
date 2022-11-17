

public class Consommateur extends Compte{

    private int note_final;
    private int nombre_de_note;

    public Consommateur(){
        this.note_final = 0;
        this.nombre_de_note = 0;
    }

    public int get_note_final{
        return this.note_final;
    }


    public void update_note(int note){
        this.nombre_de_note += 1;
        this.note_final = (this.note_final + note) / this.nombre_de_note;
    }
}