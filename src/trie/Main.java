package trie;

import java.util.Arrays;
import java.util.Objects;

class  WordDictionary {
    Main.Node root;

    public WordDictionary() {
        root = new Main.Node();
    }

    public void addWord(String word) {
        Main.Node current = root;
        for (char ch : word.toCharArray()) {
            int id = ch - 'a';
            if (Objects.isNull(current.childs[id])) {
                current.childs[id] = new Main.Node();
            }
            current = current.childs[id];
        }
        current.isComplete = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    boolean dfs(Main.Node root, String word, int id) {
        if (root == null ) {
            return false;
        }
        if (root.isComplete && id == word.length()) {
            return true;
        }
        if (id == word.length()) {
            return false;
        }
        boolean res = false;
        if (word.charAt(id) == '.') {
            for (int i = 0; i < 26; i++) {
                res = res || dfs(root.childs[i], word, id + 1);
            }
        } else {
            res = res || dfs(root.childs[word.charAt(id) - 'a'], word, id + 1);
        }
        return res;
    }
}

public class Main {
    static class Node{
        Node[] childs;
        boolean isComplete;
        Node(){
            childs = new Node[26];
            isComplete = false;
        }

        @Override
        public String toString() {
            return Arrays.toString(childs);
        }
    }


    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.root.toString());
        System.out.println(wd.search("a"));;
        System.out.println(wd.search(".."));;
    }
}
