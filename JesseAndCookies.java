/*
You are given a list of cookies with varying sweetness levels. The goal is to make all cookies have a sweetness greater than or equal to a given value kk. 
To do this, you can repeatedly mix the two least sweet cookies, creating a new cookie with sweetness equal to:
-> new sweetness=(1st least sweet cookie)+2×(2nd least sweet cookie)

Return the minimum number of mix operations required to achieve this, or return -1 if it's impossible.
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
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
     
     public static int cookies(int k, List<Integer> A) 
     {
         // Write your code here
         PriorityQueue<Integer> bakedCookie = new PriorityQueue<>(A);
         int mixes = 0;
         
         while(bakedCookie.size() > 1 && bakedCookie.peek() < k)
         {
             int leastSweetCookie = bakedCookie.poll();
             int secondLeastSweetCookie = bakedCookie.poll();
             
             int newSweetness = (1 *leastSweetCookie + 2 * secondLeastSweetCookie);
             
             bakedCookie.add(newSweetness);
             
             mixes++;
         }
         
         if(bakedCookie.peek() >= k)
         {
             return mixes;
         }
         
         else
         {
             return -1;
         }
     }
}

public class JesseAndCookies 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
