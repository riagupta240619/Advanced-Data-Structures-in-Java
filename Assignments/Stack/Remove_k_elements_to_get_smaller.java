package Stack;
// Stack with Greedy
//A value k is given and if a number greater than the element at the top comes and k>0 pop the element at the top and push the same
// and push the remaining elements sin the stack
import java.util.*;
public class Remove_k_elements_to_get_smaller {
    public static String smallest(String s, int k){
        if(k == 0) return s;
        Stack<Integer> st = new Stack<>();
        for(char ch: s.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch-'0'){
                st.pop();
                k--;
            }
            st.push(ch-'0');
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();

    }
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            int k = sc.nextInt();
            System.out.println(smallest(s, k));
        }
    }
}
