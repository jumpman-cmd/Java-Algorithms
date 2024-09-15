// I am still working on it, it gives me errors when I run it.

/*
Problem Statement: Grid Challenge

You are given a square grid of characters where each character is a lowercase letter in the range a-z. 
Your task is to rearrange the elements of each row in alphabetical order and then determine 
if the columns are also sorted in alphabetical order from top to bottom.

Input
    grid: A list of n strings, where each string represents a row of the grid, 
    and n is the number of rows (and columns, since it's a square grid).

Output
    Return "YES" if after sorting each row alphabetically, the columns are 
    also sorted alphabetically from top to bottom. Otherwise, return "NO".

Constraints
    Each string in the grid consists of lowercase letters (a-z).
    The grid is always a square grid (i.e., it has the same number of rows and columns).
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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
     
     public static String gridChallenge(List<String> grid) 
     {
         // Write your code here
         int gridN = grid.size();
         
         for(int i = 0; i < gridN; i++)
         {
             char[] gridArrays = grid.get(i).toCharArray();
             Arrays.sort(gridArrays);
             grid.set(i, new String(gridArrays));
         }
         
         for(int j = 0; j < grid.get(0).length(); j++) // j = columns
         {
             for(int k = 1; k < gridN; k++) // k = rows
             {
                 if(grid.get(k).charAt(j) < grid.get(k - 1).charAt(j))
                 {
                     return "NO";
                 }
                 
                 /* else
                 {
                     return "YES";
                 }*/
             }
         }
         
         return "YES";
     }
}

public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> 
        {
            try 
            {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> 
                {
                    try 
                    {
                        return bufferedReader.readLine();
                    } 
                    
                    catch (IOException ex) 
                    {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } 
            
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
