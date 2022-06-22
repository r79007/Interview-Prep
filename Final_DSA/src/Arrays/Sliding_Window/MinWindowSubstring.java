package Arrays.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {

        if(s.equals(t))
            return s;
        if(t.length()>s.length())
            return "";

        int result = Integer.MAX_VALUE;
        int n = s.length();
        String resString ="";
        int i = 0;
        int j = 0;
        var map = new HashMap<Character, Integer>();
        var tMap = populateTMap(t);
        int count = tMap.size();
        while (j <n) {

            char key = s.charAt(j);

            if (tMap.containsKey(key)) {
                tMap.compute(key, (k, v) -> v - 1);
                if (tMap.get(key) == 0)
                    count--;
            }

            if (count==0) {
                if (result > j - i + 1) {
                    result = Math.min(result, j - i + 1);

                    resString = s.substring(i, j+ 1);

                }
            }
            j++;

            while(count==0 )
            {
                char keyAtI = s.charAt(i);
                if(tMap.containsKey(keyAtI) )
                {
                    tMap.compute(keyAtI, (k, v) -> v + 1);
                    if(tMap.get(keyAtI)>0)
                        count++;
                }

                i++;
                if (result > j - i + 1) {
                    result = Math.min(result, j - i + 1);

                    resString = s.substring(i-1, j);

                }
            }
        }

        return resString;
    }

    private Map<Character, Integer> populateTMap(String t) {
        var tMap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            tMap.computeIfPresent(c, (k, v) -> v + 1);
            tMap.putIfAbsent(c, 1);
        }
        return tMap;
    }

}
