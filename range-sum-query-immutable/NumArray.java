public class NumArray {
  int length = 0;
  int[] sums;
  int[] nums;

  public NumArray(int[] nums) {
    if (nums.length != 0) {
      this.nums = nums;
      this.length = nums.length;

      sums = new int[this.length];
      sums[0] = nums[0];
      for (int i = 1; i < this.length; i++) {
        sums[i] = sums[i - 1] + nums[i];
      }
    }
  }

  public int sumRange(int i, int j) {
    if (length == 0) {
      return 0;
    }
    return sums[j] - sums[i] + nums[i];
  }
}

