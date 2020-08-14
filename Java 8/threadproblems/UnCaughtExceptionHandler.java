package threadproblems;

import java.util.List;

public class UnCaughtExceptionHandler {

	public UnCaughtExceptionHandler() {

		NewThread newThread = new NewThread();
		newThread.setName("New Thread");
		newThread.setUncaughtExceptionHandler(new MyException());
		newThread.start();
	}

	private class NewThread extends Thread {

		@Override
		public void run() {
			try {
				List<Integer> numbersList = null;
				numbersList.add(1);
			} catch (Exception ex) {
				throw new NullPointerException("Object not initialized.");
			}
		}
	}

	public static void main(String[] args) throws CustomException {

		new UnCaughtExceptionHandler();
	}
}