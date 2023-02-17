/*
*This java program is a program with 10-position vectors that has a menu where you can include student data, consult that data, modify and delete
*that data, it also has a submenu to make reports with the data of those students.
*/

package proyecto_1;

import java.util.Scanner;

/**
 *
 * @author Ernesto_Vargas, Joseph_Badilla, William_Arias
 */

public class Proyecto_1 {

    static Scanner sc = new Scanner(System.in);
    static String[] cedulaEstudiantes = new String[10];
    static String[] nombreEstudiantes = new String[10];
    static String[] apellidoEstudiantes = new String[10];
    static double[] notaEstudiantes = new double[10];
    static int numEstudiantes = 0;

    public static void main(String[] args) {

        int opcion = 0;

        do {
            mostrarMenuPrincipal();
            opcion = sc.nextInt();
            ejecutarOpcionMenuPrincipal(opcion);
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenuPrincipal() {
        System.out.println(" ");
        System.out.println("-------Menú Principal-------");
        System.out.println("1. Inicializar Vectores.");
        System.out.println("2. Incluir Estudiantes.");
        System.out.println("3. Consultar Estudiantes.");
        System.out.println("4. Modificar Estudiantes.");
        System.out.println("5. Eliminar Estudiantes.");
        System.out.println("6. Submenú Reportes.");
        System.out.println("7. Salir.");
        System.out.print("Seleccione una opción: ");
    }

    static void ejecutarOpcionMenuPrincipal(int opcion) {

        switch (opcion) {
            case 1:
                inicializarVectores();
                break;
            case 2:
                incluirEstudiante();
                break;
            case 3:
                consultarEstudiantes();
                break;
            case 4:
                modificarEstudiante();
                break;
            case 5:
                eliminarEstudiante();
                break;
            case 6:
                mostrarSubmenuReportes();
                break;
            case 7:
                System.out.println(" ");
                System.out.println("Gracias por utilizar el programa.");
                break;
            default:
                System.out.println(" ");
                System.out.println("Opción inválida.");
                System.out.println(" ");
        }
    }

    static void mostrarSubmenuReportes() {
        int opcion = 0;

        do {
            System.out.println(" ");
            System.out.println("-------Submenú Reportes-------");
            System.out.println("1. Reporte Estudiantes por Condición.");
            System.out.println("2. Reporte Todos los datos.");
            System.out.println("3. Regresar Menu Principal.");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            ejecutarOpcionSubmenuReportes(opcion);
        } while (opcion != 3);
    }

    static void ejecutarOpcionSubmenuReportes(int opcion) {
        switch (opcion) {
            case 1:
                reporteEstudiantesPorCondicion();
                break;
            case 2:
                reporteTodosLosDatos();
                break;
            case 3:
                break;
            default:
                System.out.println(" ");
                System.out.println("Opción inválida.");
                System.out.println(" ");
        }
    }

    static void inicializarVectores() {
        for (int i = 0; i < 10; i++) {
            cedulaEstudiantes[i] = "";
            nombreEstudiantes[i] = "";
            notaEstudiantes[i] = 0.0;
        }
        numEstudiantes = 0;
        System.out.println(" ");
        System.out.println("Vectores inicializados correctamente.");
        System.out.println(" ");
    }

    static void incluirEstudiante() {
        if (numEstudiantes >= 10) {
            System.out.println(" ");
            System.out.println("No se pueden incluir más estudiantes.");
            System.out.println(" ");
            return;
        }

        System.out.println(" ");
        System.out.print("Ingrese la cédula del estudiante: ");
        String cedula = sc.next();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.next();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = sc.next();
        System.out.print("Ingrese la nota del estudiante: ");
        double nota = sc.nextDouble();

        cedulaEstudiantes[numEstudiantes] = cedula;
        nombreEstudiantes[numEstudiantes] = nombre;
        apellidoEstudiantes[numEstudiantes] = apellido;
        notaEstudiantes[numEstudiantes] = nota;
        numEstudiantes++;

        System.out.println(" ");
        System.out.println("Estudiante incluido correctamente.");
        System.out.println(" ");
    }

    static void consultarEstudiantes() {
        System.out.println(" ");
        System.out.println("-------Consultar Estudiantes-------");
        System.out.println(" ");
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Cédula: " + cedulaEstudiantes[i]);
            System.out.println("Nombre: " + nombreEstudiantes[i]);
            System.out.println("Apellido: " + apellidoEstudiantes[i]);
            System.out.println("Nota: " + notaEstudiantes[i]);
            System.out.println("-------------------------");
            System.out.println(" ");
        }
    }

    static void modificarEstudiante() {
        System.out.println(" ");
        System.out.print("Ingrese la cédula del estudiante a modificar: ");
        System.out.println(" ");
        String cedula = sc.next();

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) {
                System.out.println(" ");
                System.out.print("Ingrese el nuevo nombre del estudiante: ");
                String nombre = sc.next();
                System.out.print("Ingrese el nuevo apellido del estudiante: ");
                String apellido = sc.next();
                System.out.println(" ");
                System.out.print("Ingrese la nueva nota del estudiante: ");
                double nota = sc.nextDouble();

                nombreEstudiantes[i] = nombre;
                apellidoEstudiantes[i] = apellido;
                notaEstudiantes[i] = nota;

                System.out.println(" ");
                System.out.println("Estudiante modificado correctamente.");
                System.out.println(" ");
                return;
            }
        }

