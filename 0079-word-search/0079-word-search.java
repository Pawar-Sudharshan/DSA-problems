class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start DFS if first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word,
                           int i, int j, int index) {
        // all characters matched
        if (index == word.length()) {
            return true;
        }

        // bounds check and character check
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] != word.charAt(index)) return false;

        // mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // explore 4 directions with next index
        boolean found =
            search(board, word, i + 1, j, index + 1) ||
            search(board, word, i - 1, j, index + 1) ||
            search(board, word, i, j + 1, index + 1) ||
            search(board, word, i, j - 1, index + 1);

        // restore cell
        board[i][j] = temp;
        return found;
    }
}
