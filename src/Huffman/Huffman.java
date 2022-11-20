package Huffman;

import java.util.*;

import static java.util.Objects.requireNonNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import FileManager.FileManager;

public class Huffman {

    private Node root;
    private final String text;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> huffmanCodes;
    FileManager fm = new FileManager();

    public Huffman(String text) {
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();
    }

    private void fillCharFrequenciesMap() {
        charFrequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            charFrequencies.put(character, charFrequencies.getOrDefault(character, 0) + 1);
        }
    }

    public String encodeMorning() {
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));
        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), requireNonNull(queue.poll())));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedTextMorning();
    }

    public String encodeNight() {
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));
        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), requireNonNull(queue.poll())));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedTextNight();
    }

    private void generateHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf leaf) {
            huffmanCodes.put(leaf.getCharacter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }


    private String getEncodedTextMorning() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fm.MORNINGFILECOMPRESS));
            for (char character : text.toCharArray()) {
                // sb.append(huffmanCodes.get(character));
                writer.write(huffmanCodes.get(character));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String getEncodedTextNight() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fm.NIGHTFILECOMPRESS));
            for (char character : text.toCharArray()) {
                // sb.append(huffmanCodes.get(character));
                writer.write(huffmanCodes.get(character));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
   

    public void printCodesMorning() {
        try {
            BufferedWriter tableMorningWriter = new BufferedWriter(new FileWriter(fm.TABLEFILEMORNING));
            
            
            huffmanCodes.forEach((character, code) -> {
                
                try {
                    tableMorningWriter.write(character + ", " + code + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            tableMorningWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    public void printCodesNight() {
        try {
            BufferedWriter tableNighWriter = new BufferedWriter(new FileWriter(fm.TABLEFILENIGHT));
            
            huffmanCodes.forEach((character, code) -> {
                
                try {
                    tableNighWriter.write(character + ", " + code + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            tableNighWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
