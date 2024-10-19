class Solution 
{
    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        Arrays.sort(products);
        List<List<String>> results = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : searchWord.toCharArray())
        {
            prefix.append(c);
            List<String> suggestions = new ArrayList<>();

            for (String product : products)
            {
                if(product.startsWith(prefix.toString()))
                {
                    suggestions.add(product);
                }

                if (suggestions.size() == 3)
                {
                    break;
                }
            }

            results.add(suggestions);
        }        

        return results;
    }
}
