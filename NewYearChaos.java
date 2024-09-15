/*
Problem Statement: New Year Chaos
On New Year's Day, people are lined up for a rollercoaster ride, each wearing a sticker indicating their original position in the queue, numbered from 1 to n. 
Each person can bribe the person directly in front of them to swap positions, but they can bribe at most two others.

The task is to determine the minimum number of bribes that took place to achieve a given final queue order. If anyone has bribed more than two people, print "Too chaotic".
Input Format:
    The first line contains an integer t, the number of test cases.
    
    For each test case:
        An integer n, the number of people in the queue.
        A list of n space-separated integers representing the final state of the queue.

Output Format:
    For each test case, print the minimum number of bribes or "Too chaotic" if the condition is violated.
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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) 
    {
        // Write your code here
        int n = q.size();
        int nBribes = 0;
        
        for(int i = 0; i < n; i++)
        {
            int indexBeforeBribe = q.get(i) - 1;
            
            if(indexBeforeBribe - i > 2)
            {
                System.out.println("Too chaotic");
                return;
            }
            
            for(int j = Math.max(0, indexBeforeBribe - 2); j < i; j++)
            {
                if(q.get(j) > q.get(i))
                {
                    nBribes++;
                }
            }
        }
        
        System.out.println(nBribes);
    }
}

public class NewYearChaos 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> 
        {
            try 
            {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } 
            
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
