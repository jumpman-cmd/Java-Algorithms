class Solution 
{
    public boolean isValid(String s)
    {
        Stack<Character> brackets = new Stack<>();
        int n = s.length();
        boolean yes = true;
        boolean no = false;

        for (int i = 0; i < n; i++)
        {
            char initialBracket = s.charAt(i);

            if (initialBracket == '(' || initialBracket == '['
                || initialBracket == '{')
            {
                brackets.push(initialBracket);
            }

            else if (initialBracket == ')' || initialBracket == ']'
                    || initialBracket == '}')
            {
                if (brackets.isEmpty())
                {
                    return no;
                }

                char closingBracket = brackets.pop();

                if (initialBracket == ')' && closingBracket != '('
                    || initialBracket == ']' && closingBracket != '['
                    || initialBracket == '}' && closingBracket != '{'
                    || initialBracket == '(' && closingBracket != ')'
                    || initialBracket == '[' && closingBracket != ']'
                    || initialBracket == '{' && closingBracket != '}')
                {
                    return no;
                }
            }
        }

        return brackets.isEmpty()? yes : no;
    }
}
