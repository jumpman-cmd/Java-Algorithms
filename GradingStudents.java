/*
Problem Statement:

Sam is a professor at HackerLand University, and he needs help rounding student grades according to the university's grading policy. Every student receives a grade in the inclusive range from 0 to 100. A grade less than 40 is considered a failing grade.

The university's rounding policy is as follows:
    If the difference between a student's grade and the next multiple of 5 is less than 3, round the grade up to the next multiple of 5.
    If the value of the grade is less than 38, no rounding occurs because the grade is a failing grade.
    Grades that are exactly multiples of 5 are not changed.

Task:
Write a function gradingStudents that takes an integer array of grades as input and returns a rounded integer array according to the university's grading policy.

Parameters:
    grades: A list of integers where each integer represents a student's grade before rounding.

Returns:
    A list of integers representing the grades after applying the rounding rules.

Constraints:
    1 <= grades.size() <= 100
    0 <= grades[i] <= 100 where grades[i] is the grade of the i-th student.

Note:
   The rounding rule only applies to grades greater than or equal to 38.
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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) 
    {
        // Write your code here
        List<Integer> finalGrade = new ArrayList<>();
        
        for(int grade : grades)
        {
            if(grade < 38)
            {
                finalGrade.add(grade);
            }
            
            else
            {
                int isGradeMultipleOf5 = (((grade / 5) + 1) * 5);
                boolean shouldGradeRoundUp = (isGradeMultipleOf5 - grade) < 3;
                if(shouldGradeRoundUp)
                {
                    finalGrade.add(isGradeMultipleOf5);
                }
                
                else
                {
                    finalGrade.add(grade);
                }
            }
        }
        
        return finalGrade;
    }
}

public class GradingStudents
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> 
        {
            try 
            {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } 
            
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
