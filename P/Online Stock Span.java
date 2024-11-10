class StockSpanner 
{
    private Stack<int[]> input;

    public StockSpanner()
    {
        input = new Stack<>();    
    }
    
    public int next(int price)
    {
        int span = 1;

        while (!input.isEmpty() && input.peek()[0] <= price)
        {
            span += input.pop()[1];
        }

        input.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
