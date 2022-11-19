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
            int[] rp = new int[21];
            int[] rp1 = new int[21];

            for(int i = 0;i<21;i++){
                rp[i] = -1;
                rp1[i] = -1;
            }

            nightWriter.write("Posicion Número\n");
            morningWriter.write("Posicion Número\n");
            
            for (int i = 0; i < 40; i++) {
                if (i % 2 == 0) {
                    int rn = getRandomPosition();
                    while(rp[rn] != -1){
                        rn = getRandomPosition();
                    }
                    rp[rn] = rn;
                    nightWriter.write((rp[rn] + 1) + " ");
                    
                    int rn1 = getRandomPosition();
                    while(rp1[rn1] != -1){
                        rn1 = getRandomPosition();
                    }
                    rp1[rn1] = rn1;
                    morningWriter.write((rp1[rn1] + 1) + " ");
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

