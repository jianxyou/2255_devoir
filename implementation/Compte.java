

public class Compte {

    private String account_number;
    private String password;
    private String nom;



    public Compte(String account_number, String password){
        this.account_number = account_number;
        this.password = password;
    }


    public String getNom() {
        return nom;
    }

    public String getAccount(){
        return this.account_number;
    }

    public String getPassword(){
        return this.password;
    }

}

