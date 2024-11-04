class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int num = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    num = num + 1; // num++;
                    depthFirstSearch(grid, i, j);
                }
            }
        }

        return num;
    }

    public void depthFirstSearch(char[][] grid, int i, int j)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
        {
            return;
        }

        grid[i][j] = '0';
        depthFirstSearch(grid, i + 1, j);
        depthFirstSearch(grid, i - 1, j);
        depthFirstSearch(grid, i, j + 1);
        depthFirstSearch(grid, i, j - 1);
    }
}
