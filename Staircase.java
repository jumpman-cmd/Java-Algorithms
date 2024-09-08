/*
Problem Statement: Staircase
Write a program to print a staircase of size n using the # symbol. The staircase will consist of n levels, and each level should be right-aligned. 
The staircase is constructed such that each level contains a number of spaces followed by # symbols.

e.g., For an input of n = 6, the staircase has 6 levels. The first level has 5 spaces and 1 #, the second level has 4 spaces and 2 #, and so on, 
until the last level, which has no spaces and 6 # symbols. Each level is printed on a new line
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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
     
     public static void staircase(int n) 
     {
         // Write your code here
         for(int i = 1; i <= n; i++)
         {
             for(int j = 0; j < n - i; j++)
             {
                 System.out.print(" ");
             }
             
             for(int k = 0; k < i; k++)
             {
                 System.out.print("#");
             }
             
             // Move to the next line after every #'s print
             System.out.println();
         }
     }
}

public class Staircase 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
