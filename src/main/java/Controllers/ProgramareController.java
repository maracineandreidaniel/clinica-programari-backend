package Controllers;

import Model.Admin;
import Model.Programare;
import Repositories.AdminiRepository;
import Repositories.ProgramariRepository;

import java.util.List;

public class ProgramareController {

    private ProgramariRepository programari;


    public ProgramareController(){
        programari=new ProgramariRepository();
    }

    public  boolean existProgramare(int id) {
        for(Programare p: this.programari.allProgramari()){
            if(p.getId()==id)
                return true;
        }
        return false;
    }


    public void insert(Programare programare){
        programari.insertProgramare(programare);
    }

    public void remove(int id) throws Exception {
        if(existProgramare(id)==true)
            programari.removeProgramare(id);
        else
            throw new Exception("Programarea nu exista!");
    }

    public void updateClient(int id, String client) throws Exception {
        if(existProgramare(id)==true)
            programari.updateClient(id,client);
        else
            throw new Exception("Programarea nu exista!");
    }

    public void updateMedic(int id, String medic) throws Exception {
        if(existProgramare(id)==true)
            programari.updateMedic(id,medic);
        else
            throw new Exception("Programarea nu exista!");
    }

    public void updateData(int id, String dataNoua) throws Exception {
        if(existProgramare(id)==true)
            programari.updateData(id,dataNoua);
        else
            throw new Exception("Programarea nu exista!");
    }

    public List<Programare> allProgramari(){
        return programari.allProgramari();
    }


}
