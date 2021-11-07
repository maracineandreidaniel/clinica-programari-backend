package Views;

import Controllers.ClientController;
import Controllers.ProgramareController;
import Model.Client;
import Model.Programare;

import java.util.Scanner;

public class ViewClient {
    private Scanner scanner;
    private Client client;
    private ProgramareController programari;
    private ClientController clienti;


    public ViewClient(Client client){
        this.client=client;
        scanner=new Scanner(System.in);
        programari=new ProgramareController();
        clienti=new ClientController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate programarile dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a face o programare.\n";
        text+="Apasati tasta 3 pentru a anula o programare.\n";
        text+="Apasati tasta 4 pentru a schimba data unei programari.\n";
        text+="Apasati tasta 5 pentru a schimba medicul pentru o programare.\n";
        text+="Apasati tasta 6 pentru a edita username-ul.\n";
        text+="Apasati tasta 7 pentru a edita parola.\n";
        return text;
    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=scanner.nextInt();
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                   vizualizareProgramari();
                    break;
                case 2:
                    faProgramare();
                    break;
                case 3:
                    anuleazaProgramare();
                    break;
                case 4:
                    modificaData();
                    break;
                case 5:
                    modificaDoctor();
                    break;
                case 6:
                    modificaNume();
                    break;
                case 7:
                    modificaParola();
                    break;
            }
        }
    }

    public void vizualizareProgramari(){
        for(Programare p: programari.allProgramari())
            if(p.getClient().equals(client.getNume()))
                System.out.println(p);
    }

    public void faProgramare(){
        System.out.println("Introdu data la care doresti sa faci programarea:");
        String data=scanner.next();
        System.out.println("Introdu numele medicului la care vrei sa te programezi.");
        String med=scanner.next();
        Programare programare=new Programare(client.getNume(),med,data);
        programari.insert(programare);
        System.out.println("Ati facut programarea cu numarul: " + programari.allProgramari().get(programari.allProgramari().size()-1).getId());
    }

    public void anuleazaProgramare() throws Exception {
        System.out.println("Introdu numarul programarii pe care vreti sa o anulati.");
        int nr=scanner.nextInt();
        programari.remove(nr);
    }

    public void modificaData() throws Exception {
        System.out.println("Introdu id-ul programarii dvs: ");
        int ni=scanner.nextInt();
        System.out.println("Introdu noua data: ");
        String nd=scanner.next();
        programari.updateData(ni,nd);
    }

    public void modificaDoctor() throws Exception {
        System.out.println("Introdu id-ul programarii dvs: ");
        int ni=scanner.nextInt();
        System.out.println("Introdu noul doctor: ");
        String nm=scanner.next();
        programari.updateMedic(ni,nm);
    }

    public void modificaNume() throws Exception {
        System.out.println("Introdu noul nume al dvs:");
        String nn=scanner.next();
        clienti.updateNume(client.getNume(),nn);
    }

    public void modificaParola() throws Exception {
        System.out.println("Introdu noua parola a dvs:");
        String pn=scanner.next();
        clienti.updateParola(client.getNume(),pn);
    }


}
