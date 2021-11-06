import Model.Admin;
import Model.Client;
import Model.Programare;
import Repositories.AdminiRepository;
import Repositories.ClientiRepository;
import Repositories.ProgramariRepository;

public class Main {

    public static void main(String[] args) {
        ProgramariRepository programariRepository=new ProgramariRepository();
        ClientiRepository clientiRepository=new ClientiRepository();
        Programare p=new Programare("vasile","ian","7,4,2004,4,4");
        System.out.println(programariRepository.allProgramari());
        System.out.println(clientiRepository.allClienti());

    }
}
