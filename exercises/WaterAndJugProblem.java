/**
 * Program to find the solution for Water jug problem.
 * 
 * @author pksuresh
 *
 */
public class WaterAndJugProblem {

	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

		if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity
				|| jug1Capacity + jug2Capacity == targetCapacity) {
			return true;
		}
		return targetCapacity % GCD(jug1Capacity, jug2Capacity) == 0;
	}

	private int GCD(int jug1Capacity, int jug2Capacity) {

		if (jug1Capacity == 0) {
			return jug2Capacity;
		}
		if (jug2Capacity == 0) {
			return jug1Capacity;
		}
		if (jug1Capacity == jug2Capacity) {
			return jug1Capacity;
		}
		if (jug1Capacity > jug2Capacity) {
			return GCD(jug1Capacity - jug2Capacity, jug2Capacity);
		}
		return GCD(jug1Capacity, jug2Capacity - jug1Capacity);
	}

	public static void main(String[] args) {

		WaterAndJugProblem problem = new WaterAndJugProblem();
		System.out.println(problem.canMeasureWater(2, 6, 9));
	}

}
