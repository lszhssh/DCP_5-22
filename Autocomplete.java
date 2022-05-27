import java.util.ArrayList;

public class Autocomplete {
    // Problem from 5/24/22:

    // Implement an autocomplete system. That is, given a query string s and 
    // a set of all possible query strings, return all strings in the set that 
    // have s as a prefix.
    // For example, given the query string de and the set of strings 
    // [dog, deer, deal], return [deer, deal].
    // Hint: Try preprocessing the dictionary into a more efficient 
    // data structure to speed up queries.

    // Solution time: 11 minutes (naive solution)

    // Plan:
    // - Isn't this solved easily by using String.indexOf()?
        // Yes, but we can optimize it with something called a trie[sic].
        // [X] How to implement a trie?

    public ArrayList<String> autocomplete(String query, String[] possibleStrings) {
        ArrayList<String> suggestions = new ArrayList<>();
        for (int i = 0; i < possibleStrings.length; i++) {
            if (possibleStrings[i].indexOf(query) == 0) {
                suggestions.add(possibleStrings[i]);
            }
        }
        return suggestions;
    }

    public void printArrayList(ArrayList<String> strs) {
        for (String str : strs) {
            System.out.print(str + " ");
        }
    }

    static class TrieNode {
        char data;
        ArrayList<TrieNode> children;
        boolean isWord;

        public TrieNode(char data) {
            this.data = data;
            this.children = new ArrayList<>();
            this.isWord = false;
        }
    }

    TrieNode root;

    public Autocomplete(TrieNode root) {
        this.root = root;
    }

    public void add(String[] strs) {
        for (String str : strs) {
            TrieNode currNode = this.root;
            for (int i = 0; i < str.length() - 1; i++) {
                char currChar = str.charAt(i);
                if (!currNode.children.contains(currChar)) {
                    TrieNode newNode = new TrieNode(currChar);
                    currNode.children.add(newNode);
                    currNode = newNode;
                } else {
                    for (TrieNode n : currNode.children) {
                        if (n.data == currChar) {
                            currNode = n;
                        }
                    }
                }
            }
            currNode.isWord = true;
        }
    }

    public ArrayList<String> trieAutocomplete(String prefix, String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : strs) {
            TrieNode currNode = this.root;
            boolean startsWith = true;
            for (int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if (!currNode.children.contains(currChar)) {
                    startsWith = false;
                    break;
                }
            }
            if (startsWith) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrieNode n1 = new TrieNode('n');
        Autocomplete obj = new Autocomplete(n1);
        String[] strs = new String[] {"dog", "deer", "deal"};
        // obj.printArrayList(obj.autocomplete("de", strs));
        obj.add(strs);
        obj.printArrayList(obj.trieAutocomplete("de", strs));
    }
}