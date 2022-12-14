package Huffman;

public class Node implements Comparable<Node> {
    private final int frequency;
    private Node leftNode;
    private Node rightNode;

    public Node(int frequency){
        this.frequency = frequency;
    }

    public Node(Node leftNode, Node rightNode){
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Node node){
        return Integer.compare(frequency, node.getFrequency());
    }
    
}
