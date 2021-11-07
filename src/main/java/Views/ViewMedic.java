package Views;

import Controllers.MedicController;
import Controllers.ProgramareController;
import Model.Medic;
import Model.Programare;

import java.util.Scanner;

public class ViewMedic {

    private MedicController medici;
    private Scanner scanner;
    private ProgramareController programari;
    private Medic medic;

    public ViewMedic(Medic m){
        this.medic=m;
        scanner=new Scanner(System.in);
        medici=new MedicController();
        programari=new ProgramareController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate programarile dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a anula o programare.\n";
        text+="Apasati tasta 3 pentru a schimba data unei programari.\n";
        text+="Apasati tasta 4 pentru a schimba medicul pentru o programare.\n";
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
                   afiseazaProgramari();
                    break;
                case 2:
                    anuleazaProgramare();
                    break;
                case 3:
                    modificaData();
                    break;
                case 4:
                    modificaDoctor();
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

    public void afiseazaProgramari(){
        for(Programare p: programari.allProgramari())
            if(p.getMedic().equals(medic.getNume()))
                System.out.println(p);
    }

    public void anuleazaProgramare() throws Exception {
        System.out.println("Introdu numarul programarii pe care vreti sa o anulati.");
        int nr=scanner.nextInt();
        programari.remove(nr);
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

    public void modificaNume() throws Exception {
        System.out.println("Introdu noul nume al dvs:");
        String nn=scanner.next();
        medici.updateNume(medic.getNume(),nn);
    }

    public void modificaParola() throws Exception {
        System.out.println("Introdu noua parola a dvs:");
        String pn=scanner.next();
        medici.updateParola(medic.getNume(),pn);
    }




}
