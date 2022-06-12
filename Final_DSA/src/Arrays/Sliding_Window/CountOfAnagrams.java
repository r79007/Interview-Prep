package Arrays.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class CountOfAnagrams {

    public static void main(String[] args) {

        String input = "fxoraxofxo";

        String pattern = "fox";


        System.out.println(countOccOfAnagrams(input, pattern));

    }


    private static int countOccOfAnagrams(String input, String pattern) {

        if (pattern == null || "".equals(pattern) || input == null || "".equals(input)) {

            return -1;

        }

        int windowSize = pattern.length();

        int i = 0, j = 0, count = 0, result = 0;


        Map<Character, Integer> countMap = new HashMap<>();


        //populate map

        for (int k = 0; k < pattern.length(); k++) {

            Integer charCount = countMap.get(pattern.charAt(k));

            if (charCount == null) {

                countMap.put(pattern.charAt(k), 1);

            } else {

                countMap.put(pattern.charAt(k), charCount++);

            }

        }

        // count of distinct characters

        count = countMap.keySet().size();


        while (j < input.length()) {

            char endChar = input.charAt(j);


            // calculation for character at end of window

            if (countMap.containsKey(endChar)) {

                countMap.put(endChar, countMap.get(endChar) - 1);

            }

            if (countMap.get(endChar) != null && countMap.get(endChar) == 0) {

                count--;

            }


            if (j - i + 1 < windowSize) {

                j++;

            } else {

                if (count == 0) {

                    result++;

                }

                char startChar = input.charAt(i);

                // calculation for character at moving out of window

                if (countMap.containsKey(startChar)) {

                    countMap.put(startChar, countMap.get(startChar) + 1);

                }

                if (countMap.get(startChar) != null && countMap.get(startChar) == 1) {

                    count++;

                }

                i++;

                j++;

            }


        }

        return result;

    }


}
