package poo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @class Archivo
 * @brief Clase que maneja la lectura y escritura de puntuaciones en un archivo de texto.
 * Permite guardar las puntuaciones del jugador y obtener las mejores puntuaciones.
 */
public class Archivo {

    /**
     * @brief Escribe la puntuación de un jugador en un archivo de texto.
     * Si el archivo no existe, lo crea. Si ya existe, añade la puntuación al final.
     *
     * @param nickname El nombre del jugador.
     * @param score La puntuación obtenida por el jugador.
     */
    public static void writeScore(String nickname, Integer score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePuntos.txt", true))) {
            bw.write(nickname + ": " + score);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Obtiene las mejores puntuaciones almacenadas en el archivo de puntuaciones.
     * Lee las puntuaciones, las ordena de mayor a menor y retorna una lista con las mejores puntuaciones,
     * limitadas por el parámetro `limit`.
     *
     * @param limit El número máximo de puntuaciones a obtener.
     * @return Una lista de las mejores puntuaciones en formato de texto.
     */
    public static List<String> getTopScores(int limit) {
        List<String> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ArchivoDePuntos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar las puntuaciones de mayor a menor
        scores.sort((a, b) -> Integer.compare(
                Integer.parseInt(b.split(": ")[1]),
                Integer.parseInt(a.split(": ")[1])
        ));

        return scores.size() > limit ? scores.subList(0, limit) : scores;
    }
}
