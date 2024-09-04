/*Problem Statement: Diagonal Difference
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

Function Description:
Complete the diagonalDifference function in the editor below.

diagonalDifference has the following parameter(s):
List<List<Integer>> arr: an array of integers representing the matrix.

Returns:
int: the absolute difference between the sums of the matrix's diagonals.

Input Format:
The first line contains a single integer, n, the number of rows and columns in the matrix.
Each of the next n lines describes a row, arr[i], and consists of n space-separated integers.

Output Format:
Return the absolute difference between the sums of the matrix's two diagonals as a single integer.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result 
{
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
     
     public static int diagonalDifference(List<List<Integer>> arr) 
     {
         // Write your code here
         int n = arr.size();
         int primaryDiagonal = 0;
         int secondaryDiagonal = 0;
         
         for(int i = 0; i < n; i++)
         {
             primaryDiagonal += arr.get(i).get(i);
             secondaryDiagonal += arr.get(i).get(n - i - 1);
         }
         
         return Math.abs(primaryDiagonal - secondaryDiagonal);
     }
}

public class DiagonalDifference 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> 
        {
            try 
            {
                arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
            } 
            
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
