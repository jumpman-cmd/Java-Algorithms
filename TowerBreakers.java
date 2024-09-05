/*
Problem Statement: Tower Breakers Game
Two players are playing a game of Tower Breakers. Player 1 always moves first, and both players play optimally. The rules of the game are as follows:

Initially, there are n towers, and each tower has a height of m.
On each player's turn, they can choose any tower of height x (where x > 1) and reduce its height to y, where 1 ≤ y < x and x % y == 0 (i.e., the new height must be a divisor of the current height).
Players alternate turns, and the first player who cannot make a move loses the game.
Given the number of towers and their initial height, determine which player will win the game. If Player 1 wins, return 1. Otherwise, return 2.

For each test case, return 1 if Player 1 wins or 2 if Player 2 wins.

Constraints:
Both players play optimally.
The number of towers n is always greater than or equal to 1.
The height of each tower m is always greater than or equal to 1.
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
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
     
     public static int towerBreakers(int n, int m) 
     {
         // Write your code here
         if(m == 1)
         {
             return 2;
         }
         
         else if(n % 2 == 0)
         {
             return 2;
         }
         
         else
         {
             return 1;
         }
     }
}

public class Tower Breakers 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> 
        {
            try 
            {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } 
            
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
