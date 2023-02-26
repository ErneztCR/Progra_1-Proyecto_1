
package proyecto_1;

import java.util.Scanner;

public class ClasEstudiantes {
    static Scanner sc = new Scanner(System.in);
    static String[] cedulaEstudiantes = new String[10];
    static String[] nombreEstudiantes = new String[10];
    static String[] apellidoEstudiantes = new String[10];
    static double[] notaEstudiantes = new double[10];
    static int numEstudiantes = 0;

  static void SubmenuReportes() {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcion != 3) {
            System.out.println("\n-------Submenu Reportes-------\n");
            System.out.println("1. Reporte Estudiantes por Condicion.");
            System.out.println("2. Reporte Todos los datos.");
            System.out.println("3. Regresar Menu Principal.");
            System.out.print("Seleccione una opcion:");
             // Validar entrada para que sea un número del 1 al 3
             String input = scanner.nextLine();
        while (!input.matches("[1-3]") || !Character.isDigit(input.charAt(0))) {
            System.out.println("La opcion marcada es invalida.");
            input = scanner.nextLine();
        }

        opcion = Integer.parseInt(input);
            
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
                    
                    System.out.println("La opcion marcada es invalida.");
            }
        }
        scanner.close();
}

    static void inicializarVec() {
        for (int i = 0; i < 10; i++) {
            cedulaEstudiantes[i] = "";
            nombreEstudiantes[i] = "";
            notaEstudiantes[i] = 0.0;
        }
        numEstudiantes = 0;
        System.out.println("\n Vectores inicializados correctamente.\n"); 
    }

    static void IncluirEstud() {
       
        if (numEstudiantes >= 10) {
            System.out.println("No se pueden incluir mas estudiantes.");
            return;
        }

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
        System.out.println("\n Estudiante incluido correctamente.\n");
    }

    static void ConsultarEstud() {
        
        System.out.println("\n-------Consultar Estudiantes-------\n");
       
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Cedula: " + cedulaEstudiantes[i]);
            System.out.println("Nombre: " + nombreEstudiantes[i]);
            System.out.println("Apellido: " + apellidoEstudiantes[i]);
            System.out.println("Nota: " + notaEstudiantes[i]);
            System.out.println("-------------------------");
        }
    }

    static void ModificarEstud() {
        
        System.out.print("Ingrese la cedula del estudiante a modificar: ");
        String cedula = sc.next();

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) {
                
                System.out.print(" Ingrese el nuevo nombre del estudiante: ");
                String nombre = sc.next();
                System.out.print("Ingrese el nuevo apellido del estudiante: ");
                String apellido = sc.next();
                System.out.print("Ingrese la nueva nota del estudiante: ");
                double nota = sc.nextDouble();
                nombreEstudiantes[i] = nombre;
                apellidoEstudiantes[i] = apellido;
                notaEstudiantes[i] = nota;

                System.out.println("\n Estudiante modificado correctamente. \n");
                return;
            }
        }
        System.out.println("\n No se encontro un estudiante con la cedula ingresada. \n");
    }

    static void EliminarEstud() {
     
        System.out.print("Ingrese la cedula del estudiante a eliminar: ");
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
                System.out.println("\n Estudiante eliminado correctamente.\n");
                return;
            }
        }
        System.out.println("\n No se encontro un estudiante con la cedula ingresada.\n");
    }

    static void reporteEstudiantesPorCondicion() {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcion != 4) {
            
            System.out.println("\n*******Reporte Estudiantes por Condicion******\n");
            System.out.println("1. Aprobado(s)");
            System.out.println("2. Reprobado(s)");
            System.out.println("3. Aplazado(s)");
            System.out.println("4. Regresar al Sub-menu de reportes");
            System.out.print("Seleccione una opcion: ");
            
            // Validar entrada para que sea un número del 1 al 4
             String input = scanner.nextLine();
        while (!input.matches("[1-4]") || !Character.isDigit(input.charAt(0))) {
            System.out.println("La opcion marcada es invalida.");
            input = scanner.nextLine();
        }
            opcion = Integer.parseInt(input);
            
            switch (opcion) {

                case 1: // Aprobados
                    Est_aprobados();
                  
                    break;

                case 2: // Reprobados
                    Est_reprobados();
                   
                    break;

                case 3: // Aplazados
                    Est_aplazados();
                    
                    break;

                case 4:

                    return;

                default:
                    System.out.println("La opcion marcada es invalida.");
            }
        }scanner.close();
    }
    static void Est_aprobados(){
    int numEstudiantesRegistrados = numEstudiantes;
    boolean NohayEstu_Apro = false;
        
    if (numEstudiantesRegistrados > 0 ) {
        System.out.println("Estudiantes Aprobados: ");
        for (int i = 0; i < numEstudiantes; i++) {
            if (notaEstudiantes[i] >= 70) {
                System.out.println("Cedula: " + cedulaEstudiantes[i]
                        + " Nombre: " + nombreEstudiantes[i]
                        + " Apellido: " + apellidoEstudiantes[i]
                        + " Nota: " + notaEstudiantes[i]);
                NohayEstu_Apro  = true;
            }
        }
        if (!NohayEstu_Apro ) {
            System.out.println("No hay estudiantes aprobados.\n");
        }
    } else {
        System.out.println("\n No hay estudiantes registrados.");
    } 
}
    static void Est_reprobados(){
    int numEstudiantesRegistrados = numEstudiantes;
        
    if (numEstudiantesRegistrados > 0) {
        System.out.println("Estudiantes Reprobados:");
        boolean hayEstudiantesReprobados = false;
        for (int i = 0; i < numEstudiantes; i++) {
            if (notaEstudiantes[i] <= 59) {
                System.out.println("Cedula: " + cedulaEstudiantes[i]
                        + " Nombre: " + nombreEstudiantes[i]
                        + " Apellido: " + apellidoEstudiantes[i]
                        + " Nota: " + notaEstudiantes[i]);
                hayEstudiantesReprobados = true;
            }
        }          
        if (!hayEstudiantesReprobados) {
            System.out.println("\n No hay estudiantes reprobados.");
        }
    }else {
        System.out.println("\n No hay estudiantes registrados.");
    }  
}
    
    static void Est_aplazados() {
    int numEstudiantesRegistrados = numEstudiantes;
    
    if (numEstudiantesRegistrados > 0) {
        System.out.println("Estudiantes Aplazados:");
        boolean hayEstudiantesAplazados = false;
        for (int i = 0; i < numEstudiantes; i++) {
            if (notaEstudiantes[i] < 70 && notaEstudiantes[i] >= 60) {
                hayEstudiantesAplazados = true;
                System.out.println("Cedula: " + cedulaEstudiantes[i]
                        + " Nombre: " + nombreEstudiantes[i]
                        + " Apellido: " + apellidoEstudiantes[i]
                        + " Nota: " + notaEstudiantes[i]);
            }
        }
        if (!hayEstudiantesAplazados) {
            System.out.println("\n No hay estudiantes aplazados.");
        }
    } else {
        System.out.println("\n No hay estudiantes registrados.");
    }
}

    static void reporteTodosLosDatos() {
        System.out.println(" ");
        System.out.println(String.format("%50s", "REPORTE DE ESTUDIANTES"));
        System.out.println("==========================================================================================");
        System.out.println(
        String.format("%-8s %-24s %-24s %-16s %-16s", "Cedula", "Nombre", "Apellido", "Promedio", "Condicion"));
        System.out.println("==========================================================================================");

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

            System.out.println("==========================================================================================");
            System.out.println(" ");
            System.out.println("Nota Mayor: " + promedioMayor + " (estudiante: " + nombreEstudianteMayorPromedio + ")");
            System.out.println("Nota Menor: " + promedioMenor + " (estudiante: " + nombreEstudianteMenorPromedio + ")");
            System.out.println("Cantidad de estudiantes aprobados: " + numEstudiantesAprobados);
            System.out.println("Cantidad de estudiantes aplazados: " + numEstudiantesAplazados);
            System.out.println("Cantidad de estudiantes reprobados: " + numEstudiantesReprobados);
        } else {
            System.out.println("\n No hay estudiantes registrados.");
        }
    }
}    
