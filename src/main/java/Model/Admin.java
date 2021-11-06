package Model;

public class Admin {
    private int id;
    private String nume;
    private String parola;

    public Admin(int id, String nm, String prl){
        this.id=id;
        this.nume=nm;
        this.parola=prl;
    }

    public Admin( String nm, String prl){
        this.nume=nm;
        this.parola=prl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
