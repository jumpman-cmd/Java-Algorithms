

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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     public static void plusMinus(List<Integer> arr) 
     {
         // Write your code here
         int n = arr.size();
         int positiveNumbers = 0;
         int negativeNumbers = 0;
         int zeroNumbers = 0;
         
         for(int arrElement : arr)
         {
             if(arrElement > 0)
             {
                 positiveNumbers++;
             }
             
             else if(arrElement < 0)
             {
                 negativeNumbers++;
             }
             
             else
             {
                 zeroNumbers++;
             }
         }
         
         double positiveNumbersRatio = (double) positiveNumbers / n;
         double negativeNumbersRatio = (double) negativeNumbers / n;
         double zeroNumbersRatio = (double) zeroNumbers / n;
         
         System.out.printf("%.6f%n", positiveNumbersRatio);
         System.out.printf("%.6f%n", negativeNumbersRatio);
         System.out.printf("%.6f%n", zeroNumbersRatio);
     }
}

public class PlusMinus 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
