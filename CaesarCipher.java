/*
Problem Statement: Caesar Cipher Encryption
Julius Caesar used a cipher to encrypt his confidential messages. This cipher shifts each letter in the message by a certain number of positions in the alphabet. If the shift takes a letter past the end of the alphabet, the letter wraps around to the front. For instance, with a rotation factor of 3, the letters w, x, y, and z would map to z, a, b, and c, respectively.

The cipher only encrypts alphabetical characters, while non-alphabetical characters (like punctuation marks and symbols) remain unchanged.

Function Description
Write the function caesarCipher that takes a string and an integer as inputs and returns the encrypted string using Caesar's cipher.

Parameters:
string s: The unencrypted string consisting of letters and other characters.
int k: The number of positions to shift each letter by in the alphabet.

Returns:
string: The encrypted string.

Input Format
The first line contains an integer, n, the length of the unencrypted string.
The second line contains the unencrypted string, s.
The third line contains k, the number of positions to rotate each letter by.
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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
     
     public static String caesarCipher(String s, int k) 
     {
         // Write your code here
         StringBuilder cipher = new StringBuilder();
         k = k % 26;
         
         for(char ch : s.toCharArray())
         {
             if(Character.isLowerCase(ch))
             {
                 char rotatedCh1 = (char) ((ch - 'a' + k) % 26 + 'a');
                 cipher.append(rotatedCh1);
             }
             
             else if(Character.isUpperCase(ch))
             {
                 char rotatedCh2 = (char) ((ch - 'A' + k) % 26 + 'A');
                 cipher.append(rotatedCh2);
             }
             
             else
             {
                 cipher.append(ch);
             }
         }
         
         return cipher.toString();
     }
}

public class CaesarCipher 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
