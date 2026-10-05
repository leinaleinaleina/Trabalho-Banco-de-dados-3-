package programas.classes.generico;

public class EmailContribuinte {
    private String email;
    private int idEmail;
    
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
}
