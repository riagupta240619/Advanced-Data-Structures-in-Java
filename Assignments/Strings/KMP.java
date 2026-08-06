package Strings;

import java.util.*;
public class KMP {
    static void lps(String p, int[] arr){
        int m = p.length();
        arr[0] = 0;
        int len = 0;
        int i = 1;
        while(i < m){
            if(p.charAt(i) == p.charAt(len)){
                len++;
                arr[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = arr[len - 1];
                }else{
                    arr[i] = 0;
                    i++;
                }
            }
        }
    }
    static ArrayList<Integer> search(String s, String p){
        ArrayList<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[] arr = new int[m];
        lps(p,arr);
        int i = 0, j = 0;
        while(i < n){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                res.add(i - j);
                j = arr[j - 1];
            }else if(i < n && s.charAt(i) != p.charAt(j)){
                if(j != 0){
                    j = arr[j - 1];
                }else{
                    i++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s = "aabacababaaba";
        String p = "aaba";
        ArrayList<Integer> res = search(s,p);
        System.out.println(res);
    }
}
