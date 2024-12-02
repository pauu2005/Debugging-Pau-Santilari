public class MatrixDebugging {

    public static void main(String[] args) {
        // Paso 1: Crear una matriz 3x3
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Paso 2: Intentar girar la matriz 90 grados
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        
        // Corregido: El índice debe ser transpuesto correctamente
        // Cambio: En lugar de "transposedMatrix[i][j] = matrix[j][i];", se debe hacer:
        // transposedMatrix[j][matrix.length - 1 - i] = matrix[i][j];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Esto realiza correctamente la rotación 90 grados de la matriz
                transposedMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        // Mostrar la matriz transpuesta (girada 90 grados)
        System.out.println("\nMatriz transpuesta (girada 90 grados):");
        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[i].length; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Paso 3: Intentar acceder a un índice fuera de los límites
        try {
            // Cambio: En lugar de "matrix[3][0]" (que genera error porque el índice 3 está fuera del rango de una matriz de 3x3),
            // se usa "matrix[2][0]" que es un índice válido dentro de la matriz.
            System.out.println("\nAccediendo al elemento en [2][0]: " + matrix[2][0]); // Cambiado para no causar error
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: " + e.toString());
        }

        // Paso 4: Intentar realizar un cálculo incorrecto con la matriz
        try {
            int sum = 0;
            // Cambio: Se corrigieron los límites del bucle para que no salgan del rango de la matriz.
            // El bucle anterior usaba "i <= matrix.length", lo que provocaba un error de índice fuera de rango.
            // Ahora el bucle termina en "i < matrix.length", que es correcto.
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];
                }
            }
            System.out.println("\nLa suma de los elementos es: " + sum);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError al intentar sumar: " + e.toString());
        }
    }
}
