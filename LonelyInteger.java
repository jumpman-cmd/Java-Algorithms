/*Problem Statement: Lonely Integer
Given an array of integers, where all elements but one occur twice, find the element that occurs only once.

Function Description:
Complete the lonelyInteger function in the editor below.

lonelyInteger has the following parameter:
List<Integer> a: an array of integers

Returns:
int: the element that occurs only once

Input Format:
The first line contains a single integer, n, the number of integers in the array.
The second line contains n space-separated integers that represent the array a.
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
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
     
     public static int lonelyinteger(List<Integer> a)
     {
         // Write your code here
         
         int arrayElementsSum = 0;
         
         for(int n : a)
         {
             arrayElementsSum ^= n;
         }
         
         return arrayElementsSum;
     }
}

public class LonelyInteger 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
