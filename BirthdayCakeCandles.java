/*
Problem Statement: Birthday Cake Candles
You are tasked with finding out how many of the tallest candles on a birthday cake can be blown out. 
You will receive an array of integers, where each integer represents the height of a candle. 
The goal is to determine how many candles are the tallest.

e.g., There are 5 candles with heights 4, 4, 1, 3, 4. The tallest candle has a height of 4, and there are 3 such candles. 
Therefore, the output is 3.

Task:
Write a function to solve the problem.
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
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */
     
     public static int birthdayCakeCandles(List<Integer> candles) 
     {
         // Write your code here
         int maxCandleHeight;
         // What's the difference between Collections and Collection?
         maxCandleHeight = Collections.max(candles);
         
         int numOfMaxCandles = 0;
         
         for(int aCandle : candles) // A candle in candles
         {
             if(aCandle == maxCandleHeight)
             {
                 numOfMaxCandles++;
             }
         }
         
         return numOfMaxCandles;
     }
}

public class BirthdayCakeCandles 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
