package Strings;

public class Lexographically_smallest {
    public static String lexo(String s){
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int left = 0;
        int right = 25;
        while(left<right){
            while(left<26 && freq[left]%2==0){
                left++;
            }
            while(right>=0 && freq[right]%2==0){
                right--;
            }
            if(left>=right) break;
            freq[left]++;
            freq[right]--;
            left++;
            right--;
        }
        StringBuilder leftHalf = new StringBuilder();
        char middle = 0;
        for(int i = 0;i<26;i++){
            for(int j = 0;j<freq[i]/2;j++){
                leftHalf.append((char)('a'+i));
            }
            if(freq[i]%2 == 1){
                middle = (char)('a' + i);
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(leftHalf);
        if(middle!=0){
            ans.append(middle);
        }
        ans.append(leftHalf.reverse());
        return ans.toString();
    }
    public static void main(String[] args){
        String s = "fhaigh";
        lexo(s);
    }
}
