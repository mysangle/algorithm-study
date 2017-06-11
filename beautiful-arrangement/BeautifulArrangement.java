public class BeautifulArrangement {
    static int count = 0;
    public static void countArrangement(int n) {
        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i;
        }
        int[] dest = new int[n];
        permuteHelper(src, dest, 0, n);
    }

    public static void permuteHelper(int[] src, int[] dest, int index, int n) {
        if (index == n) {
            count++;
            for (int i = 0; i < n; i++) {
                System.out.print(dest[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (src[i] != -1) {
                if (((src[i]+1) % (index+1) == 0) || ((index+1) % (src[i]+1) == 0)) {
                    dest[index] = src[i];
                    src[i] = -1;
                    permuteHelper(src, dest, index + 1, n);
                    src[i] = dest[index];
                }
            }
        }
    }
}

