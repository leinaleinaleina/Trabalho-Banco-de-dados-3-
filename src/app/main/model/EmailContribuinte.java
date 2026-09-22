package app.main.model;

public class EmailContribuinte {
    private String email;
    private int idEmail;
    public Contribuinte contribuinte;
    
    public void setidEmail (int idEmail) {
        this.idEmail = idEmail;
    }

    public int getidEmail() {
        return idEmail;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.valueOf(email);
    }

    public Contribuinte getContribuinte (Contribuinte contribuinte) {
        return contribuinte;
    }
}
