package Array_Striver.easy;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/alternating-digit-sum/">...</a>
 */
public class AlternateDigitSum {
    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int sign = 1;
        int sum = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            int a = Integer.parseInt(str.charAt(i) + "");
            sum += (a * sign);
            sign = sign * -1;
        }

        return sum;
    }
}
