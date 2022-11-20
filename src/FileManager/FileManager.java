package FileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Huffman.Huffman;

public class FileManager {
    private final String MORNINGFILE = "sorteo_fecha_maniana.txt";
    private final String NIGHTFILE = "sorteo_fecha_noche.txt";
    public final String TABLEFILEMORNING = "tabla_sorteo_maniana.txt";
    public final String TABLEFILENIGHT = "tabla_sorteo_noche.txt";

    public int getRandomNumber() {
        return (int) (Math.random() * 10001);
    }

    public int getRandomPosition() {
        return (int) (Math.random() * 21);
    }

    private void writeNightFile() {
        try {
            BufferedWriter nightWriter = new BufferedWriter(new FileWriter(NIGHTFILE));
            List<Integer> rPos = new ArrayList<Integer>();

            nightWriter.write("Posicion Número\n");

            for (int i = 0; i < 20; i++) {

                int rNum = getRandomPosition();
                while (rPos.contains(rNum) || rNum == 0) {
                    rNum = getRandomPosition();
                }

                rPos.add(rNum);
                nightWriter.write(rNum + " ");

                nightWriter.write(getRandomNumber() + "\n");

            }

            nightWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    private void writeMorningFiles() {
        try {
            BufferedWriter morningWriter = new BufferedWriter(new FileWriter(MORNINGFILE));
            List<Integer> rPos = new ArrayList<Integer>();

            morningWriter.write("Posicion Número\n");

            for (int i = 0; i < 20; i++) {

                int rNum = getRandomPosition();
                while (rPos.contains(rNum) || rNum == 0) {
                    rNum = getRandomPosition();
                }

                rPos.add(rNum);
                morningWriter.write(rNum + " ");

                morningWriter.write(getRandomNumber() + "\n");

            }

            morningWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFiles(){
        writeMorningFiles();
        writeNightFile();
    }
    
}


