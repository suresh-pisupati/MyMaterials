package arrayproblems;

/**
 * Program to display given matrix in spiral form.
 * <li>1. Take the variables top, bottom, left, right to represent the indexes
 * in the given matrix.</li>
 * <li>2. First, print the <b>left to right</b> elements of top row in the
 * matrix. After printing increment the top so that top will pointing to the
 * next row.</li>
 * <li>3. Second, print the <b>top to bottom</b> elements from the right most
 * index. After printing decrement the right so that right will be pointing to
 * previous column.</li>
 * <li>4. Third, print the <b>right to left</b> elements of the bottom row of
 * the matrix. After printing decrement the bottom value. Before performing this
 * logic we should check if the top <= bottom.</li>
 * <li>5. Finally, print the <b>bottom to top</b> elements of the matrix. After
 * printing increment the left to point to the next coulmn of the matrix.</li>
 * 
 * @author pksuresh
 *
 */
public class DisplayMatrixInSpiralForm {

	private static final int ROW_SIZE = 4;
	private static final int COLUMN_SIZE = 3;

	private int[][] matrix = null;

	public DisplayMatrixInSpiralForm() {

		matrix = new int[ROW_SIZE][COLUMN_SIZE];
	}

	private int[][] populateMatrix() {
		int count = 1;
		for (int row = 0; row < ROW_SIZE; row++) {
			for (int column = 0; column < COLUMN_SIZE; column++) {
				matrix[row][column] = count++;
			}
		}
		return matrix;
	}

	private void displayMatrixInSpiralForm() {

		StringBuilder builder = new StringBuilder();

		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (top <= bottom && left <= right) {
			// Print left to right
			for (int index = left; index <= right; index++) {
				builder.append(matrix[top][index]).append("\t");
			}
			// Since first row is printed, increment the top to go the next row
			top++;

			// Print top to bottom
			for (int index = top; index <= bottom; index++) {
				builder.append(matrix[index][right]).append("\t");
				;
			}
			// Since top to bottom is printed, decrement the right to previous
			// column
			right--;

			// Print right to left
			if (top <= bottom) {
				for (int index = right; index >= left; index--) {
					builder.append(matrix[bottom][index]).append("\t");
				}
				// Since bottom row is printed, decrement the bottom
				bottom--;
			}

			// Print bottom to top
			if (left <= right) {
				for (int index = bottom; index >= top; index--) {
					builder.append(matrix[index][left]).append("\t");
				}
				// Since all rows are displayed, increment left
				left++;
			}
		}
		System.out.println(builder);
	}

	private void displayMatrixInVerticalSpiralForm() {

		StringBuilder builder = new StringBuilder();

		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (top <= bottom && left <= right) {

			// Print top to bottom
			for (int index = top; index <= bottom; index++) {
				builder.append(matrix[index][left] + "\t");
			}
			// Since first column is printed, increment left
			left++;

			// Print left to right
			for (int index = left; index <= right; index++) {
				builder.append(matrix[bottom][index] + "\t");
			}
			// Since the bottom row is printed, decrement bottom
			bottom--;

			if (top < bottom) {
				// Print bottom to top
				for (int index = bottom; index >= top; index--) {
					builder.append(matrix[index][right] + "\t");
				}
				// Since last column is printed, decrement right
				right--;
			}

			if (left <= right) {
				// Print right to left
				for (int index = right; index >= left; index--) {
					builder.append(matrix[top][index] + "\t");
				}
				// Since the first row is printed, increment row
				top++;
			}
		}
		System.out.println(builder);
	}

	private void displayMatrix() {

		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j < COLUMN_SIZE; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		DisplayMatrixInSpiralForm displayMatrixInSprialForm = new DisplayMatrixInSpiralForm();
		displayMatrixInSprialForm.populateMatrix();
		displayMatrixInSprialForm.displayMatrix();
		System.out.println();
		displayMatrixInSprialForm.displayMatrixInSpiralForm();
		System.out.println();
		displayMatrixInSprialForm.displayMatrixInVerticalSpiralForm();
	}

}
