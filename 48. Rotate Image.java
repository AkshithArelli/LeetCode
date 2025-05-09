ou are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000



class Solution {
    public void rotate(int[][] matrix) {

        //optimised space
        //T:O(n^2) , S:O(n) no extra space is used
        int n = matrix.length;
        //for better understanding draw matrix on paper
        //transpose the matrix
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) { //j starts from i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse elements in each row
        for (int i=0; i<n; i++) {
            int start = 0;
            int end = n-1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        //brute force
        //T:O(n^2) , S: O(n^2)  extra space is required
        int n = matrix.length;

        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int row = j;
                int column = n-1-i;
                rotatedMatrix[row][column] = matrix[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }
}
