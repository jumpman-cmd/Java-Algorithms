/*
Problem Statement:
You are given a list of integers. Your task is to find the minimum absolute difference between any two elements in the list.

Function Signature:
Complete the function minimumAbsoluteDifference(arr) that takes in a list of integers and returns the smallest absolute difference between any two elements.

Input:
The first line contains a single integer n (the size of the list).
The second line contains n space-separated integers representing the elements of the list.
    
Output:
Return a single integer, the minimum absolute difference between any two elements in the list.
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
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     public static int minimumAbsoluteDifference(List<Integer> arr) 
     {
         // Write your code here
         int n = arr.size();
         int minimumDifference = Integer.MAX_VALUE;
         int arrayDifferenceInArrays = 0;
         Collections.sort(arr);
         
         for(int i = 1; i < n; i++)
         {
             arrayDifferenceInArrays = Math.abs(arr.get(i) - arr.get(i - 1));
             
             if(arrayDifferenceInArrays < minimumDifference)
             {
                 minimumDifference = arrayDifferenceInArrays;
             }
         }
         
         return minimumDifference;
     }
}

public class MinimumAbsoluteDifferenceInAnArray
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
