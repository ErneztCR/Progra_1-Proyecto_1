package proyecto_1;

import java.util.Scanner;

public class ClasMenuPrin {

    Scanner sc = new Scanner(System.in);
    int opcion = 0;

    public ClasMenuPrin() {
        opcion = 0;

    }

    public void Menuprin() {
        Scanner scanner = new Scanner(System.in);
        while (opcion != 7) {
            System.out.println("\n-------Menu Principal-------\n");
            System.out.println("1. Inicializar Vectores.");
            System.out.println("2. Incluir Estudiantes.");
            System.out.println("3. Consultar Estudiantes.");
            System.out.println("4. Modificar Estudiantes.");
            System.out.println("5. Eliminar Estudiantes.");
            System.out.println("6. Submenu Reportes.");
            System.out.println("7. Salir.");
            System.out.print("\n Seleccione una opcion: ");
            // Validar entrada para que sea un número del 1 al 7
            String input = scanner.nextLine();
            while (!input.matches("[1-7]") || !Character.isDigit(input.charAt(0))) {
                System.out.print("\n Opcion invalida.\n \n Digite el numero de la opcion que desea: ");
                input = scanner.nextLine();
            }
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    ClasEstudiantes.inicializarVec();
                    break;
                case 2:
                    ClasEstudiantes.IncluirEstud();
                    break;
                case 3:
                    ClasEstudiantes.ConsultarEstud();
                    break;
                case 4:
                    ClasEstudiantes.ModificarEstud();
                    break;
                case 5:
                    ClasEstudiantes.EliminarEstud();
                    break;
                case 6:
                    ClasEstudiantes.SubmenuReportes();
                    break;
                case 7:

                    System.out.println("\nGracias por utilizar el programa.\n");
                    break;
                default:
                    System.out.print("\nOpcion invalida. \nDigite el numero de la opcion que desea: ");
            }
        }
        scanner.close();
    }
}
