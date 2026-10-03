class Solution 
{
    public String convert(String s, int numRows) 
  {
        if (numRows == 1 || numRows >= s.length()) 
        {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) 
        {
            rows[i] = new StringBuilder();
        }

        int currentLine = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) 
        {
            rows[currentLine].append(c);
            
            if (currentLine == 0 || currentLine == numRows - 1) 
            {
                goingDown = !goingDown;
            }
            
            currentLine += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) 
        {
            result.append(row);
        }

        return result.toString();
    }
}
