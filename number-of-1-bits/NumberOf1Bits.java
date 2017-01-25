/**
 * hammingWeight: Time Limit Exceeded
 *
 * hammingWeight2: passed test
 */
public class NumberOf1Bits {
    public int hammingWeight2(int n) {
        int number = 0;
        if (n < 0) {
            number++;
            number += hammingWeight2(n - Integer.MIN_VALUE);
            return number;
        }

        while (n > 0) {
            if (n % 2 != 0) {
                number++;
            }
            n = n >> 1;
        }
        return number;
    }

    public int hammingWeight(int n) {
        if (n < 2) {
            return n;
        }

        int i = 0;
        while (n > 0) {
            int twos = getHigestTwoSquareValue(n);
            n -= twos;
            i++;
        }
        return i;
    }

    private int getHigestTwoSquareValue(int n) {
        int square = 1;
        while (square <= n) {
            square *= 2;
        }
        return square >> 1;
    }
}
