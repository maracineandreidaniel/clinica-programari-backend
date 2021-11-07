package Controllers;

import Model.Client;
import Repositories.ClientiRepository;

import java.util.List;

public class ClientController {
    private ClientiRepository clienti;


    public ClientController(){
        clienti=new ClientiRepository();
    }

    public  boolean existClient(String nume) {
        for(Client c: this.clienti.allClienti()){
            if(c.getNume().equals(nume))
                return true;
        }
        return false;
    }

    public Client getClientNumeParola(String nume, String parola) throws Exception {
        for(Client c: this.clienti.allClienti()){
            if(c.getNume().equals(nume) && c.getParola().equals(parola))
                return c;
        }
        throw new Exception("Nume sau parola incorecta.");
    }



    public void insert(Client client){
        clienti.insertClient(client);
    }

    public void remove(String nume) throws Exception {
        if(existClient(nume)==true)
            clienti.removeClient(nume);
        else
            throw new Exception("Clientul nu exista!");
    }

    public void updateNume(String nume,String numeNou) throws Exception {
        if(existClient(nume)==true)
            clienti.updateNume(nume,numeNou);
        else
            throw new Exception("Clientul nu exista!");
    }

    public void updateParola(String nume,String parola) throws Exception {
        if(existClient(nume)==true)
            clienti.updateParola(nume,parola);
        else
            throw new Exception("Clientul nu exista!");
    }

    public List<Client> allClienti(){
        return clienti.allClienti();
    }


}
