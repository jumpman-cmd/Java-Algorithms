import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int[][] A2d = new int[6][6];
        
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                A2d[i][j] = scan.nextInt();
            }
        }
        
        int maxHourGlassSum = Integer.MIN_VALUE;
        
        for(int i = 0; i <= 3; i++)
        {
            for(int j = 0; j <= 3; j++)
            {
                int currentHourGlassSum = A2d[i][j] + A2d[i][j + 1] + A2d[i][j + 2] 
                + A2d[i + 1][j + 1]
                + A2d[i + 2][j] + A2d[i + 2][j + 1] + A2d[i + 2][j + 2];
                
                if(currentHourGlassSum > maxHourGlassSum)
                {
                    maxHourGlassSum = currentHourGlassSum;
                }
            }
        }
        
        System.out.println(maxHourGlassSum);
        scan.close();
    }
}
