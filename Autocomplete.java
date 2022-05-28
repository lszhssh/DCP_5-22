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

    public void printNodes(ArrayList<TrieNode> nodes) {
        for (TrieNode n : nodes) {
            System.out.print(n.data + " ");
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
            for (int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if (!contains(currChar, currNode.children)) {
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

    public static boolean contains(char c, ArrayList<TrieNode> nodes) {
        for (TrieNode n : nodes) {
            if (n.data == c) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> startsWith(String prefix) {
        ArrayList<String> result = new ArrayList<>();
        TrieNode currNode = this.root;
        // boolean prefixPossible = true;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (contains(currChar, currNode.children)) {
                for (TrieNode n : currNode.children) {
                    if (n.data == currChar) {
                        currNode = n;
                    }
                }
            } else {
                return result;
            }
        }
        // prefix is possible, we're currently at the last letter of the prefix
        // recursively print out all possibilities
        // maybe use a helper function?
        // print all branches from a given node
        return result;
    }

    public static void main(String[] args) {
        TrieNode n1 = new TrieNode('n');
        Autocomplete obj = new Autocomplete(n1);
        String[] strs = new String[] {"dog", "deer", "deal"};
        obj.add(strs);
        obj.printNodes(n1.children.get(0).children.get(1).children.get(1).children);
    }
}