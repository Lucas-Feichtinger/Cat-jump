package catjump;

import Menu.EscMenu;

public class ThreadEndScreen implements Runnable {
	private long deathTime = 500;

	private Keying k;

	public ThreadEndScreen(Keying k) {
		this.k = k;
	}

	public void run() {
		try {
			Thread.sleep(deathTime);
			EscMenu esc = new EscMenu("You Died!");
			EscMenu.main(null);
			k.setEscape(true);
		} catch (Exception e) {
			e.printStackTrace();
			new Thread(this).start();
			System.exit(0);
		}
	}
}