package Stack;
// Stack with dp
// dp[i] = [i-left_index+1] + dp[left_index - 1];
public class Longest_Valid_Parenthesis {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            // A valid substring must end with ')'
            if (s.charAt(i) == ')') {
                // Case 1 : "()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2)
                        dp[i] += dp[i - 2];
                }
                // Case 2 : "...))"
                else {
                    int leftIndex = i - dp[i - 1] - 1;
                    if (leftIndex >= 0 && s.charAt(leftIndex) == '(') {
                        dp[i] = (i - leftIndex + 1);
                        if (leftIndex > 0)
                            dp[i] += dp[leftIndex - 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}