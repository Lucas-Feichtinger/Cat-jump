package catjump;

public class ThreadCat implements Runnable {
	public long jumpingTime = 350;
	Cat c;

	public ThreadCat(Cat c) {
		this.c = c;
	}

	public void run() {
		try {
			Thread.sleep(jumpingTime);
			c.setJumping(false);
		} catch (Exception e) {
			e.printStackTrace();
			new Thread(this).start();
			System.exit(0);
		}
	}
}