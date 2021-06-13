package profind;

public class TestDeadlockExample1 {
	public static void main(String[] args) {
		final String resource0 = "a";
		final String resource1 = "b";
		final String resource2 = "c";
		final String resource3 = "d";
		final String resource4 = "e";
		final String resource5 = "f";

		Thread t0 = new Thread() {

			public void run() {
				boolean exit = false;

				synchronized (resource0) {
					System.out.println("thread 0: locked resource 0");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("thread 0: locked resource 1");
					}

				}

			}

		};

		Thread t1 = new Thread() {
			public void run() {

				synchronized (resource0) {
					System.out.println("thread 1: locked resource 1");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("thread 1: locked resource 0");
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {

				synchronized (resource3) {
					System.out.println("thread 2: locked resource 0");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("thread 2: locked resource 1");

					}
				}
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("thread 3: locked resource 3");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource0) {
						System.out.println("thread 2: locked resource 2");
					}
				}
			}
		};

		Thread t4 = new Thread() {
			public void run() {

				synchronized (resource4) {

					System.out.println("thread 4: locked resource 4");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource5) {
						System.out.println("thread 4: locked resource 5");
					}
				}

			}
		};

		Thread t5 = new Thread() {
			public void run() {

				synchronized (resource2) {
					System.out.println("thread 5: locked resource 5");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource3) {
						System.out.println("thread 5: locked resource 4");
					}
				}
			}
		};

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}