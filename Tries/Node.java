package Tries;

public class Node {

    private String character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;

    private static final Integer ALPHABET_SIZE = 26;

    public Node(String character) {
        this.character = character;
        children = new Node[ALPHABET_SIZE];
    }


    public boolean isLeaf() {
        return leaf;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character='" + character + '\'' +
                '}';
    }

    public Node getChild(int asciiIndex) {
        return children[asciiIndex];
    }

    public void setChild(int index, Node newNode) {
        children[index] = newNode;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
