class Solution 
{
    public String[] reorderLogFiles(String[] logs) 
    {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();

        for (String log : logs)
        {
            String[] split = log.split(" ", 2);

            if (Character.isDigit(split[1].charAt(0)))
            {
                digitLogs.add(log);
            }

            else
            {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, (log1, log2) ->
        {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            int num = split1[1].compareTo(split2[1]);

            if (num != 0) return num;

            return split1[0].compareTo(split2[0]);
        });

        String[] count = new String[logs.length];
        int i = 0;

        for (String log : letterLogs) count[i++] = log;
        for (String log : digitLogs) count[i++] = log;

        return count;
    }
}
