
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
            System.out.println("\n------Menu Principal------\n");
            System.out.println("1. Inicializar Vectores.");
            System.out.println("2. Incluir Estudiantes.");
            System.out.println("3. Consultar Estudiantes.");
            System.out.println("4. Modificar Estudiantes.");
            System.out.println("5. Eliminar Estudiantes.");
            System.out.println("6. Submenu Reportes.");
            System.out.println("7. Salir.");
            System.out.print("\nSeleccione una opcion: ");

            // Validar entrada para que sea un número del 1 al 7
            String input = scanner.nextLine();

            while (!input.matches("[1-7]") || !Character.isDigit(input.charAt(0))) { // Este while se usa para validar que unicamente se ingresen numeros del 1 al 7                                                                             
                System.out.println("\nLa opcion: \"" + input + "\" es invalida.");                 // se implementa en todos los submenus.
                System.out.print("Seleccione una opcion valida del menu (numero): ");           //!input.matches[1-7]" se utiliza para verificar 
                input = scanner.nextLine();                                                       //si la entrada del usuario es un número del 1 al 7.    
            }                                                                                     //isDigit() se utiliza para verificar si el carácter es un dígito.  
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
                    System.out.println("\nSaliendo del programa...");
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    // System.out.println("\n La opcion marcada es invalida.");
            }
        }
        scanner.close();
    }
}
