package codingChallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    INPUT:
        6 4
        give me one grand today night
        give one grand today

    OUTPUT:
       Yes / No
 */
public class ransomNote {

    public static boolean canMake(String[] magazine, String[] ransom) {
        if (magazine.length < ransom.length) {
            return false;
        }

        Map<String, Integer> magazineOccurrences = new HashMap<>();

        // Store words from magazine in a hash map
        for (String word : magazine) {
            if (!magazineOccurrences.containsKey(word)) {
                magazineOccurrences.put(word, 0);
            }

            magazineOccurrences.put(word, magazineOccurrences.get(word) + 1);
        }

        // check if each word in ransom exits in magazine's hashmap
        for (String word : ransom) {
            if (magazineOccurrences.containsKey(word)) {
                int count = magazineOccurrences.get(word);

                if (count > 1) {
                    magazineOccurrences.put(word, count - 1);
                } else {
                    magazineOccurrences.remove(word);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 6; // in.nextInt();
        int n = 5; // in.nextInt();
        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] ransom = { "give", "one", "grand", "today" };
//        String magazine[] = new String[m];
//        for(int magazine_i=0; magazine_i < m; magazine_i++){
//            magazine[magazine_i] = in.next();
//        }
//        String ransom[] = new String[n];
//        for(int ransom_i=0; ransom_i < n; ransom_i++){
//            ransom[ransom_i] = in.next();
//        }

        System.out.println(canMake(magazine, ransom) ? "Yes" : "No");
    }
}
