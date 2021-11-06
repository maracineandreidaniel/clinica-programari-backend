package Repositories;

import Model.Admin;
import Model.Client;
import Model.Medic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediciRepository {
    private String jdbcurl = "jdbc:mysql://localhost:3306/clinica-programari-db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public MediciRepository() {
        try {
            this.connection = DriverManager.getConnection(this.jdbcurl, this.user, this.password);
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("eroare de conectare baza de date");
        }

    }

    public void executeStatement(String execute) {
        try {
            this.statement.execute(execute);
        } catch (SQLException var3) {
            System.out.println("Nu am reusit " + execute);
        }
    }


    public void insertMedic(Client client) {
        String insertTo = " ";
        insertTo = insertTo + "insert into medici (nume,parola) values (";
        insertTo = insertTo + String.format("'%s','%s'",client.getNume(),client.getParola());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }

    public void removeMedic(String nume){
        String removeTo="";
        removeTo+=String.format("%s", "delete from medici where nume='"+nume+"';");
        executeStatement(removeTo);

    }

    public void updateNume(String nume, String numeNou){
        String update="";
        update+=String.format("update medici set nume='%s'", numeNou);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    public void updateParola(String nume , String parolaNoua){
        String update="";
        update+=String.format("update medici set parola='%s'", parolaNoua);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    private ResultSet lista(){
        executeStatement("select * from medici");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Medic> allMedici() {
        ResultSet set = lista();
        List<Medic> medici = new ArrayList<>();
        try {
            while (set.next()) {
                medici.add(new Medic(set.getInt(1),set.getString(2), set.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
            return null;
        }
        return medici;
    }


}
