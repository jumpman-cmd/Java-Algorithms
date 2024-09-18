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
    static final int MOD = 1000000007;
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
     
     public static int legoBlocks(int n, int m) 
     {
         // Write your code here
         long[] legoBlocks = new long[m + 1];
         legoBlocks[0] = 1;
         
         for(int i = 1; i <= m; i++)
         {
             legoBlocks[i] = legoBlocks[i - 1];
             if(i >= 2)
             {
                 legoBlocks[i] = (legoBlocks[i] + legoBlocks[i - 2]) % MOD;
             }
             
             if(i >= 3)
             {
                 legoBlocks[i] = (legoBlocks[i] + legoBlocks[i - 3]) % MOD;
             }
             
             if(i >= 4)
             {
                 legoBlocks[i] = (legoBlocks[i] + legoBlocks[i - 4]) % MOD;
             }
         }
         
         long[] totalLegoWays = new long[m + 1];
         for(int i = 1; i <= m; i++)
         {
             totalLegoWays[i] = rowsPow(legoBlocks[i], n, MOD)/* % MOD*/;
         }
         
         long[] validWays = new long[m + 1];
         validWays[0] = 1;
         
         for(int i = 1; i <= m; i++)
         {
             validWays[i] = totalLegoWays[i];
             for(int j = 1; j < i; j++)
             {
                 validWays[i] = (validWays[i] - (validWays[j] * totalLegoWays[i - j]) % MOD + MOD) % MOD;
             }
         }
         
         return (int) validWays[m];
     }
     
     public static long rowsPow(long base, int exp, int mod)
     {
         long results = 1;
         
         while(exp > 0)
         {
             if((exp & 1) == 1)
             {
                 results = (results * base) % mod;
             }
             
             base = (base * base) % mod;
             exp >>= 1;
         }
         
         return results;
     }
}

public class LegoBlocks 
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

                int result = Result.legoBlocks(n, m);

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
