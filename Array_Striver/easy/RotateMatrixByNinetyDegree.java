package Array_Striver.easy;

public class RotateMatrixByNinetyDegree {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0 ; i < n; i++) {
            for(int j = i+1 ; j < n ;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseRows(int[][] mat) {
        int n = mat.length;
        for(int i = 0 ; i < n ; i++) {
            reverseEachRow(mat[i]);
        }
    }

    private void reverseEachRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while(left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
