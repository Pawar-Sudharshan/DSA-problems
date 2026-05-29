class Solution {
    class Node {
        Node[] child;
        int frq;

        public Node() {
            child = new Node[26];
            frq = 0;
        }
    }

    private void insert(Node root, String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (temp.child[idx] == null) {
                temp.child[idx] = new Node();
            }
            temp = temp.child[idx];
            temp.frq++;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();

        for (String word : strs) {
            insert(root, word);
        }

        String first = strs[0];
        StringBuilder ans = new StringBuilder();
        Node temp = root;
        int n = strs.length;

        for (char ch : first.toCharArray()) {
            int idx = ch - 'a';
            if (temp.child[idx] != null && temp.child[idx].frq == n) {
                ans.append(ch);
                temp = temp.child[idx];
            } else {
                break;
            }
        }

        return ans.toString();
    }
}