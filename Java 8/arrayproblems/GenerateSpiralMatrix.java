package arrayproblems;

public class GenerateSpiralMatrix {

    private int[][] matrix;
    private int number;

    public int[][] generateSpiralMatrix(int n) {
        this.number = n;
        int top = 0, bottom = n - 1, left = 0, right = n - 1, temp = 0;
        matrix = new int[n][n];
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++temp;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++temp;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = ++temp;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = ++temp;
                }
                left++;
            }
        }
        return matrix;
    }

    private void display() {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GenerateSpiralMatrix obj = new GenerateSpiralMatrix();
        obj.generateSpiralMatrix(5);
        obj.display();
    }
}
