package FileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileManager {
    private final String MORNINGFILE = "sorteo_fecha_maniana.txt.compress";
    private final String NIGHTFILE = "sorteo_fecha_noche.txt.compress";
    private final String TABLEFILEMORNING = "tabla_sorteo_maniana.txt";
    private final String TABLEFILENIGHT = "tabla_sorteo_noche.txt";

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

        try {
            BufferedWriter morningTable = new BufferedWriter(new FileWriter(TABLEFILEMORNING));
            BufferedWriter nightTable = new BufferedWriter(new FileWriter(TABLEFILENIGHT));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}

