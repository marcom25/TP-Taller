
import FileManager.FileManager;
import Huffman.Huffman;

public class App {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager();   
        Huffman huffmanMorning = new Huffman(fm.readFilesMorning());
        Huffman huffmanNight = new Huffman(fm.readFilesNight());

        
        
        huffmanMorning.encodeMorning();
        huffmanNight.encodeNight();
        huffmanMorning.printCodesMorning();
        huffmanNight.printCodesNight();



    }
}
