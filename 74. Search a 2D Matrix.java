You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104


Solution:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //T:O(logm+logn), S:O(1)
        int rowIndex = searchPotentialRow(matrix, target);
        if(rowIndex != -1) return binarySearchOverRow(rowIndex, matrix, target);
        return false;
    }
    //first do the binary search to find the potential row
    private int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]) {
                return mid;
            }
            else if(matrix[mid][0] < target) {
                low = mid+1;
            }
            else if(matrix[mid][0] > target) {
                high = mid-1;
            }
        }
        return -1;
    }
    //then do binary search over that potential row's columns
    private boolean binarySearchOverRow(int rowIndex, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[rowIndex].length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (matrix[rowIndex][mid] == target) {
                return true;
            }
            else if(matrix[rowIndex][mid] < target) {
                low = mid+1;
            } 
            else if (matrix[rowIndex][mid] > target) {
                high = mid-1;
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {

//         //T:O(n*m) , S:O(1)
//         int m = matrix.length; //row length
//         int n = matrix[0].length; //column length
//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n; j++) {
//                 if (matrix[i][j] == target) {
//                     return true;
//                 }
//             }
//         }
//         return false;

//     }
// }
