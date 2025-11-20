Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //T:O(m*n), S:O(1)
        //for a better understanding look 11:56min time of Nikhil lohia YT video
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            //traverse left
            //prevents revisiting or accessing invalid columns
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            //traverse up
            //prevents revisiting or accessing invalid columns
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return result;
    }
}
