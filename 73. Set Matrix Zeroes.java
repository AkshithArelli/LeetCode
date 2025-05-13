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

       //T: O(m*n) , S:O(1)
        //not using any extra space, but rather using the first column and row
        //excluding first row and column, if any other place has zero in it,
        //update corresponding 1st row and column to zero so that later when again traversing
        //if the first value of that row or column is zero all the elements in that row or column are changed to zero
        //**incase if 1st row or column has zero in it we change entire 1st row and column to zero as well, so inorder to track those values we are using boolean variables
        //this is neccessary because it is possible 1st row or column might not have zero but due to zero values in other rows and columns we update 1st r & c to zero by mistake there is a chance we might update entire r & c to zero, inorder to avoid this we have the boolean vars
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowContainsZero = false;
        boolean colContainsZero = false;

        //in the following loop we make sure to check if 1st row and column has zero 
        //and also we update 1st row and column values to zero if any of the sub-matrix has zero
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    //if 1st row has zero in it change it to true so later we can convert all the values in the row of 1st to 0
                    if (i == 0) rowContainsZero = true;
                    //if 1st column has zero in it change it to true so later we can convert all the values in the column of 1st to 0
                    if (j == 0) colContainsZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

    
        //loop through the submatrix and if zero is present in 1st r or c update corresponding entire r & c values to zero (as 1st r & c is already updated to zero)
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[0][j] ==0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowContainsZero) {
            for (int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colContainsZero) {
            for (int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }




     
     

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
