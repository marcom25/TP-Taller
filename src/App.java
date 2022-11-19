
import FileManager.FileManager;
import Huffman.Huffman;

public class App {
    public static void main(String[] args) throws Exception {
        Huffman huffman = new Huffman("233424");
        // FileManager fm = new FileManager();    

        String encodedText = huffman.encode();
        System.out.println(encodedText);

        huffman.printCodesMorning();

        String originalText = huffman.decode(encodedText);
        System.out.println(originalText);
    }
}
