//Time Complexity: O(n ^ 2) = O(81) = constant O(1)
//Space Complexity: O(n ^ 2) = O(81) = constant O(1)
//Approach: The idea is to check the existence of an element in that row, that column and the particular 3 X 3 box it falls in
//we need a hashing solution because for every element in that row we need to check the elements in that row, column and the box
//that means repetitive checks, to optimize the repetitive traversals, we need a hashing mechanism to check this in O(1)
public class ValidSudoku {

    public boolean isValidSudoku(final char[][] board) {
        final boolean[][] rows = new boolean[9][9];
        final boolean[][] cols = new boolean[9][9];
        final boolean[][] box = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                final char element = board[i][j];
                final int num = element - '1';
                final int boxIndex = (i / 3) * 3 + (j / 3);
                if (element == '.') continue;

                if (rows[i][num]) return false;
                if (cols[num][j]) return false;
                if (box[boxIndex][num]) return false;

                rows[i][num] = true;
                cols[num][j] = true;
                box[boxIndex][num] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(validSudoku.isValidSudoku(board)); //return true
        
        board = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(validSudoku.isValidSudoku(board)); //return false
    }
}
