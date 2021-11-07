package Controllers;

import Model.Admin;
import Model.Client;
import Repositories.AdminiRepository;
import Repositories.ClientiRepository;

import java.util.List;

public class AdminController {
    private AdminiRepository admini;


    public AdminController(){
        admini=new AdminiRepository();
    }

    public  boolean existAdmin(String nume) {
        for(Admin a: this.admini.allAdmini()){
            if(a.getNume().equals(nume))
                return true;
        }
        return false;
    }

    public Admin getAdminNumeParola(String nume, String parola) throws Exception {
        for(Admin a: this.admini.allAdmini()){
            if(a.getNume().equals(nume) && a.getParola().equals(parola))
                return a;
        }
        throw new Exception("Nume sau parola incorecta.");
    }



    public void insert(Admin admin){
        admini.insertAdmin(admin);
    }

    public void remove(String nume) throws Exception {
        if(existAdmin(nume)==true)
            admini.removeAdmin(nume);
        else
            throw new Exception("Adminul nu exista!");
    }

    public void updateNume(String nume,String numeNou) throws Exception {
        if(existAdmin(nume)==true)
            admini.updateNume(nume,numeNou);
        else
            throw new Exception("Adminul nu exista!");
    }

    public void updateParola(String nume,String parola) throws Exception {
        if(existAdmin(nume)==true)
            admini.updateParola(nume,parola);
        else
            throw new Exception("Adminul nu exista!");
    }

    public List<Admin> allAdmini(){
        return admini.allAdmini();
    }


}
