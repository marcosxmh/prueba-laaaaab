package poo;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Archivo {

    public static void writeScores(Integer score, Integer i) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePuntos.txt", true))) {
            bw.write("Intento " + i + ": " + score);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getTopScores(int limit) {
        List<String> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ArchivoDePuntos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Validar si la línea tiene el formato correcto
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        Integer.parseInt(parts[1]); // Validar que la puntuación sea un número
                        scores.add(line);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Ignorar líneas con formato incorrecto
                    System.err.println("Línea ignorada por formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar las puntuaciones de mayor a menor
        scores.sort((a, b) -> {
            int scoreA = Integer.parseInt(a.split(": ")[1]);
            int scoreB = Integer.parseInt(b.split(": ")[1]);
            return Integer.compare(scoreB, scoreA);
        });

        return scores.size() > limit ? scores.subList(0, limit) : scores;
    }
}
