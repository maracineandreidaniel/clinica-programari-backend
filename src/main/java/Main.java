import Model.Admin;
import Model.Client;
import Model.Programare;
import Repositories.AdminiRepository;
import Repositories.ClientiRepository;
import Repositories.ProgramariRepository;
import Views.ViewClient;
import Views.ViewLogin;

public class Main {

    public static void main(String[] args) throws Exception {
        ViewLogin viewLogin=new ViewLogin();
        viewLogin.play();
    }
}
