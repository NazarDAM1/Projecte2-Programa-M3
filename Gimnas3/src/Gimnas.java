import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnas {

    
    private static boolean sortir = false;
    private static boolean sortir2 = false;
    private static ArrayList<Client> clients;
    private static ArrayList<Activitat> activitats;

    static Scanner sc = new Scanner(System.in);

    public void gestioGimnas() throws SQLException {
        do {
            System.out.println("**************Gimnas*****************");
            System.out.println("1. Gestio client");
            System.out.println("2. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    subMenuGesioClient();
                    break;
                case '2':
                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void subMenuGesioClient() throws SQLException {

        do {
            System.out.println("**************Gimnas*****************");
            System.out.println("1. Mostrar tots clients amb informacio");
            System.out.println("2. Mostrar un client determinat amb informacio");
            System.out.println("3. Alta de un client");
            System.out.println("4. Mostrar clients amb mes reserves");
            System.out.println("5. Donar de baixa un client");
            System.out.println("6. Mostrar activitats amb mes reserves i aforament de avui");
            System.out.println("7. SUB Sortir");

            String sa1 = sc.next();
            char opcio2 = sa1.charAt(0);

            switch (opcio2) {
                case '1':
                Client cl = new Client();
                    if (clients != null) {
                        clients.clear();
                    }

                    Gimnas.clients = cl.mostrarTotsClients();
                    recorrerArrayClient();
                    sortir2 = false;
                    break;
                case '2':
                Client c2 = new Client();
                    c2.consultaClient();
                    sortir2 = false;
                    break;
                case '3':
                Client c3 = new Client();
                    System.out.println("Alta client");
                    c3.altaClient();
                    sortir2 = false;
                    break;
                case '4':
                Client c4 = new Client();
                    if (clients != null) {
                        clients.clear();
                    }
                    Gimnas.clients = c4.consultaClientsMesReserves();
                    recorrerArrayClient();
                    sortir2 = false;
                    break;

                case '5':
                Client c5 = new Client();
                    c5.baixaClient();
                    sortir2 = false;
                    break;
                case '6':
                Activitat a1 = new Activitat();
                    if (activitats != null) {
                        activitats.clear();
                    }
                    Gimnas.activitats = a1.mostrarActivitats();
                    recorrerArrayActivitat();

                    sortir2 = false;
                    break;
                case '7':
                    System.out.println("sortir");
                    sortir2 = true;

                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir2);

    }

    private void recorrerArrayClient() {
        for (Client c1 : clients) {
            System.out.println(c1);
        }
    }

    private void recorrerArrayActivitat() {
        for (Activitat c1 : activitats) {
            System.out.println(c1);
        }
    }

}