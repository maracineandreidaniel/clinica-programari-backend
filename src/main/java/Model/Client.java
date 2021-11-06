package Model;

public class Client {
    private int id;
    private String nume;
    private String parola;

    public Client(int id, String nm, String prl){
        this.id=id;
        this.nume=nm;
        this.parola=prl;
    }

    public Client( String nm, String prl){
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
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
