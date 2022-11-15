import Huffman.Huffman;

public class App {
    public static void main(String[] args) throws Exception {
        Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");

        String encodedText = huffman.encode();
        System.out.println(encodedText);

        huffman.printCodes();

        String originalText = huffman.decode(encodedText);
        System.out.println(originalText);
    }
}
