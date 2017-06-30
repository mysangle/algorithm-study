public class SubArraySum {
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum = sum + nums[j];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }

  public int subarraySum2(int[] nums, int k) {
    int[] partialSums = new int[nums.length+1];
    partialSums[0] = 0;
    int partialSum = 0;
    for (int i = 0; i < nums.length; i++) {
      partialSums[i+1] = partialSum + nums[i];
      partialSum += nums[i];
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum;
      for (int j = i+1; j <= nums.length; j++) {
        sum = partialSums[j] - partialSums[i];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    SubArraySum sas = new SubArraySum();
    int[] nums = {-1,-1,1,1};
    int k = 0;
    System.out.println(sas.subarraySum(nums, k));
    System.out.println(sas.subarraySum2(nums, k));
  }
}

