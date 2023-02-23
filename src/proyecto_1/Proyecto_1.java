/*
*This java program is a program with 10-position vectors that has a menu where you can include student data, consult that data, modify and delete
*that data, it also has a submenu to make reports with the data of those students.
 */
package proyecto_1;

import java.util.Scanner;

/**
 *
 * @author Ernesto_Vargas, Joseph_Badilla, William_Arias
 *
 */
public class Proyecto_1 {

    static Scanner sc = new Scanner(System.in);
    static String[] cedulaEstudiantes = new String[10];
    static String[] nombreEstudiantes = new String[10];
    static String[] apellidoEstudiantes = new String[10];
    static double[] notaEstudiantes = new double[10];
    static int numEstudiantes = 0;

    public static void main(String[] args) {

        MenuPrincipal();

    }

    static void MenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println(" ");
            System.out.println("-------Menu Principal-------");
            System.out.println("1. Inicializar Vectores.");
            System.out.println("2. Incluir Estudiantes.");
            System.out.println("3. Consultar Estudiantes.");
            System.out.println("4. Modificar Estudiantes.");
            System.out.println("5. Eliminar Estudiantes.");
            System.out.println("6. Submenu Reportes.");
            System.out.println("7. Salir.");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    inicializarVec();
                    break;
                case 2:
                    IncluirEstud();
                    break;
                case 3:
                    ConsultarEstud();
                    break;
                case 4:
                    ModificarEstud();
                    break;
                case 5:
                    EliminarEstud();
                    break;
                case 6:
                    SubmenuReportes();
                    break;
                case 7:
                    System.out.println(" ");
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opcion invalida.");
                    System.out.println(" ");
            }
        }
        sc.close();
    }

    static void SubmenuReportes() {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        while (opcion != 3) {
            System.out.println(" ");
            System.out.println("-------Submenu Reportes-------");
            System.out.println("1. Reporte Estudiantes por Condicion.");
            System.out.println("2. Reporte Todos los datos.");
            System.out.println("3. Regresar Menu Principal.");
            System.out.println(" ");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    reporteEstudiantesPorCondicion();
                    break;
                case 2:
                    reporteTodosLosDatos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(" ");
                    System.out.println("Opcion invalida.");
                    System.out.println("Digite el numero de la opcion que desea");
                    System.out.println(" ");
            }
        }
        sc.close();
    }

    static void inicializarVec() {
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

    static void IncluirEstud() {
        if (numEstudiantes >= 10) {
            System.out.println(" ");
            System.out.println("No se pueden incluir mas estudiantes.");
            System.out.println(" ");
            return;
        }

        System.out.println(" ");
        System.out.print("Ingrese la cedula del estudiante: ");
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

    static void ConsultarEstud() {
        System.out.println(" ");
        System.out.println("-------Consultar Estudiantes-------");
        System.out.println(" ");
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Cedula: " + cedulaEstudiantes[i]);
            System.out.println("Nombre: " + nombreEstudiantes[i]);
            System.out.println("Apellido: " + apellidoEstudiantes[i]);
            System.out.println("Nota: " + notaEstudiantes[i]);
            System.out.println("-------------------------");
            System.out.println(" ");
        }
    }

    static void ModificarEstud() {
        System.out.println(" ");
        System.out.print("Ingrese la cedula del estudiante a modificar: ");
        System.out.println(" ");
        String cedula = sc.next();

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) {
                System.out.println(" ");
                System.out.print("Ingrese el nuevo nombre del estudiante: ");
                String nombre = sc.next();
                System.out.print("Ingrese el nuevo apellido del estudiante: ");
                String apellido = sc.next();
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
        System.out.println("No se encontro un estudiante con la cédula ingresada.");
        System.out.println(" ");
    }

    static void EliminarEstud() {
        System.out.println(" ");
        System.out.print("Ingrese la cedula del estudiante a eliminar: ");
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
        System.out.println("No se encontro un estudiante con la cedula ingresada.");
        System.out.println(" ");
    }

    static void reporteEstudiantesPorCondicion() {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("*******Reporte Estudiantes por Condicion******");
            System.out.println("1. Aprobado(s)");
            System.out.println("2. Reprobado(s)");
            System.out.println("3. Aplazado(s)");
            System.out.println("4. Regresar al Sub-menu de reportes");
            System.out.print("Seleccione una opcion: ");
            int condicion = sc.nextInt();

            switch (condicion) {

                case 1: // Aprobados

                    System.out.println(" ");
                    System.out.println("Estudiantes Aprobados:");
                    for (int i = 0; i < numEstudiantes; i++) {
                        if (notaEstudiantes[i] >= 70) {
                            System.out.println("Cedula: " + cedulaEstudiantes[i]
                                    + " Nombre: " + nombreEstudiantes[i]
                                    + " Apellido: " + apellidoEstudiantes[i]
                                    + " Nota: " + notaEstudiantes[i]);
                        }
                    }
                    break;

                case 2: // Reprobados

                    System.out.println(" ");
                    System.out.println("Estudiantes Reprobados:");
                    for (int i = 0; i < numEstudiantes; i++) {
                        if (notaEstudiantes[i] <= 59) {
                            System.out.println("Cedula: " + cedulaEstudiantes[i]
                                    + " Nombre: " + nombreEstudiantes[i]
                                    + " Apellido: " + apellidoEstudiantes[i]
                                    + " Nota: " + notaEstudiantes[i]);
                        }
                    }
                    break;

                case 3: // Aplazados

                    System.out.println(" ");
                    System.out.println("Estudiantes Aplazados:");
                    for (int i = 0; i < numEstudiantes; i++) {
                        if (notaEstudiantes[i] < 70 && notaEstudiantes[i] >= 60) {
                            System.out.println("Cedula: " + cedulaEstudiantes[i]
                                    + " Nombre: " + nombreEstudiantes[i]
                                    + " Apellido: " + apellidoEstudiantes[i]
                                    + " Nota: " + notaEstudiantes[i]);
                        }
                    }
                    break;

                case 4:

                    return;

                default:
                    System.out.println(" ");
                    System.out.println("Opcion invalida.");
                    System.out.println("Digite el numero de la opcion que desea");
                    System.out.println(" ");
            }
        }
    }

    static void reporteTodosLosDatos() {
        System.out.println(" ");
        System.out.println(String.format("%50s", "REPORTE DE ESTUDIANTES"));
        System.out
                .println("==========================================================================================");
        System.out.println(
                String.format("%-8s %-24s %-24s %-16s %-16s", "Cedula", "Nombre", "Apellido", "Promedio", "Condicion"));
        System.out
                .println("==========================================================================================");

        double promedioMayor = 0;
        double promedioMenor = 0; // inicializamos con el primer promedio
        String nombreEstudianteMenorPromedio = ""; // inicializamos con un valor vacío
        String nombreEstudianteMayorPromedio = "";
        int numEstudiantesAprobados = 0;
        int numEstudiantesReprobados = 0;
        int numEstudiantesAplazados = 0;
        int numEstudiantesRegistrados = numEstudiantes;

        if (numEstudiantesRegistrados > 0) { // verificamos que haya estudiantes registrados
            promedioMenor = notaEstudiantes[0]; // inicializamos con el primer promedio
            for (int i = 0; i < numEstudiantesRegistrados; i++) {
                double promedio = notaEstudiantes[i];
                if (promedio > promedioMayor) {
                    promedioMayor = promedio;
                    nombreEstudianteMayorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio < promedioMenor) {
                    promedioMenor = promedio;
                    nombreEstudianteMenorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio >= 70) { // si el promedio es mayor o igual a 70 está aprobado
                    numEstudiantesAprobados++;
                    System.out.println(String.format("%-8s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Aprobado"));
                } else if (promedio >= 60) { // si el promedio es mayor o igual a 60 está aplazado
                    numEstudiantesAplazados++;
                    System.out.println(String.format("%-8s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Aplazado"));
                } else {
                    numEstudiantesReprobados++;
                    System.out.println(String.format("%-8s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Reprobado"));
                }
            }

            System.out
                    .println("==========================================================================================");

            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println(" ");

            System.out.println(
                    "Promedio Mayor: " + promedioMayor + " (estudiante: " + nombreEstudianteMayorPromedio + ")");
            System.out.println(
                    "Promedio Menor: " + promedioMenor + " (estudiante: " + nombreEstudianteMenorPromedio + ")");
            System.out.println("Cantidad de estudiantes aprobados: " + numEstudiantesAprobados);
            System.out.println("Cantidad de estudiantes aplazados: " + numEstudiantesAplazados);
            System.out.println("Cantidad de estudiantes reprobados: " + numEstudiantesReprobados);
        } else {
            System.out.println("No hay estudiantes registrados.");
        }
    }
}
