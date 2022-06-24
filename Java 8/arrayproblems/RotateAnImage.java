package arrayproblems;

public class RotateAnImage {

    public RotateAnImage() {

    }

    private void rotateAnImage(int[][] matrix) {

        int N = matrix.length;
       for(int j = 0; j < N; j++) {
           for(int i = N - 1; i >=0; i--) {
               System.out.print(matrix[i][j] + "\t");
           }
           System.out.println();
       }
    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        RotateAnImage obj = new RotateAnImage();
        obj.rotateAnImage(arr);
    }
}
