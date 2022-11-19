package FileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;

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

    public void writeFiles() {
        try {
            BufferedWriter morningWriter = new BufferedWriter(new FileWriter(MORNINGFILE));
            BufferedWriter nightWriter = new BufferedWriter(new FileWriter(NIGHTFILE));
            int[] rPosNight = new int[21];
            int[] rPosMor = new int[21];

            for(int i = 0;i<21;i++){
                rPosNight[i] = -1;
                rPosMor[i] = -1;
            }

            nightWriter.write("Posicion Número\n");
            morningWriter.write("Posicion Número\n");
            
            for (int i = 0; i < 40; i++) {
                if (i % 2 == 0) {
                    int rNumNight = getRandomPosition();
                    while(rPosNight[rNumNight] != -1){
                        rNumNight = getRandomPosition();
                    }
                    rPosNight[rNumNight] = rNumNight;
                    nightWriter.write((rPosNight[rNumNight] + 1) + " ");
                    
                    int rNumMor = getRandomPosition();
                    while(rPosMor[rNumMor] != -1){
                        rNumMor = getRandomPosition();
                    }
                    rPosMor[rNumMor] = rNumMor;
                    morningWriter.write((rPosMor[rNumMor] + 1) + " ");
                } else {
                    morningWriter.write(getRandomNumber() + "\n");
                    nightWriter.write(getRandomNumber() + "\n");
                }
            }

    
            morningWriter.close();
            nightWriter.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

