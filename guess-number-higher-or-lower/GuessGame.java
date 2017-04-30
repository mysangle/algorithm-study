/**
 * The guess api is defined in the parent class.
 *   int guess(int num);
 *   : return 01 if my number is lower, 1 if my number is higher,
 *     otherwise return 0
 */
public class GuessGame {
    public int guessNumber(int n) {
        int result = -1;
        int high = n;
        int low = 1;
        int guessValue = low + (high - low) / 2;
        while (low <= high) {
            result = guess(guessValue);
            switch (result) {
                case -1:
                    high = guessValue - 1;
                    break;
                case 1:
                    low = guessValue + 1;
                    break;
                case 0:
                    return guessValue;
            }
            guessValue = low + (high - low) / 2;
        }
        return result;
    }
}
