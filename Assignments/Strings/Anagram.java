package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void isAnagram(String s1, String s2){
        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch : s2.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0) {
                System.out.println("Not Anagram");
                return;
            }
            map.put(ch, map.get(ch) - 1);
        }
        System.out.println("Anagram");
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            String st = sc.nextLine();
            String s2 = sc.nextLine();
            isAnagram(st, s2);
        }
    }
}
