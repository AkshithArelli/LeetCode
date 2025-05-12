Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]



class Solution {
    public void setZeroes(int[][] matrix) {


     

        //little bit time optimised but still not space optimised
        //T:O(m*n) , S:O(m+n)
        //look diagrams of YT video
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowsArray = new boolean[m];
        boolean[] colsArray = new boolean[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    rowsArray[i] = true;
                    colsArray[j] = true;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rowsArray[i] || colsArray[j]) {
                    matrix[i][j] = 0;
                }
            }
        }



        //brute force
        //T: O(Mn(M+M)), S: O(Mn) for extra arraylist
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        //T: O(m*n)
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        //O(m*n) // if all are zero list of size(m*n) and to iterate t takes m*n
        for (int i=0; i<list.size(); i+=2) {
            int row=list.get(i);
            int column=list.get(i+1);
            //O(m)
            for (int j=0; j<matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
            //O(n)
            for (int k=0; k<matrix.length; k++) {
                matrix[k][column] = 0;
            }
        }
        //(m*n)*(m+n)
        //(m*n)*(m*n)*(m+n)
    }
}
