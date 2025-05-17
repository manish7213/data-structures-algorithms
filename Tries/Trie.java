package Tries;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> automcompleteOrStartsWith(String prefix) {
        Node tempNode = root;
        List<String> autocompleteResults = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int asciiIndex = ch - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                return autocompleteResults; // empty list
            }

            tempNode = tempNode.getChild(asciiIndex);
        }
        collectAutoCompletedWords(tempNode, prefix, autocompleteResults);
        return autocompleteResults;
    }

    private void collectAutoCompletedWords(Node node, String prefix, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            list.add(prefix);
        }
        for (Node childNode : node.getChildren()) {
            if (childNode != null) {
                String childCharacter = childNode.getCharacter();
                // Recursion, We can use StringBuilder instead of + operator.
                collectAutoCompletedWords(childNode, prefix + childCharacter, list);
            }
        }
    }


}
