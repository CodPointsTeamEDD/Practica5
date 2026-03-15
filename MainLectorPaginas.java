import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainLectorPaginas {

    public static void obtenerInfo() {

        ListaDoblementeLigada<Pagina> paginas = new ListaDoblementeLigada<>();
        Historial historial = new Historial(new ListaDoblementeLigada<>());

        try (BufferedReader br = new BufferedReader((new FileReader("paginas.txt")))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(":");

                String nombrePagina = datos[0].trim();
                String fecha = datos[1].trim();

                Pagina pagina = new Pagina(nombrePagina, fecha);
                paginas.agregarFinal(pagina);
            }

            for (Pagina pagina : paginas) {
                historial.agregarPagina(pagina);
            }

            System.out.println(historial.toString());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

    }

    public static void main(String[] args) {
        String usuario = System.getProperty("user.name");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String dino = "           __\n" +
                "          / _)\n" +
                "   .-^^^-/ /\n" +
                "__/       /\n" +
                "<__.|_|-|_|\n" +
                "\nNo Internet";

        while (opcion != 3) {

            try {
                System.out.println("=================================");
                System.out.println("|      Navegador EL CHIDO       |");
                System.out.println("=================================");

                System.out.println("1. Buscar en la web");
                System.out.println("2. Acceder al historial");
                System.out.println("3. Salir :(");
                System.out.print("> ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println(" ");
                        System.out.println("!!!! Revise su conexion a internet !!!!");
                        System.out.println(dino);
                        System.out.println(" ");
                        break;

                    case 2:

                        System.out.println(" ");
                        System.out.println("=================================================");
                        System.out.println("Historial de navegacion de " + usuario.toUpperCase());
                        System.out.println("=================================================");
                        obtenerInfo();

                        break;

                    case 3:
                        System.out.println(" ");
                        System.out.println(":(");
                        break;

                    default:
                        System.out.println("Esa no es una opcion valida, favor de colocar solo 1 o 2");
                        System.out.println(" ");
                }
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("!!! Ese no es un caracter valido !!!");
                System.out.println(" ");
                sc.nextLine();
            }
        }

    }

}
