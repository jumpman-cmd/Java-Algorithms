/*Problem: Time Conversion
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note:
12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Function Description
Complete the function timeConversion in the editor below.

The function timeConversion has the following parameter(s):

string s: a time in 12-hour AM/PM format.
Returns
string: the time in 24-hour format.

Input Format
A single string s representing a time in 12-hour clock format (i.e., hh:mm:ssAM or hh:mm:ssPM).

Constraints
All input times are valid.
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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
     
     public static String timeConversion(String s)
     {
         // Write your code here
         
         int hour = Integer.parseInt(s.substring(0, 2));
         
         if(s.endsWith("PM") && hour != 12)
         {
             hour += 12; // convert to 24-hour time style
         }
         
         if(s.endsWith("AM") && hour == 12)
         {
             hour = 00; // Convert to 00 AM midnight
         }
         
         return String.format("%02d", hour) + s.substring(2, 8);
     }
}

public class TimeConversion 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
