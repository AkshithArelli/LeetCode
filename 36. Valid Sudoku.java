Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.




class Solution {
    public boolean isValidSudoku(char[][] board) {
        //T:O(1) - We are processing a constant number of cells in a 9x9 grid.
        //s:O(1) - The size of the HashSet used will hold at most 81 elements given all cells are filled without repetition.
        Set<String> set = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    //following are just for understandable keys
                    //row:0-5 -> row 0 value 5
                    String rowKey = "row:" + i + "-" + num;
                    //col:0-5 -> col 0 value 5
                    String colKey = "col:" + j + "-" + num;
                    //box:(0,0):5 -> box 0,0 value 5
                    String boxKey = "box: (" + (i/3) + "," + (j/3) + ") - " + num;
                    
                    //if any of the key is already present
                    //i.e., could be in same row or same col or same box,
                    //add returns false which make condition true and return false
                    if(!set.add(rowKey) || !set.add(colKey) || !set.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
