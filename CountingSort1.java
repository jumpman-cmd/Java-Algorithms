/*Problem Statement: Counting Sort Frequency Array
Objective:
Complete the function countingSort in the editor below, which takes a parameter: a list of integers. The function must return a frequency array that indicates how many times each integer appears in the list.

Function Description:
countingSort has the following parameter(s):
List<Integer> arr: a list of integers where each integer is in the range 0 <= arr[i] < 100.

Returns:
List<Integer>: A list of 100 integers, where each index i contains the frequency of the integer i in the input list.

Input Format:
The first line contains an integer n, the number of items in arr.
Each of the next n lines contains an integer arr[i] where 0 <= arr[i] < 100

Output Format:
Return a list of 100 integers representing the frequency of each integer in the range [0, 99].
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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     public static List<Integer> countingSort(List<Integer> arr) 
     {
         // Write your code here
         List<Integer> n = new ArrayList <>(Collections.nCopies(100, 0));
         
         for(int arrEle : arr)
         {
             n.set(arrEle, n.get(arrEle) + 1);
         }
         
         return n;
     }
}

public class CountingSort1 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
