/**
 * The isBadVersion API is defined in the parent class VersionControl.
 *     boolean isBadVersion(int version);
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int high = n;
        int low = 1;
        int current;
        while (high != low) {
            current = low + (high - low) / 2 + 1;
            if (isBadVersion(current)) {
                high = current - 1;
            } else {
                low = current + 1;
            }
        }
        return isBadVersion(low) ? low : low + 1;
    }
}
