package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 9/15/16.
 */
public class Trie {
    //initialize TrieNode this kind of data structure
    static class TrieNode{
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;
        public TrieNode(char c){//constructor
            this.c = c;
        }

        public TrieNode() {

        }
    }
    ////-------------以上是定义一个TrieNode 字典数节点--------------------------
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    //1. Insert a word into trie
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode temp = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                temp = children.get(c);
            } else {
                temp = new TrieNode(c);
                children.put(c, temp);
            }
            children = temp.children;

            if (i == word.length() - 1) {
                temp.isLeaf = true;
            }
        }

    }

    //2. return if the word is in the trie
    public boolean search(String word) {
        TrieNode temp = searchNode(word);
        return temp != null && temp.isLeaf;
    }

    private TrieNode searchNode(String word) {//search last node of a word
        Map<Character, TrieNode> children = root.children;
        TrieNode temp = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                return null;
            } else {
                temp = children.get(c);
                children = temp.children;
            }
        }
        return temp;
    }

    //3.Return is there is any word in the trie
    //that starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    //------------------searchPattern-----------------------
    public boolean searchPattern(String word, int index, TrieNode temp) {
        if (index == word.length()) {
            return temp != null && temp.isLeaf;
        }
        char c = word.charAt(index);
        if (c == '.') {
            boolean flag = false;
            for (Map.Entry<Character, TrieNode> entry : temp.children.entrySet()) {
                TrieNode child = entry.getValue();
                flag = flag || searchPattern(word, index + 1, child);
            }
            return flag;
        } else if (temp.children.containsKey(c)) {
            return searchPattern(word, index + 1, temp.children.get(c));
        } else {
            return false;
        }
    }

    public boolean search2(String word) {
        return searchPattern(word, 0, root);
    }
    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("bad");
//        trie.insert("dad");
//        trie.insert("mad");
//        System.out.println(trie.search2("pad"));
//        System.out.println(trie.search2("bad"));
        System.out.println(trie.search2(".ad"));
        System.out.println(trie.search2("b.."));

    }


}
