/*Problem: Mini-Max Sum
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then, print the respective minimum and maximum values as a single line of two space-separated long integers.

Function Description
Complete the function miniMaxSum in the editor below.

The function miniMaxSum has the following parameter(s):

int arr[5]: an array of 5 positive integers.
Print
Print two space-separated long integers on one line:

The first is the minimum sum of 4 of the 5 integers.
The second is the maximum sum of 4 of the 5 integers.

Input Format
A single line of five space-separated integers.

Output Format
Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers.
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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     public static void miniMaxSum(List<Integer> arr) 
     {
         // Write your code here
         int[] nums = arr.stream().mapToInt(Integer::intValue).toArray();
         int minValue = nums[0];
         int maxValue = nums[0];
         long totalSum = 0;
         
         for(int arrElements : nums)
         {
             totalSum += arrElements;
             
             if(arrElements < minValue)
             {
                 minValue = arrElements;
             }
             
             if(arrElements > maxValue)
             {
                 maxValue = arrElements;
             }
         }
         
         long minTotalSum = totalSum - maxValue;
         long maxTotalSum = totalSum - minValue;
         
         System.out.println(minTotalSum + " " + maxTotalSum);
     }
}

public class Mini-MaxSum 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
