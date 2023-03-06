
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
        Scanner sc = new Scanner(System.in);
        while (opcion != 3) {
            System.out.println("\n-------Submenu Reportes-------\n");
            System.out.println("1. Reporte Estudiantes por Condicion.");
            System.out.println("2. Reporte Todos los datos.");
            System.out.println("3. Regresar Menu Principal.");
            System.out.print("\n Seleccione una opcion:");
            // Validar entrada para que sea un número del 1 al 3
            String input = sc.nextLine();
            while (!input.matches("[1-3]") || !Character.isDigit(input.charAt(0))) {
               System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
               System.out.print("Seleccione una opcion valida del menu (numero): ");
                input = sc.nextLine();
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

                System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
                System.out.print("Seleccione una opcion valida del menu (numero): ");
            }
        }
        sc.close();
    }

    static void inicializarVec() {  //for para inicializar los vectores de los estudiantes.
        for (int i = 0; i < 10; i++) {
            cedulaEstudiantes[i] = "";
            nombreEstudiantes[i] = "";
            notaEstudiantes[i] = 0.0;
        }
        numEstudiantes = 0;
        System.out.println("\n\033[1m=== Vectores inicializados correctamente ===\033[0m\n");
    }

    static void IncluirEstud() {

     
        if (numEstudiantes >= 10) {    // if valida que no se haya llegado al máximo de estudiantes.
            System.out.println("\n\033[1m*** No se pueden incluir mas estudiantes ***\033[0m\n");
            return;
        }

        boolean cedulaValida = false;
        boolean nombreValido = false;
        boolean apellidoValido = false;
        boolean notaValida = false;

        String cedula = "0";
        String nombre = "0";
        String apellido = "0";
        double nota = 0.0;

        System.out.println("\n-------Incluir Estudiante-------\n");

        
        do { 
    System.out.print("\nIngrese la cedula del estudiante (sin espacios ni guiones ej: 1234567890): ");
    cedula = sc.nextLine();

    
    boolean cedulaRepetida = false;
    for (int i = 0; i < numEstudiantes; i++) { // for Verifica si la cédula se repite.
        if (cedulaEstudiantes[i].equals(cedula)) {
            cedulaRepetida = true;
            break;
        }
    }

    if (!cedula.matches("[0-9]+")) { // if se usa para que unicamente se acepte numeros del 0-9.
        System.out.println("\n\033[1mXxX La cedula no debe contener espacios ni letras XxX\033[0m\n");
    } else if (cedulaRepetida) {
        System.out.println("\n\033[1mXxX La cedula ya existe XxX\033[0m\n");
    } else {
        cedulaValida = true;
    }
} while (!cedulaValida);       

        
        do {
    System.out.print("\nIngrese el nombre del estudiante (solo debe ser uno): ");
    nombre = sc.nextLine();

    if (!nombre.matches("[a-zA-Z]+")) { // if valida que solo sean letras.
        System.out.println("\n\033[1mXxX El nombre no debe contener espacios ni números XxX\033[0m\n");
    } else {
        nombreValido = true;
    }
} while (!nombreValido);

        
        do {
            System.out.print("\nIngrese el apellido del estudiante (solo debe ser uno): ");
            apellido = sc.nextLine();

            if (!apellido.matches("[a-zA-Z]+")) { // if valida que solo sean letras.
                System.out.println("\n\033[1mXxX El apellido no debe contener espacios ni numerosXxX\033[0m\n");
            } else {
                apellidoValido = true;
            }
        } while (!apellidoValido);

        
        // llenar el vector de notas y validar que la nota este entre 0 y 100.
        do {
            System.out.print("\nIngrese la nota del estudiante: ");
            
            String entrada = sc.nextLine().trim(); // Eliminar espacios en blanco antes y después de la entrada.
            
            if (entrada.matches("[0-9]+(\\.[0-9]+)?")) { // if valida que la entrada contenga solo dígitos y un punto decimal.
                nota = Double.parseDouble(entrada);

                if (nota < 0 || nota > 100) {  // if valida que la entrada contenga notas minimos de 0 y maximas de 100.
                    System.out.println("\n\033[1mXxX Error: la nota debe estar entre 0 y 100. XxX\033[0m\n");
                } else {
                    notaValida = true;
                }
            } else {
                System.out.println("\n\033[1mXxX Error: debe ingresar un número para la nota XxX\033[0m\n");
            }
        } while (!notaValida);
        
        System.out.println("\nLa nota ingresada es: " + nota);
    
        // al final se llenan los vectores con los datos del estudiantes.
        cedulaEstudiantes[numEstudiantes] = cedula;
        nombreEstudiantes[numEstudiantes] = nombre;
        apellidoEstudiantes[numEstudiantes] = apellido;
        notaEstudiantes[numEstudiantes] = nota;
        numEstudiantes++;

        System.out.println("\n\033[1m=== Estudiante incluido correctamente ===\033[0m\n");
    }

    public static void ConsultarEstud() {

        System.out.println("\n-------Consultar Estudiante-------\n");
        System.out.print("Ingrese la cedula del estudiante a consultar: ");
        String cedula = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < cedulaEstudiantes.length; i++) { //for valida las cedulas ingresadas.
            if (cedula.equals(cedulaEstudiantes[i])) {

                System.out.println(" ");
                System.out.println(String.format("%50s", "CONSULTA DE ESTUDIANTE")); // Este formato "%-16s" sirve para dar espacios.
                System.out.println(
                        "=========================================================================");
                System.out.println(String.format("%-16s %-24s %-24s %-16s", "Cedula", "Nombre", "Apellido",
                        "Nota"));
                System.out.println(
                        "-------------------------------------------------------------------------");
                System.out.println(String.format("%-16s %-24s %-24s %-16s", cedulaEstudiantes[i],
                        nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i]));
                System.out.println(
                        "=========================================================================\n");
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("\n\033[1mXxX No se encontro el estudiante con la cedula ingresada XxX\033[0m\n");
        }
    }

    static void ModificarEstud() {
        boolean cedulaValida = false;
        boolean nombreValido = false;
        boolean apellidoValido = false;
        boolean notaValida = false;

        String cedula = "0";
        String nombre = "0";
        String apellido = "0";
        double nota = 0.0;

        System.out.println("\n-------Modificar Estudiante-------\n");
        System.out.print("\nIngrese la cedula del estudiante a modificar: ");
        cedula = sc.nextLine();

        for (int i = 0; i < numEstudiantes; i++) { 
            if (cedulaEstudiantes[i].equals(cedula)) {//if valida las cedulas ingresadas.
                
                do {    //do-while verifica que la cedula sea valida.
                    System.out.print("\nIngrese la nueva cedula del estudiante (sin espacios ni guiones ej: 1234567890): ");
                    cedula = sc.nextLine();

                    if (!cedula.matches("[0-9]+")) { // valida que la cedula no tenga espacios ni letras.
     
        System.out.println("\n\033[1mXxX La cedula no debe contener espacios ni letras XxX\033[0m\n");
         }  else {
        cedulaValida = true;
         }
            } while (!cedulaValida);

                
                do {  //do-while verifica que el nombre sea valido.
                    System.out.print("\nIngrese el nuevo nombre del estudiante (solo debe ser uno): ");
                    nombre = sc.nextLine();

                    if (!nombre.matches("[a-zA-Z]+")) { //if verifica que solo se digiten letras.
                    System.out.println("\n\033[1mXxX El nombre no debe contener espacios ni números XxX\033[0m\n");
                 } else {
                        nombreValido = true;
                    }
                } while (!nombreValido);

                
                do {
                    System.out.print("\nIngrese el nuevo apellido del estudiante (solo debe ser uno): ");
                    apellido = sc.nextLine();

                    if (!apellido.matches("[a-zA-Z]+")) {//if verifica que solo se digiten letras.
                System.out.println("\n\033[1mXxX El apellido no debe contener espacios ni numerosXxX\033[0m\n");
            } else {
                        apellidoValido = true;
                    }
                } while (!apellidoValido);
        
                
                do {
            System.out.print("\nIngrese la nota del estudiante: ");
            
            String entrada = sc.nextLine().trim(); // Eliminar espacios en blanco antes y después de la entrada
            
            if (entrada.matches("[0-9]+(\\.[0-9]+)?")) { // Validar que la entrada contenga solo dígitos y un punto decimal
                nota = Double.parseDouble(entrada);

                if (nota < 0 || nota > 100) { /// if verifica que la nota debe estar entre 0 y 100.
                    System.out.println("\n\033[1mXxX Error: la nota debe estar entre 0 y 100. XxX\033[0m\n");
                } else {
                    notaValida = true;
                }
            } else {
                System.out.println("\n\033[1mXxX Error: debe ingresar un número para la nota XxX\033[0m\n");
            }
        } while (!notaValida);
        
        System.out.println("\nLa nota ingresada es: " + nota);
                //se llena los vectores con los nuevos cambios.
                cedulaEstudiantes[i] = cedula;
                nombreEstudiantes[i] = nombre;
                apellidoEstudiantes[i] = apellido;
                notaEstudiantes[i] = nota;

                System.out.println("\n\033[1m=== Estudiante modificado correctamente ===\033[0m\n");
                return;
            }
        }
        System.out.println("\n\033[1mXxX No se encontro un estudiante con la cedula ingresada XxX\033[0m\n");
    }

    static void EliminarEstud() {

        System.out.print("\nIngrese la cedula del estudiante a eliminar: ");
        String cedula = sc.next();
        sc.nextLine(); // Limpia el buffer para la siguiente entrada

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) { //if para verficar si coincide la cedula digitada con la guardada.
                for (int j = i; j < numEstudiantes - 1; j++) { // for se mueve una posicion hacia atras para eliminar los datos del estudiante.
                    cedulaEstudiantes[j] = cedulaEstudiantes[j + 1];
                    nombreEstudiantes[j] = nombreEstudiantes[j + 1];
                    apellidoEstudiantes[j] = apellidoEstudiantes[j + 1];
                    notaEstudiantes[j] = notaEstudiantes[j + 1];
                }
                numEstudiantes--;
                System.out.println("\n\033[1m=== Estudiante eliminado correctamente ===\033[0m\n");
                return;
            }
        }
        System.out.println("\n\033[1mXxX No se encontro un estudiante con la cedula ingresada XxX\033[0m\n");
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
            System.out.print("\nSeleccione una opcion: ");

            // Validar entrada para que sea un número del 1 al 4
            String input = scanner.nextLine();
            while (!input.matches("[1-4]") || !Character.isDigit(input.charAt(0))) {
                System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
                System.out.print("Seleccione una opcion valida del menu (numero): ");
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
                    System.out.println("\n\033[1mXxX La opcion marcada es invalida XxX\033[0m");
            }
        }
        scanner.close();
    }

    static void Est_aprobados() {
        int numEstudiantesRegistrados = numEstudiantes;
        boolean NohayEstu_Apro = false;

        if (numEstudiantesRegistrados > 0) { //if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Aprobados: ");
            for (int i = 0; i < numEstudiantes; i++) {
                if (notaEstudiantes[i] >= 70) { //if verifica si hay estudiantes aprobados.
                    System.out.println("Cedula: " + cedulaEstudiantes[i]
                            + " Nombre: " + nombreEstudiantes[i]
                            + " Apellido: " + apellidoEstudiantes[i]
                            + " Nota: " + notaEstudiantes[i]);
                    NohayEstu_Apro = true;
                }
            }
            if (!NohayEstu_Apro) {
                System.out.println("\033[1mNo hay estudiantes aprobados.\033[0m\n");
            }
        } else {
            System.out.println("\n\033[1mNo hay estudiantes registrados.\033[0m");
        }
    }

    static void Est_reprobados() {
        int numEstudiantesRegistrados = numEstudiantes;

        if (numEstudiantesRegistrados > 0) { //if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Reprobados:");
            boolean hayEstudiantesReprobados = false;
            for (int i = 0; i < numEstudiantes; i++) {
                if (notaEstudiantes[i] <= 59) {//if verifica si hay estudiantes reprobados.
                    System.out.println("Cedula: " + cedulaEstudiantes[i]
                            + " Nombre: " + nombreEstudiantes[i]
                            + " Apellido: " + apellidoEstudiantes[i]
                            + " Nota: " + notaEstudiantes[i]);
                    hayEstudiantesReprobados = true;
                }
            }
            if (!hayEstudiantesReprobados) {
                System.out.println("\n\033[1mNo hay estudiantes reprobados.\033[0m");
            }
        } else {
            System.out.println("\n\033[1mNo hay estudiantes registrados.\033[0m");
        }
    }

    static void Est_aplazados() {
        int numEstudiantesRegistrados = numEstudiantes;

        if (numEstudiantesRegistrados > 0) {//if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Aplazados:");
            boolean hayEstudiantesAplazados = false;
            for (int i = 0; i < numEstudiantes; i++) { //if verifica si hay estudiantes aplazados.
                if (notaEstudiantes[i] < 70 && notaEstudiantes[i] >= 60) {
                    hayEstudiantesAplazados = true;
                    System.out.println("Cedula: " + cedulaEstudiantes[i]
                            + " Nombre: " + nombreEstudiantes[i]
                            + " Apellido: " + apellidoEstudiantes[i]
                            + " Nota: " + notaEstudiantes[i]);
                }
            }
            if (!hayEstudiantesAplazados) {
                System.out.println("\n\033[1mNo hay estudiantes aplazados.\033[0m");
            }
        } else {
            System.out.println("\n\033[1mNo hay estudiantes registrados.\033[0m");
        }
    }

    static void reporteTodosLosDatos() {
        System.out.println(" ");
        System.out.println(String.format("%50s", "REPORTE DE ESTUDIANTES"));
        System.out
                .println(
                        "=============================================================================================");
        System.out.println(
                String.format("%-16s %-24s %-24s %-16s %-16s", "Cedula", "Nombre", "Apellido", "Notas", "Condicion"));
        System.out
                .println(
                        "=============================================================================================");

        double promedioMayor = 0;
        double promedioMenor = 0; 
        String nombreEstudianteMenorPromedio = ""; 
        String nombreEstudianteMayorPromedio = "";
        int numEstudiantesAprobados = 0;
        int numEstudiantesReprobados = 0;
        int numEstudiantesAplazados = 0;
        int numEstudiantesRegistrados = numEstudiantes;

        if (numEstudiantesRegistrados > 0) { // if verifica que haya estudiantes registrados.
            promedioMenor = notaEstudiantes[0]; 
            for (int i = 0; i < numEstudiantesRegistrados; i++) {
                double promedio = notaEstudiantes[i];
                if (promedio > promedioMayor) { // if para bucar el estudiante con mayor nota(Fue un agregado de nuestra parte).
                    promedioMayor = promedio;
                    nombreEstudianteMayorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio < promedioMenor) { // if para bucar el estudiante con menor nota.
                    promedioMenor = promedio;
                    nombreEstudianteMenorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio >= 70) { // "if", "else if", "else if", para determinar cuales estudiantes estan aprobados, aplazados o reprobados.
                    numEstudiantesAprobados++;
                    System.out.println(String.format("%-16s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Aprobado"));
                } else if (promedio >= 60) { // si el promedio es mayor o igual a 60 está aplazado
                    numEstudiantesAplazados++;
                    System.out.println(String.format("%-16s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Aplazado"));
                } else {
                    numEstudiantesReprobados++;
                    System.out.println(String.format("%-16s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Reprobado"));
                }
            }

            System.out.println(
                    "=============================================================================================");
            System.out.println(" ");
            System.out.println("Nota Mayor: " + promedioMayor + " (estudiante: " + nombreEstudianteMayorPromedio + ")");
            System.out.println("Nota Menor: " + promedioMenor + " (estudiante: " + nombreEstudianteMenorPromedio + ")");
            System.out.println("Cantidad de estudiantes aprobados: " + numEstudiantesAprobados);
            System.out.println("Cantidad de estudiantes aplazados: " + numEstudiantesAplazados);
            System.out.println("Cantidad de estudiantes reprobados: " + numEstudiantesReprobados);
        } else {
            System.out.println("\n\033[1mNo hay estudiantes registrados.\033[0m");
        }
    }
}
