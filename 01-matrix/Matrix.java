public class Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] updated = new int[matrix.length][matrix[0].length];

        // initialize
        for (int i = 0; i < updated.length; i++) {
            for (int j = 0; j < updated[i].length; j++) {
                updated[i][j] = 100;
            }
        }

        // forward
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                if (value == 0) {
                    updated[i][j] = 0;
                } else {
                    if (j-1 >= 0) {
                        updated[i][j] = updated[i][j-1] + 1;
                    }
                    if (i-1 >= 0) {
                        updated[i][j] = min(updated[i][j], updated[i-1][j] + 1);
                    }
                }

                int newValue = updated[i][j] + 1;
                if (j-1 >= 0) {
                    updated[i][j-1] = min(updated[i][j-1], newValue);
                }
                if (i-1 >= 0) {
                    updated[i-1][j] = min(updated[i-1][j], newValue);
                }
            }
        }

        // backward
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if (j-1 >= 0) {
                    updated[i][j] = min(updated[i][j-1]+1, updated[i][j]);
                }
                if (j+1 < matrix[i].length) {
                    updated[i][j] = min(updated[i][j+1]+1, updated[i][j]);
                }
                if (i-1 >= 0) {
                    updated[i][j] = min(updated[i-1][j]+1, updated[i][j]);
                }
                if (i+1 < matrix.length) {
                    updated[i][j] = min(updated[i+1][j]+1, updated[i][j]);
                }
            }
        }
        return updated;
    }

    public int min(int x, int y) {
        return x > y ?  y : x;
    }

    public static void main(String[] args) {
        int[][] m = {{0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}};
        Matrix matrix = new Matrix();
        int[][] u = matrix.updateMatrix(m);

        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[i].length; j++) {
                System.out.print(u[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

