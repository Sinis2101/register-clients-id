package ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        do{

            System.out.println("MENU PRINCIPAL");
            System.out.println("--------------------------------------------------");
            System.out.println("[1] Registrar nuevo ingreso de persona.");
            System.out.println("[2] Informe de ingreso al mercado.");
            System.out.println("[3] Salir del programa.");
            System.out.println("--------------------------------------------------");
            System.out.print("Elija una opción [1-3]: ");
            option = sc.nextInt();

        } while (option!=3);

    }

}
