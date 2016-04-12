package catjump;

public class thread implements Runnable{
		public long jumpingTime = 200;
		public void run(){
			try{
				Thread.sleep(jumpingTime);
			}catch(Exception e){
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}