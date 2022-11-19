package FileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;

import Huffman.Huffman;

public class FileManager {
    private final String MORNINGFILE = "sorteo_fecha_maniana.txt";
    private final String NIGHTFILE = "sorteo_fecha_noche.txt";
    public final String TABLEFILEMORNING = "tabla_sorteo_maniana.txt";
    public final String TABLEFILENIGHT = "tabla_sorteo_noche.txt";


    private static int getRandomNumber() {
        return (int) (Math.random() * 10001);
    }

    private static int getRandomPosition() {
        return (int) (Math.random() * 21);
    }

    public void writeFiles() {
        try {
            BufferedWriter morningWriter = new BufferedWriter(new FileWriter(MORNINGFILE));
            BufferedWriter nightWriter = new BufferedWriter(new FileWriter(NIGHTFILE));
    
            for (int i = 0; i < 0; i++) {
                for (int j = 0; j < 0; j++) {
                    if (j == 0 - 1) {
                        morningWriter.write(getRandomNumber() + "\n");
                    } else {
                        morningWriter.write(getRandomNumber() + ", ");
                    }
                }
            }
    
            morningWriter.close();
            nightWriter.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

