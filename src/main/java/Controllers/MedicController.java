package Controllers;

import Model.Admin;
import Model.Medic;
import Repositories.AdminiRepository;
import Repositories.MediciRepository;

import java.util.List;

public class MedicController {
    private MediciRepository medici;


    public MedicController(){
        medici=new MediciRepository();
    }

    public  boolean existMedic(String nume) {
        for(Medic m: this.medici.allMedici()){
            if(m.getNume().equals(nume))
                return true;
        }
        return false;
    }

    public Medic getMedicNumeParola(String nume, String parola) throws Exception {
        for(Medic m: this.medici.allMedici()){
            if(m.getNume().equals(nume) && m.getParola().equals(parola))
                return m;
        }
        throw new Exception("Nume sau parola incorecta.");
    }



    public void insert(Medic medic){
        medici.insertMedic(medic);
    }

    public void remove(String nume) throws Exception {
        if(existMedic(nume)==true)
            medici.removeMedic(nume);
        else
            throw new Exception("Medicul nu exista!");
    }

    public void updateNume(String nume,String numeNou) throws Exception {
        if(existMedic(nume)==true)
            medici.updateNume(nume,numeNou);
        else
            throw new Exception("Medicul nu exista!");
    }

    public void updateParola(String nume,String parola) throws Exception {
        if(existMedic(nume)==true)
            medici.updateParola(nume,parola);
        else
            throw new Exception("Medicul nu exista!");
    }

    public List<Medic> allMedici(){
        return medici.allMedici();
    }



}
