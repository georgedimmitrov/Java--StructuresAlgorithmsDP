package DataStructures;

public class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String value) {
        char[] input = value.toCharArray();
        TrieNode n = root; // "n" represents a prefix in "value"

        for (char c : input) {
            if (!n.haveRecord(c)) {
                n.addRecord(c, new TrieNode());
            }
            n = n.followChar(c);
        }
        n.setIsWord(true);
    }

    public boolean search(String value) {
        char[] input = value.toCharArray();
        TrieNode n = root;

        for (int i = 0; i < input.length; i++) {
            if (!n.haveRecord(input[i])) {
                return false;
            }
            n = n.followChar(input[i]);
        }

        return n.isWord();
    }

    public boolean delete(String value) {
        char[] input = value.toCharArray();
        TrieNode n = root;
        TrieNode[] path = new TrieNode[input.length];
        int pathLength = 0;
        for (int i = 0; i < input.length; i++) {
            if (!n.haveRecord(input[i])) {
                // value is not in this tree
                return false;
            }
            n = n.followChar(input[i]);
            path[pathLength] = n;
            pathLength++;
        }
        n.setIsWord(false);

        // delete nodes that are no longer needed
        int inputIndex = input.length - 1; // from the end to 0
        for (int i = pathLength - 2; i >= 0; i--) {

            if (n.haveNoRecord() && (!n.isWord())) {
                // node can be deleted
                n = path[i];
                n.deleteRecord(input[inputIndex]);
                inputIndex--;
            } else {
                // node cannot be deleted
                break;
            }
        }

        return true;
    }
}
