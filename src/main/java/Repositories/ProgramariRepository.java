package Repositories;

import Model.Client;
import Model.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramariRepository {
        private String jdbcurl = "jdbc:mysql://localhost:3306/clinica-programari-db?autoreconnect=true&useSSL=false";
        private String user = "root";
        private String password = "root";
        private Connection connection = null;
        private Statement statement = null;

        public ProgramariRepository() {
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
                //System.out.println("Nu am reusit " + execute);
                var3.printStackTrace();
            }
        }


        public void insertProgramare(Programare programare) {
            String insertTo = " ";
            insertTo = insertTo + "insert into programari (client,medic,data) values (";
            insertTo = insertTo + String.format("'%s','%s','%s'",programare.getClient(),programare.getMedic(),Programare.convertLDTtoStringTFormat(programare.getData()));
            insertTo = insertTo + ");";
            this.executeStatement(insertTo);
        }

        public void removeProgramare(int id){
            String removeTo="";
            removeTo+=String.format("delete from programari where id=%d ;",id);
            executeStatement(removeTo);

        }

        public void updateClient(int id, String clientNou){
            String update="";
            update+=String.format("update programari set client='%s'", clientNou);
            update+=String.format(" where id='%d'", id);
            executeStatement(update);
        }

        public void updateMedic(int id, String medicNou){
            String update="";
            update+=String.format("update programari set medic='%s'", medicNou);
            update+=String.format(" where id=%d", id);
            executeStatement(update);
    }

        public void updateData(int id, String dataNoua){
            String update="";
            update+=String.format("update programari set data='%s'", Programare.convertLDTtoStringTFormat(Programare.convertStringToLocalDateTime(dataNoua)));
            update+=String.format(" where id='%d'", id);
            executeStatement(update);
    }

        private ResultSet lista(){
            executeStatement("select * from programari");
            try {
                return statement.getResultSet();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }


        public List<Programare> allProgramari() {
            ResultSet set = lista();
            List<Programare> programari = new ArrayList<>();
            try {
                while (set.next()) {
                    programari.add(new Programare(set.getInt(1), set.getString(2),set.getString(3),Programare.fromDBToParameterConvert(set.getString(4))));
                }
            } catch (Exception e) {
                System.out.println("Nu s-a creat lista");
                return null;
            }
            return programari;
        }


    }


