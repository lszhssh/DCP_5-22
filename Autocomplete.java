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
        // [] How to implement a trie?

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

    public static void main(String[] args) {
        Autocomplete obj = new Autocomplete();
        String[] str = new String[] {"dog", "deer", "deal"};
        obj.printArrayList(obj.autocomplete("de", str));
    }
}