package proyecto_1;

import java.util.Scanner;

public class ClasEstudiantes {
    static Scanner sc = new Scanner(System.in);
    static String[] cedulaEstudiantes = new String[10];
    static String[] nombreEstudiantes = new String[10];
    static String[] apellidoEstudiantes = new String[10];
    static double[] notaEstudiantes = new double[10];
    static int numEstudiantes = 0;
    static boolean cedulaValida = false;
    static boolean cedulaRepetida = false;
    static boolean nombreValido = false;
    static boolean apellidoValido = false;
    static boolean notaValida = false;
    static boolean nombreRepetido = false;
    static boolean apellidoRepetido = false;
    static String cedula = "0";
    static String nombre = "0";
    static String apellido = "0";
    static double nota = 0.0;

    static void inicializarVec() { // for para inicializar los vectores de los estudiantes.
        for (int i = 0; i < 10; i++) {
            cedulaEstudiantes[i] = "";
            nombreEstudiantes[i] = "";
            notaEstudiantes[i] = 0.0;
        }
        numEstudiantes = 0;
        System.out.println("\n\033[1m=== Vectores inicializados correctamente ===\033[0m\n");
    }

    static void IncluirEstud() {

        if (numEstudiantes >= 10) { // if valida que no se haya llegado al máximo de estudiantes.
            System.out.println("\n\033[1m*** No se pueden incluir mas estudiantes ***\033[0m\n");
            return;
        }

        do {
            System.out.print("\nIngrese la cedula del estudiante (sin espacios ni guiones ej: 1234567890): ");
            cedula = sc.nextLine();
            cedulaRepetida = false;
            cedulaValida = false; // reiniciar la variable a false.

            for (int i = 0; i < numEstudiantes; i++) {
                if (cedulaEstudiantes[i].equals(cedula)) {// ".equals" se usa para comprar cedulaEstudiantes con cedula,
                                                          // para revisar si hay repetidos.
                    cedulaRepetida = true;
                    System.out.println("\n\033[1mXxX La cedula ya existe XxX\033[0m\n");
                    break;
                }
            }
            if (!cedula.matches("[0-9]+")) { // "!cedula.matches" verifica si la variable cedula contiene solo números.
                System.out.println("\n\033[1mXxX La cedula no debe contener espacios ni letras XxX\033[0m\n");
            } else if (!cedulaRepetida) {
                cedulaValida = true;
            }
        } while (!cedulaValida);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        do {
            System.out.print("\nIngrese el nombre del estudiante (solo debe ser uno): ");
            nombre = sc.nextLine();
            nombreValido = false;
            nombreRepetido = false;
            if (!nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]+")) {// "nombre.matches" verifica si la variable nombre contiene
                                                             // solo letras.
                System.out.println("\n\033[1mXxX El nombre no debe contener espacios ni números XxX\033[0m\n");
            } else {
                for (int i = 0; i < numEstudiantes; i++) {
                    if (nombreEstudiantes[i].equals(nombre)) {
                        nombreRepetido = true;
                        System.out.println("Ese nombre ya esta en uso, por favor ingrese otro.");
                        nombreValido = false;
                        break;
                    }
                }
                if (!nombreRepetido) {
                    nombreEstudiantes[numEstudiantes] = nombre;
                    nombreValido = true;
                }
            }
        } while (!nombreValido);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        do {
            System.out.print("\nIngrese el apellido del estudiante (solo debe ser uno): ");
            apellido = sc.nextLine();

            if (!apellido.matches("[a-zA-Z]+")) { // if valida que solo sean letras.
                System.out.println("\n\033[1mXxX El apellido no debe contener espacios ni numerosXxX\033[0m\n");
                apellidoValido = false; // se reinicia la variable a falso.
            } else {
                apellidoRepetido = false;
                for (int i = 0; i < numEstudiantes; i++) {
                    if (apellidoEstudiantes[i].equals(apellido)) { // if,".equals" verifican si el nombre se repite.
                        apellidoRepetido = true;
                        System.out.println("Ese apellido ya esta en uso, por favor ingrese otro.");
                        apellidoValido = false;
                    }
                }

                if (!apellidoRepetido) {// if verifica que el apellido ingresado no este repetido.
                    apellidoEstudiantes[numEstudiantes] = apellido;
                    apellidoValido = true;
                }
            }
        } while (!apellidoValido);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        notaValida = false; // notaValida se inicializa como falsa para que el cilo do-while se ejecute al
                            // menos una vez.
        do {
            System.out.print("\nIngrese la nota del estudiante: ");
            String entrada = sc.nextLine().trim();
            if (entrada.matches("^\\d{1,2}(\\.\\d{1,2})?$")) { // if verifica que solo se digiten numeros.
                nota = Double.parseDouble(entrada);
                if (nota < 0 || nota > 100) {
                    System.out.println("\n\033[1mXxX Error: la nota debe estar entre 0 y 100. XxX\033[0m\n");
                } else {
                    notaValida = true;
                }
            } else {
                System.out.println("\n\033[1mXxX Error: debe ingresar un numero valido para la nota XxX\033[0m\n");
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
        cedula = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < cedulaEstudiantes.length; i++) { // for valida las cedulas ingresadas.
            if (cedula.equals(cedulaEstudiantes[i])) { // ".equals" verifica si la cedula esta dentro del arreglo.

                System.out.println(" ");
                System.out.println(String.format("%50s", "CONSULTA DE ESTUDIANTE")); // este formato "%50s" sirve para
                                                                                     // rellenar espacios,
                System.out.println( // en este caso se especifica la longitud total de la cadena de texto 50
                                    // caracteres.
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

        System.out.println("\n-------Modificar Estudiante-------\n");
        System.out.print("\nIngrese la cedula del estudiante a modificar: ");
        cedula = sc.nextLine();

        for (int i = 0; i < numEstudiantes; i++) {

            if (!cedula.matches("[0-9]+")) { // "cedula.matches" valida que solo sean numeros.
                System.out.println("\n\033[1mXxX La cedula no debe contener espacios ni letras XxX\033[0m\n");
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            do {
                System.out.print("\nIngrese el nuevo nombre del estudiante : ");
                nombre = sc.nextLine();
                if (!nombre.matches("[a-zA-Z]+")) { // "nombre.matches" valida que solo sean letras.
                    System.out.println("\n\033[1mXxX El nombre no debe contener espacios ni numeros XxX\033[0m\n");
                    nombreValido = false; // establece "nombreValido" como falso si la entrada no cumple con los
                                          // criterios.
                } else {
                    nombreRepetido = false;
                    for (int j = 0; j < numEstudiantes; j++) {
                        if (j != i && nombreEstudiantes[j].equals(nombre)) { // si el nombre ya esta en uso en otro
                                                                             // estudiante, se establece nombreRepetido
                                                                             // como true.
                            nombreRepetido = true;
                            System.out.println("Ese nombre ya esta en uso, por favor ingrese otro.");
                            break;
                        }
                    }
                    if (nombreRepetido) { // si se encontro que el nombre esta en uso, se establece "nombreValido" como
                                          // false.
                        nombreValido = false;
                    } else { // si no está en uso, se establece nombreValido como true.
                        nombreEstudiantes[i] = nombre;
                        nombreValido = true;
                    }
                }
            } while (!nombreValido); // se repite mientras el nombre no sea valido.

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            do {
                System.out.print("\nIngrese el nuevo apellido del estudiante: ");
                apellido = sc.nextLine();
                apellidoValido = true;

                if (!apellido.matches("[a-zA-Z]+")) { // if valida que solo sean letras.
                    System.out.println("\n\033[1mXxX El apellido no debe contener espacios ni numerosXxX\033[0m\n");
                    apellidoValido = false; // sirve para reiniciar la variable a falso.
                } else {
                    apellidoRepetido = false;

                    for (int j = 0; j < numEstudiantes; j++) {
                        if (j != i && apellidoEstudiantes[j].equals(apellido)) { // Verifica si el apellido se repite.
                            apellidoRepetido = true;
                            System.out.println("Ese apellido ya esta en uso, por favor ingrese otro.");
                            apellidoValido = false; // reinicia la variable a false para que el programa no acepte
                                                    // apellidos repetidos.
                            break;
                        }
                    }

                    if (!apellidoRepetido) { // verifica si el apellido no esta repetido, si el apellido no esta
                                             // repetido se guarda en la posicion "i".
                        apellidoEstudiantes[i] = apellido;
                    }
                }
            } while (!apellidoValido);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            while (true) {
                System.out.print("\nIngrese la  nueva nota del estudiante: ");

                String entrada = sc.nextLine().trim(); // elimina espacios en blanco antes y después de la entrada.

                if (entrada.matches("^\\d{1,2}(\\.\\d{1,2})?$")) { // if valida que la entrada contenga solo dígitos y
                                                                   // un punto decimal, con hasta dos dígitos después
                                                                   // del punto.
                    nota = Double.parseDouble(entrada);

                    if (nota < 0 || nota > 100) { // if valida que la entrada contenga notas minimos de 0 y maximas de
                                                  // 100.
                        System.out.println("\n\033[1mXxX Error: la nota debe estar entre 0 y 100. XxX\033[0m\n");
                    } else {
                        notaValida = true;
                        break; // salir del bucle si la nota es válida
                    }
                } else {
                    System.out.println("\n\033[1mXxX Error: debe ingresar un numero valido para la nota XxX\033[0m\n");
                }
            }

            System.out.println("\nLa nueva nota ingresada es: " + nota);

            // se llena los vectores con los nuevos cambios.
            cedulaEstudiantes[i] = cedula;
            nombreEstudiantes[i] = nombre;
            apellidoEstudiantes[i] = apellido;
            notaEstudiantes[i] = nota;

            System.out.println("\n\033[1m=== Estudiante modificado correctamente ===\033[0m\n");
            return;
        }

        System.out.println("\n\033[1mXxX No se encontro un estudiante con la cedula ingresada XxX\033[0m\n");
    }

    static void EliminarEstud() {

        System.out.print("\nIngrese la cedula del estudiante a eliminar: ");
        cedula = sc.next();
        sc.nextLine(); // limpia el buffer para la siguiente entrada.

        for (int i = 0; i < numEstudiantes; i++) {
            if (cedulaEstudiantes[i].equals(cedula)) { // if para verficar si coincide la cedula digitada con la
                                                       // guardada.
                for (int j = i; j < numEstudiantes - 1; j++) { // for se mueve una posicion hacia atras para eliminar
                                                               // los datos del estudiante.
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

    static void SubmenuReportes() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while (opcion != 3) {
            System.out.println("\n-------Submenu Reportes-------\n");
            System.out.println("1. Reporte Estudiantes por Condicion.");
            System.out.println("2. Reporte Todos los datos.");
            System.out.println("3. Regresar Menu Principal.");
            System.out.print("\n Seleccione una opcion:");
            String input = sc.nextLine();

            while (!input.matches("[1-3]") || !Character.isDigit(input.charAt(0))) { // valida la entrada para que sea
                                                                                     // un número del 1 al 3.
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
            }
        }
        sc.close();
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
            String input = scanner.nextLine();
            while (!input.matches("[1-4]") || !Character.isDigit(input.charAt(0))) {// valida que la entrada para que
                                                                                    // sea un numero del 1 al 4.
                System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
                System.out.print("Seleccione una opcion valida del menu (numero): ");
                input = scanner.nextLine();
            }
            opcion = Integer.parseInt(input);

            switch (opcion) {

                case 1:
                    Est_aprobados();

                    break;

                case 2:
                    Est_reprobados();

                    break;

                case 3:
                    Est_aplazados();

                    break;

                case 4:

                    return;
            }
        }
        scanner.close(); // se implemento porque los recursos del scanner quedaban abiertos produciendo
                         // errores.
    }

    static void Est_aprobados() {
        int numEstudiantesRegistrados = numEstudiantes;
        boolean NohayEstu_Apro = false;

        if (numEstudiantesRegistrados > 0) { // if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Aprobados: ");
            for (int i = 0; i < numEstudiantes; i++) {
                if (notaEstudiantes[i] >= 70) { // if verifica si hay estudiantes aprobados.
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

        if (numEstudiantesRegistrados > 0) { // if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Reprobados:");
            boolean hayEstudiantesReprobados = false;
            for (int i = 0; i < numEstudiantes; i++) {
                if (notaEstudiantes[i] <= 59) {// if verifica si hay estudiantes reprobados.
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

        if (numEstudiantesRegistrados > 0) {// if verifica que hayan estudiantes dentro del sistema.
            System.out.println("Estudiantes Aplazados:");
            boolean hayEstudiantesAplazados = false;
            for (int i = 0; i < numEstudiantes; i++) { // if verifica si hay estudiantes aplazados.
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
                if (promedio > promedioMayor) { // if para bucar el estudiante con mayor nota(fue un agregado de nuestra
                                                // parte).
                    promedioMayor = promedio;
                    nombreEstudianteMayorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio < promedioMenor) { // if para bucar el estudiante con menor nota(fue un agregado de nuestra
                                                // parte).
                    promedioMenor = promedio;
                    nombreEstudianteMenorPromedio = nombreEstudiantes[i] + " " + apellidoEstudiantes[i];
                }
                if (promedio >= 70) { // "if", "else if", "else if", para determinar cuales estudiantes estan
                                      // aprobados, aplazados o reprobados.
                    numEstudiantesAprobados++;
                    System.out.println(String.format("%-16s %-24s %-24s %-16s %-16s", cedulaEstudiantes[i],
                            nombreEstudiantes[i], apellidoEstudiantes[i], notaEstudiantes[i], "Aprobado"));
                } else if (promedio >= 60) { // si el promedio es mayor o igual a 60 está aplazado.
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
