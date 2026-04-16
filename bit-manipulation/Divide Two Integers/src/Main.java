//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
//        System.out.println(solution.divide(-7, 1));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = false;
        if (dividend < 0) {
            dividend = ~dividend + 1;
            negative = true;
        }
        if (divisor < 0) {
            divisor = ~divisor + 1;
            negative = !negative;
        }

        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++) ;
            quotient += 1 << subQuot;
            dividend -= divisor << subQuot;

        }
        return negative ? -quotient : quotient;
    }
}