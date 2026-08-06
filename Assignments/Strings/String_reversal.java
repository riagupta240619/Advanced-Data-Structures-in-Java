package Strings;

import java.util.Scanner;
public class String_reversal {
    public static void using_reversal(String s){
        int len = s.length();
        char[] st = new char[len];
        int idx = 0;
        for(char c : s.toCharArray()){
            st[idx] = c;
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1;i>=0;i--){
            sb.append(st[i]);
        }
        System.out.println(sb);
        return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new StringBuilder(s).reverse());
        using_reversal(s);
        sc.close();
    }
}
