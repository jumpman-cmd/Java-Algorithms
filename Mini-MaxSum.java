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
