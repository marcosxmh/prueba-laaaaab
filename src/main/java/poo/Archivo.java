package poo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    public static void writeScore(String nickname, Integer score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePuntos.txt", true))) {
            bw.write(nickname + ": " + score);
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
