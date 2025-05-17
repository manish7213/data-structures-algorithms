package Tries;

public class TrieDriver {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("air");
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");

        System.out.println(trie.search("air"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("bee"));
        System.out.println(trie.search("be"));
        System.out.println(trie.search("cdol"));

    }
}
