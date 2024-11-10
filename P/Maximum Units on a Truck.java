class Solution
{
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int sum = 0;

        for (int[] box : boxTypes)
        {
            int numberOfBoxes = box[0];
            int numberOfUnitsPerBox = box[1];
            
            if (truckSize >= numberOfBoxes)
            {
                sum += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            }

            else
            {
                sum += truckSize * numberOfUnitsPerBox;
                break;
            }
        }

        return sum;
    }
}
