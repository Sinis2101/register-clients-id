package ui;

import exceptions.IDParityException;
import exceptions.IDTypeException;
import model.Marketplace;
import model.Person;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;
        int day;

        System.out.println("¡Bienvenido al programa! Para iniciar el programa se necesita un día del mes...");
        System.out.println("--------------------------------------------------");
        System.out.println("[1] Usar fecha del sistema.");
        System.out.println("[2] Introducir día del mes manualmente.");
        System.out.println("--------------------------------------------------");
        System.out.print("Elija una opción [1-2]: "); option = sc.nextInt(); sc.nextLine();
        if(option==2) {
            System.out.println("--------------------------------------------------");
            System.out.print("Introduzca un día del mes [1-31]: "); day = sc.nextInt(); sc.nextLine();
        } else {
            day = LocalDate.now().getDayOfMonth();
        }
        Marketplace mp = new Marketplace(day);

        do {

            System.out.println("--------------------------------------------------");
            System.out.println("MENU PRINCIPAL" + " - Día actual: " + mp.getCurrentDay());
            System.out.println("--------------------------------------------------");
            System.out.println("[1] Registrar nuevo ingreso de persona.");
            System.out.println("[2] Informe de intentos de ingreso al mercado.");
            System.out.println("[3] Salir del programa.");
            System.out.println("--------------------------------------------------");
            System.out.print("Elija una opción [1-3]: "); option = sc.nextInt(); sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("TIPO DE DOCUMENTO");
                    System.out.println("--------------------------------------------------");
                    System.out.println("[1] Tarjeta de identidad.");
                    System.out.println("[2] Cédula de ciudadanía.");
                    System.out.println("[3] Pasaporte.");
                    System.out.println("[4] Cédula de extranjería.");
                    System.out.println("--------------------------------------------------");
                    System.out.print("Elija una opción [1-4]: "); int idType = sc.nextInt(); sc.nextLine();
                    System.out.println("--------------------------------------------------");
                    System.out.print("Ingrese el número del documento: "); String id = sc.nextLine();
                    System.out.println("--------------------------------------------------");
                    try {
                        mp.attemptAccess(new Person(idType, id));
                        System.out.print("La persona con número de documento " + id + " puede ingresar. Presione ENTER para continuar..."); sc.nextLine();
                    } catch (IDParityException | IDTypeException e) {
                        System.out.print(e.getMessage() + " Presione ENTER para continuar..."); sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------------------------");
                    System.out.println("INTENTOS DE INGRESO AL MERCADO");
                    System.out.println("--------------------------------------------------");
                    System.out.println("Intentos totales: " + mp.getAccessAttempts());
                    System.out.println("Accesos denegados: " + (mp.getAccessAttempts() - mp.getAccessors().size()));
                    System.out.println("Accesos permitidos: " + mp.getAccessors().size());
                    System.out.println("--------------------------------------------------");
                    System.out.print("Presione ENTER para continuar..."); sc.nextLine();
                    break;
            }

        } while (option!=3);



    }

}
