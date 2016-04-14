package catjump;

public class thread implements Runnable {
	public long jumpingTime = 350;
	Cat c;

	public thread(Cat c) {
		this.c = c;
	}

	public void run() {
		try {
			Thread.sleep(jumpingTime);
			c.setJumping(false);
			Thread.sleep(330);
			c.setJump(false);
		} catch (Exception e) {
			e.printStackTrace();
			new Thread(this).start();
			System.exit(0);
		}
	}
}