import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\lmuno15\\Documents\\leidy\\Fundamentos de programcion\\Ejercicio de archivos\\test.txt";
        List<Double> numeros = new ArrayList<>();

        // Leer el archivo y verificar si la ruta es correcta
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    numeros.add(Double.parseDouble(linea.trim()));
                } catch (NumberFormatException e) {
                    System.out.println(" La línea \"" + linea + "\" no es un número ");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Calcular promedio, nùmero mayor y menor
        if (numeros.isEmpty()) {
            System.out.println("No se encontraron números en el archivo.");
            return;
        }

        double suma = 0;
        double mayor = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;

        for (double numero : numeros) {
            suma += numero;
            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }

        double promedio = suma / numeros.size();

        System.out.println("Promedio: " + promedio);
        System.out.println("Número mayor: " + mayor);
        System.out.println("Número menor: " + menor);
    }
}