        System.out.println(" ");
        System.out.println("No se encontró un estudiante con la cédula ingresada.");
        System.out.println(" ");
    }

    static void eliminarEstudiante() {
        System.out.println(" ");
        System.out.print("Ingrese la cédula del estudiante a eliminar: ");
        System.out.println(" ");
        String cedula = sc.next();

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) {
                for (int j = i; j < numEstudiantes - 1; j++) {
                    cedulaEstudiantes[j] = cedulaEstudiantes[j + 1];
                    nombreEstudiantes[j] = nombreEstudiantes[j + 1];
                    apellidoEstudiantes[j] = apellidoEstudiantes[j + 1];
                    notaEstudiantes[j] = notaEstudiantes[j + 1];
                }
                numEstudiantes--;
                System.out.println(" ");
                System.out.println("Estudiante eliminado correctamente.");
                System.out.println(" ");
                return;
            }
        }

        System.out.println(" ");
        System.out.println("No se encontró un estudiante con la cédula ingresada.");
        System.out.println(" ");
    }

    static void reporteEstudiantesPorCondicion() {
        System.out.println(" ");
        System.out.println("-------Reporte Estudiantes por Condición-------");
        System.out.println(" ");
        for (int i = 0; i < numEstudiantes; i++) {
            if (notaEstudiantes[i] >= 3.5) {
                System.out.println("Cédula: " + cedulaEstudiantes[i]);
                System.out.println("Nombre: " + nombreEstudiantes[i]);
                System.out.println("Apellido: " + apellidoEstudiantes[i]);
                System.out.println("Nota: " + notaEstudiantes[i]);
                System.out.println("Condicion: DEBEMOS CONSTRUIR LA LOGICA PARA ESTE CAMPO");
                System.out.println("-------------------------");
                System.out.println(" ");
            }
        }
    }

    static void reporteTodosLosDatos() {
        System.out.println(" ");
        System.out.println("-------Reporte Todos los datos-------");
        System.out.println(" ");
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Cédula: " + cedulaEstudiantes[i]);
            System.out.println("Nombre: " + nombreEstudiantes[i]);
            System.out.println("Apellido: " + apellidoEstudiantes[i]);
            System.out.println("Nota: " + notaEstudiantes[i]);
            System.out.println("-------------------------");
            System.out.println(" ");
        }
    }
}
