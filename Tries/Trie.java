package Tries;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node("");
    }

    public void insert(String key) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int asciiIndex = ch - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                // Node not present
                Node newNode = new Node(String.valueOf(ch));
                tempNode.setChild(asciiIndex, newNode);
                tempNode = newNode;
            } else {
                // Node present
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.setLeaf(true);
    }

    public boolean search(String key) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int asciiIndex = ch - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        if (!tempNode.isLeaf()) {
            return false;
        }
        return true;
    }


}
