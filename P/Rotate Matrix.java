class Solution 
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length; // get the length of matrix arrays -> n * n
        int[][] rotate = new int[n][n];  // store rotated results

        // rotate the matrix
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                rotate[j][n - i - 1] = matrix[i][j];
            }
        }

        // copy the rotated elements back to the array.
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = rotate[i][j];
            }
        }

        // I have n * n
        // Time complexity = O(n^2)
        // Space complexity = O(n^2)
    }
}
