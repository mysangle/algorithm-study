/**
 * canJump has stack overflow error if nums is
 *  [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, ... ]
 *
 * canJump2 has time limit exceeded if nums is
 *  [25000, 24999, 24998, 24997, ... , 5, 4, 3, 2, 1, 1, 0, 0]
 */
public class JumpGame {
  public static boolean canJump(int[] nums) {
    int[] boolsCache = new int[nums.length];
    int ret = canJump(nums, 0, boolsCache);
    return (ret == 1);
  }

  private static int canJump(int[] nums, int index, int[] boolsCache) {
    if (boolsCache[index] != 0) {
      return boolsCache[index];
    }
    for (int i = index; i < nums.length; i++) {
      int val = nums[i];
      int last = val + i;
      if (last == nums.length - 1) {
        boolsCache[index] = 1;
        return 1;
      }

      last = (last >= nums.length) ? nums.length - 1 : last;
      for (int j = last; j > index; j--) {
        int ret = canJump(nums, j, boolsCache);
        boolsCache[index] = ret;
        if (ret == 1) {
          return 1;
        }
      }
    }
    boolsCache[index] = -1;
    return -1;
  }

  private static boolean canJump2(int[] nums) {
    boolean[] boolsCache = new boolean[nums.length];
    boolsCache[nums.length-1] = true;

    int lastIndex = nums.length - 1;
    for (int i = lastIndex-1; i >=0; i--) {
      int val = nums[i];
      int next = val + i;
      next = (next > lastIndex) ? lastIndex : next;
      for (int j = next; j > i; j--) {
        if (boolsCache[j]) {
          boolsCache[i] = true;
          break;
        }
      }
    }
    return boolsCache[0];
  }

  private static boolean canJump3(int[] nums) {
    int smallestOk = nums.length - 1;
    int lastIndex = nums.length - 1;
    for (int i = lastIndex-1; i >=0; i--) {
      int val = nums[i];
      int next = val + i;
      next = (next > lastIndex) ? lastIndex : next;
      if (smallestOk <= next) {
        smallestOk = i;
      }
    }
    return smallestOk == 0;
  }
}
