package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public LocalDate localDate = LocalDate.now();
    public DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public String date = localDate.format(currentDate);
    public final String MORNINGHOUR = "10.30";
    public final String NIGHTHOUR = "22.30";
    public final String MORNINGFILE = "mañana_"+date+"_"+MORNINGHOUR+".txt";
    public final String NIGHTFILE = "noche_"+date+"_"+NIGHTHOUR+".txt"; 
    public final String MORNINGFILECOMPRESS = MORNINGFILE+".compress";
    public final String NIGHTFILECOMPRESS = NIGHTFILE+".compress";
    public final String TABLEFILEMORNING = "tabla_"+MORNINGFILE;
    public final String TABLEFILENIGHT = "tabla_"+NIGHTFILE;

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

    public String readFilesMorning() {

        StringBuilder sb = new StringBuilder();
        String line;

        try {

            BufferedReader reader = new  BufferedReader(new FileReader(MORNINGFILE));

            while ((line = reader.readLine()) != null) {
                sb.append(line);    
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String readFilesNight() {

        StringBuilder sb = new StringBuilder();
        String line;

        try {

            BufferedReader reader = new  BufferedReader(new FileReader(NIGHTFILE));

            while ((line = reader.readLine()) != null) {
                sb.append(line);    
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public FileManager(){
        writeMorningFiles();
        writeNightFile();
    }
    
}


