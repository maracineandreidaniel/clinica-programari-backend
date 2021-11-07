package Views;

import Controllers.AdminController;
import Controllers.ClientController;
import Controllers.MedicController;
import Controllers.ProgramareController;
import Model.Admin;
import Model.Client;
import Model.Programare;

import java.util.Scanner;

public class ViewAdmin {
    private Scanner scanner;
    private Admin admin;
    private ProgramareController programari;
    private ClientController clienti;
    private MedicController medici;
    private AdminController admini;


    public ViewAdmin(Admin admin){
        this.admin=admin;
        scanner=new Scanner(System.in);
        programari=new ProgramareController();
        clienti=new ClientController();
        medici=new MedicController();
        admini=new AdminController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate programarile.\n";
        text+="Apasati tasta 2 pentru a schimba data unei programari.\n";
        text+="Apasati tasta 3 pentru a schimba medicul pentru o programare.\n";
        text+="Apasati tasta 4 pentru a schimba clientul pentru o programare.\n";
        text+="Apasati tasta 5 pentru a edita username-ul.\n";
        text+="Apasati tasta 6 pentru a edita parola.\n";
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
                    modificaData();
                    break;
                case 3:
                    modificaDoctor();
                    break;
                case 4:
                   modificaClient();
                    break;
                case 5:
                    modificaNume();
                    break;
                case 6:
                    modificaParola();
                    break;

            }
        }
    }

    public void vizualizareProgramari(){
        for(Programare p: programari.allProgramari())
                System.out.println(p);
    }



    public void modificaData() throws Exception {
        System.out.println("Introdu id-ul programarii: ");
        int ni=scanner.nextInt();
        System.out.println("Introdu noua data: ");
        String nd=scanner.next();
        programari.updateData(ni,nd);
    }

    public void modificaDoctor() throws Exception {
        System.out.println("Introdu id-ul programarii: ");
        int ni=scanner.nextInt();
        System.out.println("Introdu noul doctor: ");
        String nm=scanner.next();
        programari.updateMedic(ni,nm);
    }

    public void modificaClient() throws Exception {
        System.out.println("Introdu id-ul programarii: ");
        int ni=scanner.nextInt();
        System.out.println("Introdu noul client: ");
        String cl=scanner.next();
        programari.updateClient(ni,cl);
    }

    public void modificaNume() throws Exception {
        System.out.println("Introdu noul nume al dvs:");
        String nn=scanner.next();
        admini.updateNume(admin.getNume(),nn);
    }

    public void modificaParola() throws Exception {
        System.out.println("Introdu noua parola a dvs:");
        String pn=scanner.next();
        admini.updateParola(admin.getNume(),pn);
    }
}
