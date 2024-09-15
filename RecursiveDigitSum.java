/*
Super Digit Problem
Super Digit of a number (int) is defined using the following rules:
    Given an integer, we need to find its super digit.
    If the number has only one digit, then its super digit is the number itself.
    Otherwise, the super digit is the super digit of the sum of the digits of the number.

Example:
For the number 9875:
    The sum of the digits of 9875 is 9 + 8 + 7 + 5 = 29.
    The sum of the digits of 29 is 2 + 9 = 11.
    The sum of the digits of 11 is 1 + 1 = 2.
    Since 2 has only one digit, it is the super digit.

Additional Case with Repetition:
Given a number n and an integer k, we create a new number by concatenating n k times. We then calculate the super digit of this large number.
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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) 
    {
        // Write your code here
        long nSum = 0;
        
        for(char nDigits : n.toCharArray())
        {
            nSum += Character.getNumericValue(nDigits);
        }
        
        nSum *= k;
        return findnSuperDigit(nSum);
    }
    
    public static int findnSuperDigit(long m)
    {
        long mSum = 0;
        
        if(m < 10)
        {
            return (int) m;
        }
        
        while(m > 0)
        {
            mSum += m % 10;
            m /= 10;
        }
        
        return findnSuperDigit(mSum);
    }
}

public class RecursiveDigitSum 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
